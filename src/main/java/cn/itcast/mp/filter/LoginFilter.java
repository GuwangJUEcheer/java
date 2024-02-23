package cn.itcast.mp.filter;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 自定义的过滤器
 */
@WebFilter(urlPatterns = "/*")//自定义的过滤规则
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException {
		// 对ip地址进行过滤
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		// 获得ip地址
		String ipAddress = request.getRemoteAddr();
		// 统计访问次数并且输出
		HttpSession session = servletRequest.getSession();
		Integer count = Integer.parseInt(session.getAttribute("count").toString());
		if (!Objects.isNull(count)) {
			count++;
		}
		session.setAttribute("count", count);
		session.setAttribute("ipAddress", ipAddress);
		// 放行
		filterchain.doFilter(request, response);
	}
}
