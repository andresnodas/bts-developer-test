package intersolusi.teknologi.asia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String username;

	@Column
	private String password;

	@Column
	private String email;

	@Column
	private String phone;

	@Column
	private String country;

	@Column
	private String city;

	@Column
	private String postcode;

	@Column
	private String name;

	@Column
	private String address;
	
}
