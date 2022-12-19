package br.com.api.test.junit.mockito.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.model.dto.UserDTO;
import br.com.api.test.junit.mockito.repository.UserRepository;
import br.com.api.test.junit.mockito.service.UserService;
import br.com.api.test.junit.mockito.service.exceptions.DataIntegratyViolationException;
import br.com.api.test.junit.mockito.service.exceptions.ObjectNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	UserRepository userRepository;
	UserServiceImpl(UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<User> findAll() {
		List<User>lista = userRepository.findAll();
		return lista;
	}

	@Override
	public User create(UserDTO userDTO) {
		findByEmail(userDTO);
		return userRepository.save(mapper.map(userDTO, User.class));
	}

	@Override
	public Optional<User> findById(int id) {
		Optional<User> usuario = userRepository.findById(id);
		return Optional.ofNullable(usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"))); // verifica se tem ou nao ususario cadastrado com o id
	}

	@Override
	public User update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	private void findByEmail(UserDTO userDTO){
		
		Optional<User> user = userRepository.findByEmail(userDTO.getEmail());
		if(user.isPresent()){
			throw new DataIntegratyViolationException("Email ja Cadastrado");
		}
		
	}
	
}
