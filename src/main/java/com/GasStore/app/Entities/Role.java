package com.GasStore.app.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ARole")
public class Role {
	@Id
	private long id;
	@Column (name="Role")
	private String RoleMapping;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRoleMapping() {
		return RoleMapping;
	}
	public void setRoleMapping(String roleMapping) {
		RoleMapping = roleMapping;
	}
	
}
