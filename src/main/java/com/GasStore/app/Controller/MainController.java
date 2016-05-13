package com.GasStore.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.GasStore.app.Entities.MyUser;
import com.GasStore.app.Entities.Role;
import com.GasStore.app.Repositories.UserRepository;

@Controller
public class MainController {
	private MyUser myuser;
	private UserRepository service;
	private PasswordEncoder passwordeEncoder;

	@Autowired
	public MainController(UserRepository service, PasswordEncoder passwordeEncoder) {
		this.service = service;
		this.passwordeEncoder = passwordeEncoder;
	}

	@RequestMapping(value = "/")
	public String main() {
		return "main";
	}

	@RequestMapping("/main")
	public String testAccessPage() {
		return "main";
	}

	@RequestMapping("/signup")
	public String sigup() {
		return "signup";
	}

	@RequestMapping(value = "/signup/checkuser/{name}", method = RequestMethod.PUT)
	public ResponseEntity<Boolean> update(@PathVariable("name") String name) {
		MyUser user = service.findByUser(name);
		if (user == null)
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		else
			return new ResponseEntity<Boolean>(false, HttpStatus.OK);
	}

	@RequestMapping(value = "/signup/create", method = RequestMethod.POST)
	public ResponseEntity<Void> creat(@RequestBody MyUser user) {
		myuser = new MyUser();
		myuser.setUser(user.getUser());
		myuser.setPassword(passwordeEncoder.encode(user.getPassword()));
		myuser.setStatus(true);
		myuser.setRole(getAmdinRole());
		service.save(myuser);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	public Role getAmdinRole() {
		Role role = new Role();
		role.setId(1);
		role.setRoleMapping("ADMIN");
		return role;
	}
}
