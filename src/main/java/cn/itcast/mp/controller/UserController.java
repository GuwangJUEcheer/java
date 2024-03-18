package cn.itcast.mp.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.itcast.mp.model.UserInfo;
import cn.itcast.mp.service.TokenService;
import cn.itcast.mp.service.UserService;
import cn.itcast.mp.utils.DateUtils;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/login")
	public String login(UserInfo user) {
		
		return null;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserInfo user) {
		String id = UUID.randomUUID().toString();
		user.setCreateTime(DateUtils.nowTime());
		user.setUpdateTime(DateUtils.nowTime());
		user.setId(id);
		userService.addUser(user);
		return tokenService.createToken(id);
	}
}
