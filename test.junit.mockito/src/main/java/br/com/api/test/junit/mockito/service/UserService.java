package br.com.api.test.junit.mockito.service;

import java.util.List;
import java.util.Optional;
import br.com.api.test.junit.mockito.model.User;
public interface UserService {

	//FindAll
	List<User>findAll();
	//Create
	User create(User user);
	//Read
    Optional<User> findById(int id);
	//Update
	User update(User user);
	//Delete
	public void delete(int id);
	
}
