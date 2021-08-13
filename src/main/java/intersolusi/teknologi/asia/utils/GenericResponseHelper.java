package intersolusi.teknologi.asia.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import intersolusi.teknologi.asia.model.GenericResponse;

public class GenericResponseHelper {

	public static <T> GenericResponse<T> ok() {
		return status(HttpStatus.OK);
	}
	
	public static <T> GenericResponse<T> ok(T data) {
		return status(HttpStatus.OK, data, null);
	}
	
	public static <T> GenericResponse<T> badRequestError() {
		return status(HttpStatus.BAD_REQUEST);
	}
	
	public static <T> GenericResponse<T> badRequest(List<Map<String, String>> errors) {
		return status(HttpStatus.BAD_REQUEST, errors);
	}
	
	public static <T> GenericResponse<T> internalServerError() {
		return status(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public static <T> GenericResponse<T> internalServerError(String errorMessage) {
		return status(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
	}
	
	private static <T> GenericResponse<T> status(HttpStatus status) {
		return status(status, null, null);
	}
	
	private static <T> GenericResponse<T> status(HttpStatus status, List<Map<String, String>> errors) {
		
		return status(status, null, errors);
	}
	
	private static <T> GenericResponse<T> status(HttpStatus status, String messageError) {
		
		return status(status, null, List.of(createErrorMap(messageError)));
	}
	
	public static <T> GenericResponse<T> status(HttpStatus status, T data, List<Map<String, String>> errors) {
		return GenericResponse.<T>builder()
				.errors(errors)
				.build();
	}
	
	private static Map<String, String> createErrorMap(String errorMessage) {
		Map<String, String> error = new HashMap<>();
		
		error.put("message", errorMessage);
		
		return error;
	}
	
}
