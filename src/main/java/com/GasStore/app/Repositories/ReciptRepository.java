package com.GasStore.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasStore.app.Entities.Recipt;

public interface ReciptRepository extends JpaRepository<Recipt,Long>{
		Recipt findByorderid(String id);
}
