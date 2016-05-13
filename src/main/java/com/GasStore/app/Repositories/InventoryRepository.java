package com.GasStore.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasStore.app.Entities.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory,Long>{
	Inventory findByName(String name);
}
