package exp.springb.startapp;

import org.springframework.bind.annotation.ControllerAdvice;
import org.springframework.bind.annotation.ExceptionHandler;
import org.springframework.bind.annotation.ResponseBody;
import org.springframework.bind.annotation.ResponseStatus;

@ControllerAdvice 
class PageNotFoundAdvice {
	
	@ResponseBody
	@ExceptionHandler( PageNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND);
	String pageNotFoundHandler(PageNotFoundException ex) {
		return ex.getMessage();
	}
}