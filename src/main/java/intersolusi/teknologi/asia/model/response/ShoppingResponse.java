package intersolusi.teknologi.asia.model.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import intersolusi.teknologi.asia.utils.LocalDateSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingResponse {

	@JsonProperty("createddate")
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate createdDate;
	
	private Long id;
	
	private String name;
	
}
