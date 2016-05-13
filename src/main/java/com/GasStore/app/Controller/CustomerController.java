package com.GasStore.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GasStore.app.Entities.Customer;
import com.GasStore.app.Serviceimpl.CustomerServiceimpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private CustomerServiceimpl service;

	@Autowired
	public CustomerController(CustomerServiceimpl service) {
		this.service = service;
	}

	@RequestMapping(value = "/index")
	public String IndexPage() {
		return "customer";
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> findallCustomer() {
		List<Customer> customer = service.findAllCustomer();
		return new ResponseEntity<List<Customer>>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> CreateUser(@PathVariable("id") long id, @RequestBody Customer customer) {
		Customer currentCustomer = service.findById(id);
		if(currentCustomer==null)
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		else
		service.Save(customer);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	// delete data
	@RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable("id") long id) {
		if(service.delete(id))
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);	
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> CreateUser(@RequestBody Customer customer) {
		if(service.Save(customer))
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
}
