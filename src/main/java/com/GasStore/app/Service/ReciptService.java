package com.GasStore.app.Service;

import java.util.List;

import com.GasStore.app.Entities.Recipt;

public interface ReciptService {
	List<Recipt> findAllRecipt();
	Recipt findById(String id);
	boolean Save(Recipt recipt);
}
