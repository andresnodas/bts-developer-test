package intersolusi.teknologi.asia.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import intersolusi.teknologi.asia.entity.Shopping;
import intersolusi.teknologi.asia.model.GenericResponse;
import intersolusi.teknologi.asia.model.request.ShoppingRequest;
import intersolusi.teknologi.asia.model.response.ShoppingResponse;
import intersolusi.teknologi.asia.repository.ShoppingRepository;
import intersolusi.teknologi.asia.service.ShoppingService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {
	
	private ShoppingRepository shoppingRepository;
	
	@Override
	public GenericResponse<ShoppingResponse> createShopping(ShoppingRequest request) {
		
		Shopping shopping = new Shopping();
		BeanUtils.copyProperties(request.getShopping(), shopping);
		
		Shopping storedShopping = shoppingRepository.save(shopping);
		
		return createGenericShoppingResponse(storedShopping);
	}

	@Override
	public GenericResponse<ShoppingResponse> updateShopping(Long id, ShoppingRequest request) {
		
		Shopping shopping = shoppingRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Shopping with id " + id + " not found !");
		});
		
		BeanUtils.copyProperties(request.getShopping(), shopping);
		
		Shopping storedShopping = shoppingRepository.save(shopping);
		
		return createGenericShoppingResponse(storedShopping);
	}

	@Override
	public List<GenericResponse<ShoppingResponse>> getShoppings() {
		List<Shopping> shoppings = shoppingRepository.findAll();
		return createListGenericShoppingResponse(shoppings);
	}

	@Override
	public GenericResponse<ShoppingResponse> getShopping(Long id) {
		
		Shopping shopping = shoppingRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Shopping with id " + id + " not found !");
		});
		
		return createGenericShoppingResponse(shopping);
	}

	@Override
	public void deleteShopping(Long id) {
		
		Shopping shopping = shoppingRepository.findById(id).orElseThrow(() -> {
			throw new EntityNotFoundException("Shopping with id " + id + " not found !");
		});
		
		shoppingRepository.delete(shopping);
	
	}
	
	private GenericResponse<ShoppingResponse> createGenericShoppingResponse(Shopping shopping) {
		
		GenericResponse<ShoppingResponse> response = new GenericResponse<>();
		ShoppingResponse shoppingResponse = new ShoppingResponse();
		
		BeanUtils.copyProperties(shopping, shoppingResponse);
		
		response.setData(shoppingResponse);
		
		return response;
	}
	
	private List<GenericResponse<ShoppingResponse>> createListGenericShoppingResponse(List<Shopping> shoppings) {
		
		return shoppings.stream()
				.map(this::createGenericShoppingResponse)
				.collect(Collectors.toList());
		
	}

}
