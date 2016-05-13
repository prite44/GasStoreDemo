package com.GasStore.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasStore.app.Entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
		Customer findByShopname(String name);
}
