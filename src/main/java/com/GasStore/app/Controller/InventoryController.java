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

import com.GasStore.app.Entities.Inventory;
import com.GasStore.app.Service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	private InventoryService service;

	@Autowired
	public InventoryController(InventoryService service) {
		this.service = service;
	}

	@RequestMapping("/index")
	public String index() {
		return "inventory";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> creat(@RequestBody Inventory inventory) {
		if (service.Save(inventory))
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<Inventory>> findall() {
		List<Inventory> Stock = service.findAllInventory();
		return new ResponseEntity<List<Inventory>>(Stock, HttpStatus.OK);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody Inventory inventory) {
		Inventory currenInventory = service.findById(id);
		if (currenInventory == null)
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		else
			service.Save(inventory);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/delete{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") long id) {
		if(service.delete(id))
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);	
	}
}
