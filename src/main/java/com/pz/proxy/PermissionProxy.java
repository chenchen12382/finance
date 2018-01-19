package com.pz.proxy;
import com.pz.utils.LoginUserUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class PermissionProxy{
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private HttpServletResponse response;

	/**
	 * 定义切入点
	 */
	@Pointcut("execution(* com.pz.controller.*.*(..))")
	public void pointcut() {

	}

	@Around(value="pointcut()")
	public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable { // pjp连接点对象
		// 用户是否登录
		Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
		String uri = request.getRequestURI();
		if("/".equals(uri) ||"/login".equals(uri) ||userId!=null){
			return 	pjp.proceed();
		}
		return "login";
	}
}
