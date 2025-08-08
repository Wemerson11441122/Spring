package com.wemerson.springjava.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemerson.springjava.domain.Pedido;
import com.wemerson.springjava.repositories.PedidoRepository;
import com.wemerson.springjava.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	public Pedido buscar(Integer id) {
	 Optional<Pedido> obj = repository.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
			 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
}
}