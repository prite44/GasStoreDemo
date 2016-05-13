package com.GasStore.app.Service;

import java.util.List;

import com.GasStore.app.Entities.Inventory;

public interface InventoryService {
	List<Inventory> findAllInventory();
	Inventory findByName(String name);
	Inventory findById(long id);
	boolean Save(Inventory inventory);
	boolean delete(long id);
}
