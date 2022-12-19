package br.com.api.test.junit.mockito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.model.dto.UserDTO;
@Service
public interface UserService {

	//FindAll
	List<User>findAll();
	//Create
	User create(UserDTO userDTO);
	//Read
    Optional<User> findById(int id);
	//Update
	User update(UserDTO userDTO);
	//Delete
	public void delete(int id);
	
}
