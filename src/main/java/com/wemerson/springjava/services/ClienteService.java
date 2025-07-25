package com.wemerson.springjava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemerson.springjava.domain.Categoria;
import com.wemerson.springjava.domain.Cliente;
import com.wemerson.springjava.repositories.ClienteRepository;
import com.wemerson.springjava.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	public Cliente buscar(Integer id) {
		 Optional<Cliente> obj = repository.findById(id);
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
}
