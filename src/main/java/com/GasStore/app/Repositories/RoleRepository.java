package com.GasStore.app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GasStore.app.Entities.Role;

public interface RoleRepository  extends JpaRepository<Role,Long>{
}
