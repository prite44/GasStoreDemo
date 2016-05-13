package com.GasStore.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasStore.app.Entities.MyUser;

public interface UserRepository  extends JpaRepository<MyUser,Long>{
	MyUser findByUser(String username);
}
