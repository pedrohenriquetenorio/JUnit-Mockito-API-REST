package br.com.api.test.junit.mockito.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.model.dto.UserDTO;
import br.com.api.test.junit.mockito.service.UserService;
import br.com.api.test.junit.mockito.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/v1/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper; // BEAN CRIADO PARA INSTANCIAR O MAPPER 
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<List<UserDTO>> findAll(){
		List<User> list = userService.findAll();
		List<UserDTO> listDTO = list.stream().map(user -> mapper.map(user, UserDTO.class)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);	
	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<UserDTO>adicionar(@RequestBody UserDTO userDTO){
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userServiceImpl.create(userDTO).getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<UserDTO>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(mapper.map(userServiceImpl.findById(id), UserDTO.class));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody UserDTO user){
	return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.update(user));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		userServiceImpl.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
}
