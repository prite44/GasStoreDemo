package com.GasStore.app.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GasStore.app.Entities.Inventory;
import com.GasStore.app.Entities.OrderList;
import com.GasStore.app.Entities.Recipt;
import com.GasStore.app.Repositories.InventoryRepository;
import com.GasStore.app.Repositories.ReciptRepository;
import com.GasStore.app.Service.ReciptService;

@Service
public class ReciptServiceimpl implements ReciptService {
	private Inventory inventory;
	@Autowired
	private ReciptRepository service;
	@Autowired
	private InventoryRepository serviceInventory;

	@Override
	public List<Recipt> findAllRecipt() {
		return service.findAll();
	}

	@Override
	public Recipt findById(String id) {
		return service.findByorderid(id);
	}

	@Override
	public boolean Save(Recipt recipt) {
		if (recipt != null) {
			for(OrderList list : recipt.getList()){
				inventory = serviceInventory.findByName(list.getName());
				if(inventory!=null){
					inventory.setQuality(inventory.getQuality()-list.getQuality());
					serviceInventory.save(inventory);
				}
			}
			service.save(recipt);
			return true;
		} else
			return false;
	}

}
