package com.example.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService service;
	
	
	@PostMapping
	public void orderSave(@RequestBody Order order) {
		service.save(order);
	}
	
	@GetMapping("/{id}")
	List<Order> getUserById(@PathVariable int id) {
		return service.getOrderById(id);
	}
	
	@GetMapping("/store/{storeId}")
	List<Order> getOrderByStoreId(@PathVariable int storeId) {
		
		return service.getOrderByStoreId(storeId);
	}
	
	@GetMapping("/Customer/{customerId}")
	List<Order> getOrderByCustomerId(@PathVariable int customerId) {

		return service.getOrderByCustomerId(customerId);
	}
}
