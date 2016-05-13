package com.GasStore.app.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GasStore.app.Entities.Inventory;
import com.GasStore.app.Repositories.InventoryRepository;
import com.GasStore.app.Service.InventoryService;

@Service
public class InventoryServiceimpl implements InventoryService {
	@Autowired
	private InventoryRepository service;

	@Override
	public List<Inventory> findAllInventory() {
		return service.findAll();
	}

	@Override
	public boolean Save(Inventory inventory) {
		if (inventory == null) {
			return false;
		} else {
			service.save(inventory);
			return true;
		}
	}

	@Override
	public boolean delete(long id) {
			service.delete(id);
		return true;
	}

	@Override
	public Inventory findByName(String name) {
		return service.findByName(name);
	}

	@Override
	public Inventory findById(long id) {
		return service.findOne(id);
	}

}
