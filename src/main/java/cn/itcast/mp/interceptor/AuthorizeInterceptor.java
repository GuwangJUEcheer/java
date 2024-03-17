package cn.itcast.mp.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

//自定义实现拦截器
public class AuthorizeInterceptor  implements HandlerInterceptor{

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		
//		//记录登录次数
//		// 获得ip地址
//		String ipAddress = request.getRemoteAddr();
//		// 统计访问次数并且输出
//		HttpSession session = request.getSession();
//		Integer count = Integer.parseInt(session.getAttribute("count").toString());
//		if (!Objects.isNull(count)) {
//			count++;
//		}
//		session.setAttribute("count", count);
//		session.setAttribute("ipAddress", ipAddress);
    	
		return true;
    }
}

