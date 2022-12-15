package br.com.api.test.junit.mockito.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.repository.UserRepository;


@Service
public class UserService {

	UserRepository userRepository;
	UserService(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	//FindAll
	public List<User>findAll(){
		return userRepository.findAll(); 
	}
	
	//Create
	public User create(User user){	
		return userRepository.save(user);
	}
	//Read
	public Optional<User> read(int id){
		return userRepository.findById(id);
	}
	//Update
	public User update(User user){
		return userRepository.save(user);
	}
	
	//Delete
	public void delete(int id){
		userRepository.deleteById(id);
	}
}
