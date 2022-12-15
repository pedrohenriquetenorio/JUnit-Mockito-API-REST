package br.com.api.test.junit.mockito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.test.junit.mockito.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
}
