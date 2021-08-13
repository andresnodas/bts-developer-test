package intersolusi.teknologi.asia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import intersolusi.teknologi.asia.model.GenericResponse;
import intersolusi.teknologi.asia.model.request.ShoppingRequest;
import intersolusi.teknologi.asia.model.response.ShoppingResponse;
import intersolusi.teknologi.asia.service.ShoppingService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/shopping")
@AllArgsConstructor
public class ShoppingController {

	private ShoppingService shoppingService;
	
	@GetMapping
	public List<GenericResponse<ShoppingResponse>> getShoppings() {
		return shoppingService.getShoppings();
	}
	
	@GetMapping(path = "/{id}")
	public GenericResponse<ShoppingResponse> getShoppping(@PathVariable("id") Long id) {
		return shoppingService.getShopping(id);
	}
	
	@PostMapping
	public GenericResponse<ShoppingResponse> createShopping(@RequestBody ShoppingRequest request) {
		return shoppingService.createShopping(request);
	}
	
	@PutMapping(path = "/{id}")
	public GenericResponse<ShoppingResponse> updateShopping(@PathVariable("id") Long id, @RequestBody ShoppingRequest request) {
		return shoppingService.updateShopping(id, request);
	}
	
	@DeleteMapping(path = "/{id}")
	public GenericResponse<?> deleteShopping(@PathVariable("id") Long id) {
		
		shoppingService.deleteShopping(id);
		
		return new GenericResponse<>();
	}
	
	
}
