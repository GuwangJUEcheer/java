package cn.itcast.mp.controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;

import cn.itcast.mp.model.LoginResponse;
import cn.itcast.mp.model.LoginResponse.LoginResult;
import cn.itcast.mp.model.UserInfo;
import cn.itcast.mp.service.TokenService;
import cn.itcast.mp.service.UserService;
import cn.itcast.mp.utils.DateUtils;

@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody Map<String, String> credentials) {
		
	    String userName = credentials.get("userName");
	    String password = credentials.get("password");
		LoginResponse response = new LoginResponse();
		if(StringUtils.isEmpty(userName)||StringUtils.isEmpty(password)) {
			response.setLoginResult(LoginResult.NG.name());
			return response;
		}
		UserInfo user = userService.findUserByName(userName);
		if(user == null) {
			response.setLoginResult(LoginResult.NG.name());
			return response;
		}
		if(!user.getPassword().equals(password)) {
			response.setLoginResult(LoginResult.NG.name());
			return response;
		}
		
		response.setLoginResult(LoginResult.OK.name());
		response.setUserName(userName);
		response.setToken(tokenService.createToken(user.getId()));
		response.setUserId(user.getId());
		return response;
	}
	
	@PostMapping("/register")
	public LoginResponse register(@RequestBody UserInfo user) {
		String id = UUID.randomUUID().toString();
		user.setCreateTime(DateUtils.nowTime());
		user.setUpdateTime(DateUtils.nowTime());
		user.setId(id);
		userService.addUser(user);
		LoginResponse response = new LoginResponse();
		response.setToken(tokenService.createToken(id));
		response.setUserId(id);
		response.setUserName(user.getUsername());
		return response;
	}
}
