package com.ybz.exception;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class CustomExceptionResolver implements HandlerExceptionResolver {

	//前端控制器DispatcherServlet在进行HandlerMapping、调用HandlerAdapter执行Handler过程中，如果遇到异常就会执行此方法
	//handler最终要执行的Handler，它的真实身份是HandlerMethod
	//exception ex就是接收到异常信息
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
		//输出异常


		//统一异常处理代码
		//针对系统自定义的CustomException异常，就可以直接从异常类中获取异常信息，将异常处理在错误页面展示
		//异常信息
		String message = null;
		CustomException customException = null;
		CustomRuntimeException customRuntimeException = null;

		String imformation = "操作失败,请求内容错误";
		String code = "-100";
		//如果ex是系统 自定义的异常，直接取出异常信息
		if(ex instanceof CustomException){
			customException = (CustomException)ex;
			message = customException.getMessage();
		}else if(ex instanceof CustomRuntimeException){
			customRuntimeException = (CustomRuntimeException)ex;
			message = customRuntimeException.getMessage();
			code = customRuntimeException.getCode();
			imformation = customRuntimeException.getMessage();
		}else if(ex instanceof CustomBusinessException){
			code = ((CustomBusinessException) ex).getCode();
			message = ex.getMessage();
			imformation = ex.getMessage();
		}else{
			//针对非CustomException异常，对这类重新构造成一个CustomException，异常信息为“未知错误”
			customException = new CustomException("未知错误");
			message = customException.getMessage();
		}
		
		//错误 信息
		request.setAttribute("message", message);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		try {
			PrintWriter out = response.getWriter();

			JSONObject json = new JSONObject();
			json.put("code",code);
			json.put("information",imformation);
			out.write(json.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ModelAndView();
	}



}
