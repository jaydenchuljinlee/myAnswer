package egovframework.myAnwser.cmmn.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Controller
public class CmmnController extends HandlerInterceptorAdapter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info("===========================          START         ===========================");
		logger.info(" Request URI \t:  " + request.getRequestURI());

		Enumeration<String> paramNames = request.getParameterNames();

		while (paramNames.hasMoreElements()) {
			String key = (String) paramNames.nextElement();
			String[] values = request.getParameterValues(key);
			
			if (values.length > 1) {
				for (int i = 0; i < values.length; i++) {
					logger.debug(" RequestParameter Data ==>  " + key + "[" + i + "]" + " : " + values[i] + "");
				}
			} else {
				logger.debug(" RequestParameter Data ==>  " + key + " : " + values[0] + "");
			}
		}

		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("===========================          END           ===========================");
		super.postHandle(request, response, handler, modelAndView);
	}

}
