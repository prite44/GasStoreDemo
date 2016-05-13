package com.GasStore.app.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GasStore.app.Entities.Customer;
import com.GasStore.app.Repositories.CustomerRepository;
import com.GasStore.app.Service.CustomerService;

@Service
public class CustomerServiceimpl implements CustomerService {
	@Autowired
	private CustomerRepository service;
	private Customer customer;


	@Override
	public Customer findByShopname(String name) {
		customer = service.findByShopname(name);
		return customer;
	}

	@Override
	public boolean Save(Customer customer) {
		if(customer==null)
		return false;
		else
		service.save(customer);
		return true;
	}

	@Override
	public boolean delete(long id) {
		service.delete(id);
		return true;
	}
	@Override
	public Customer findById(long id) {
		customer = service.findOne(id);
		return customer;
	}

	@Override
	public List<Customer> findAllCustomer() {
		return service.findAll();
	}
	

}
