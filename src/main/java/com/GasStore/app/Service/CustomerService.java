package com.GasStore.app.Service;

import java.util.List;

import com.GasStore.app.Entities.Customer;

public interface CustomerService {
	List<Customer> findAllCustomer();
	Customer findByShopname(String name);
	Customer findById(long id);
	boolean Save(Customer customer);
	boolean delete(long id);
}
