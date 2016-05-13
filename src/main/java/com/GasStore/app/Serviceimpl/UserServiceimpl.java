package com.GasStore.app.Serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.GasStore.app.Entities.MyUser;
import com.GasStore.app.Manager.UserDetailsimpl;
import com.GasStore.app.Repositories.UserRepository;
import com.GasStore.app.Service.UserService;
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceimpl  implements UserService,UserDetailsService{
	private MyUser user;
	@Autowired
	private UserRepository UserRepository;
	@Override
	public boolean Save(MyUser user) {
		//UserRepository.save(user);
		return true;
	}
	@Override
	public MyUser findByUser(String username) {
		user = UserRepository.findByUser(username);
		return user;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user = UserRepository.findByUser(username);
		if(user == null){
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsimpl(user);
	}
	

}
