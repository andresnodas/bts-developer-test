package intersolusi.teknologi.asia.model.request;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInRequest {

	@NotEmpty
	private String email;

	@NotEmpty
	private String password;
	
}
