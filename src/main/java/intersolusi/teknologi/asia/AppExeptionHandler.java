package intersolusi.teknologi.asia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import intersolusi.teknologi.asia.model.GenericResponse;
import intersolusi.teknologi.asia.utils.GenericResponseHelper;

@RestControllerAdvice
public class AppExeptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public GenericResponse<Object> handlerBindException(BindException exception, WebRequest webRequest) {
		
		List<Map<String, String>> errors = new LinkedList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		for(FieldError fieldError : fieldErrors) {
			
			Map<String, String> error = new HashMap<>();
			error.put("field", fieldError.getField());
			error.put("message", fieldError.getDefaultMessage());
			
			errors.add(error);
		}
		
		return GenericResponseHelper.badRequest(errors);
	}

	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public GenericResponse<?> handlerOtherExceptions(Exception exception, WebRequest webRequest) {
		return GenericResponseHelper.internalServerError(exception.getMessage());
	}
	
}
