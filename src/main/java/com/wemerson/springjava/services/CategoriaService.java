package com.wemerson.springjava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wemerson.springjava.domain.Categoria;
import com.wemerson.springjava.repositories.CategoriaRepository;
import com.wemerson.springjava.services.exceptions.DataIntegrityException;
import com.wemerson.springjava.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria find(Integer id) {
	 Optional<Categoria> obj = categoriaRepository.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			   categoriaRepository.deleteById(id);	
		} catch (DataIntegrityViolationException e) {
         throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
     
        }
	
}