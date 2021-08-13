package intersolusi.teknologi.asia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericResponse<T> {

	private T data;
	
}
