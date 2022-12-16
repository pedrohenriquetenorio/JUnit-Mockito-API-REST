package br.com.api.test.junit.mockito.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.api.test.junit.mockito.model.User;
import br.com.api.test.junit.mockito.repository.UserRepository;


@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UserRepository repository;
	
	
	@Bean
	public void startDB(){
		User u1 = new User(null, "Pedro","a@gmail.comn","123");
		User u2 = new User(null, "Henrique","b@gmail.comn","123");
		User u3 = new User(null, "Tenório","c@gmail.comn","123");
		
		repository.saveAll(List.of(u1,u2,u3));
}
}
