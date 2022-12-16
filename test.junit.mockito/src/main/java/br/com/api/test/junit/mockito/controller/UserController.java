package br.com.api.test.junit.mockito.controller;

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

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.service.UserInterfaceService;
import br.com.api.test.junit.mockito.service.UserService;
import br.com.api.test.junit.mockito.service.impl.UserServiceImpl;

@RestController
@RequestMapping(value="/v1/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	//FindAll
	@GetMapping(value="/listar")
	public ResponseEntity<Object>findAll(){
	return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findAll());	
	}
		
	//create
	@RequestMapping(value = "/adicionar")
	@PostMapping
	public ResponseEntity<User>adicionar(@RequestBody User user){
	return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.create(user));
	}
	
	//read
	@GetMapping(value="/findById/{id}")
	public ResponseEntity<Object>ler(@PathVariable(value="id") int id){
	return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findById(id));		
	}
	
	//update
	@RequestMapping(value = "/update")
	@PutMapping
	public ResponseEntity<Object> atualizar(@RequestBody User user){
	return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.update(user));	
	}
	
	//delete
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Void>delete(@PathVariable int id){
		userServiceImpl.delete(id);
		return ResponseEntity.noContent().build(); // o noContent retorna um conteudo vazio 204
	}
}
