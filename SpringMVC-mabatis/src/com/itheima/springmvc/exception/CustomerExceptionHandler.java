package com.itheima.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理
 * @author zh2
 *
 */
public class CustomerExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object obj, Exception e) {
		ModelAndView mav = new ModelAndView();
		if(e instanceof MessageException){
			MessageException me = (MessageException)e;
			mav.addObject("error", me.getMsg());
		}else{			
			mav.addObject("error", "您走丢了！");
		}
		mav.setViewName("error");
		return mav;
	}

}
