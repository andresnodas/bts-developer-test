package intersolusi.teknologi.asia.model.request;

import javax.validation.constraints.NotNull;

import intersolusi.teknologi.asia.model.UserModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

	@NotNull
	private UserModel user;
	
}
