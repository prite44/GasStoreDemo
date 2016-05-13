package com.GasStore.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GasStore.app.Entities.Recipt;
import com.GasStore.app.Serviceimpl.ReciptServiceimpl;
@Controller
@RequestMapping("/receipt")
public class ReceiptController {
	private ReciptServiceimpl service;

	@Autowired
	public ReceiptController(ReciptServiceimpl service) {
		this.service = service;
	}

	@RequestMapping("/index")
	public String index() {
		return "receipt";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public ResponseEntity<Void> creat(@RequestBody Recipt recpit) {
		if (service.Save(recpit))
			return new ResponseEntity<Void>(HttpStatus.OK);
		else
			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}

}
