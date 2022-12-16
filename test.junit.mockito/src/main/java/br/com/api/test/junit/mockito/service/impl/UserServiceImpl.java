package br.com.api.test.junit.mockito.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.repository.UserRepository;
import br.com.api.test.junit.mockito.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	UserRepository userRepository;
	UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User create(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(int id) {
		Optional<User> usuario = userRepository.findById(id);
		return Optional.ofNullable(usuario.orElse(null)); // verifica se tem ou nao ususario cadastrado com o id
	}

	@Override
	public User update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
