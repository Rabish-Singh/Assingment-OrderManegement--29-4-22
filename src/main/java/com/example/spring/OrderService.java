package com.example.spring;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;

	public void save(Order order) {
		repository.save(order);
		
	}

	public List<Order> getAllOrder() {
		return repository.findAll();
	}

	public List<Order> getOrderById(int id) {
		List<Order> filteredOrder = getAllOrder().stream().filter((order) -> order.getId().equals(id))
				.collect(Collectors.toList());
		return filteredOrder;
	}
	
	

	public List<Order> getOrderByStoreId(int storeId) {
		List<Order> filteredOrder = getAllOrder().stream().filter((order) -> order.getStoreId()==(storeId)).collect(Collectors.toList());
				
		return filteredOrder;
	}

	public List<Order> getOrderByCustomerId(int customerId) {
		List<Order> filteredUsers = getAllOrder().stream().filter((order) -> order.getCustomerId() == customerId).collect(Collectors.toList());
		return filteredUsers;
	}

}
