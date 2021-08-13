package intersolusi.teknologi.asia.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingModel {

	@JsonProperty("createddate")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate createdDate;
	
	private String name;
	
}
