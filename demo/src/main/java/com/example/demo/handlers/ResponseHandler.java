package com.example.demo.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseHandler extends ResponseEntityExceptionHandler {
	
	private class ErrorObject{
		private String type;
		private String title;
		private int status;
		private String detail;
		
		public ErrorObject() {}
		
		public ErrorObject(String newException, String newTitle, int newStatus, String newDetail ) {
			type = newException;
			title = newTitle;
			status = newStatus;
			detail = newDetail;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}
		
		
	}

	@ExceptionHandler(value = {IllegalArgumentException.class})
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
		ErrorObject newBody = new ErrorObject(ex.getClass().getSimpleName(), ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getCause().getMessage());
		return handleExceptionInternal(ex, newBody, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	// Se podría devolver directamente un new ReponseEntity<ErrorObject>
	
	@ExceptionHandler(value = Exception.class)
	  public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
	    // If the exception is annotated with @ResponseStatus rethrow it and let
	    // the framework handle it - like the OrderNotFoundException example
	    // at the start of this post.
	    // AnnotationUtils is a Spring Framework utility class.
//	    if (AnnotationUtils.findAnnotation
//	                (ex.getClass(), ResponseStatus.class) != null)
//	      throw ex;

	    
	    // Otherwise setup and send the user to a default error-view.
	    ModelAndView mav = new ModelAndView();
	    ErrorObject newBody = new ErrorObject(ex.getClass().getSimpleName(), ex.getMessage(), HttpStatus.BAD_REQUEST.value(), ex.getCause() == null ? "" : ex.getCause().getMessage());
//	    mav.addObject(newBody);
//	    mav.addObject("exception", ex);
//	    mav.addObject("url", req.getRequestURL());
//	    mav.setViewName("error");
	    mav.setStatus(HttpStatus.BAD_REQUEST);
	    return mav;
	  }
}
