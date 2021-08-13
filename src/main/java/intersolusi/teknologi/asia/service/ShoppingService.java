package intersolusi.teknologi.asia.service;

import java.util.List;

import intersolusi.teknologi.asia.model.GenericResponse;
import intersolusi.teknologi.asia.model.request.ShoppingRequest;
import intersolusi.teknologi.asia.model.response.ShoppingResponse;

public interface ShoppingService {

	GenericResponse<ShoppingResponse> createShopping(ShoppingRequest request);
	
	GenericResponse<ShoppingResponse> updateShopping(Long id, ShoppingRequest request);
	
	List<GenericResponse<ShoppingResponse>> getShoppings();
	
	GenericResponse<ShoppingResponse> getShopping(Long id);
	
	void deleteShopping(Long id);
	
}
