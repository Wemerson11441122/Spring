package com.wemerson.springjava.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wemerson.springjava.domain.Cliente;
import com.wemerson.springjava.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {



		@Autowired
		private ClienteService service;
		
		@GetMapping("/{id}")
		public ResponseEntity<Cliente> buscar(@PathVariable Integer id) {
			Cliente obj = service.buscar(id);
			return ResponseEntity.ok().body(obj);
		}
	
}
