package intersolusi.teknologi.asia.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

	private String username;

	@JsonProperty("encrypted_password")
	private String password;

	private String email;

	private String phone;

	private String country;

	private String city;

	private String postcode;

	private String name;

	private String address;
	
}
