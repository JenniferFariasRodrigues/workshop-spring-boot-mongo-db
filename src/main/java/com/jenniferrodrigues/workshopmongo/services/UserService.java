package com.jenniferrodrigues.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jenniferrodrigues.workshopmongo.domain.User;
import com.jenniferrodrigues.workshopmongo.repository.UserRepository;
import com.jenniferrodrigues.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	//O controlador acessa o repositorio
	// instanciar automaticamente um objeto=autowired
	@Autowired
	private UserRepository repo;

	public List<User> findAll() {
		return repo.findAll();

	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
}
