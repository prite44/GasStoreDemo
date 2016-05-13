package com.GasStore.app.Service;

import com.GasStore.app.Entities.MyUser;

public interface UserService {
	MyUser findByUser(String user);
	boolean Save(MyUser user);
}
