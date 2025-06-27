package com.wemerson.springjava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemerson.springjava.domain.Categoria;
import com.wemerson.springjava.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
	 Optional<Categoria> obj = repository.findById(id);
			 return obj.orElse(null);
	}
	
}
