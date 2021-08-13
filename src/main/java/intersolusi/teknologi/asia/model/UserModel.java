package intersolusi.teknologi.asia.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	@NotEmpty
	private String username;

	@NotEmpty
	@JsonProperty("encrypted_password")
	private String password;

	@Email
	private String email;

	private String phone;

	private String country;

	private String city;

	private String postcode;

	@NotEmpty
	private String name;

	private String address;
	
}
