package com.GasStore.app.Manager;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.GasStore.app.Entities.MyUser;
import com.GasStore.app.Entities.Role;

public class UserDetailsimpl extends  User{
	private static final long serialVersionUID = 6848308342955082450L;
	private MyUser user;
	public UserDetailsimpl(MyUser user){
		super(user.getUser(), user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole().getRoleMapping()));
		this.user = user;
	}
	public MyUser getUser() {
		return user;
	}
	public Role getRole() {
		return user.getRole();
	}


}
