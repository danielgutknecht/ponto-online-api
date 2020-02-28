package com.gutk.pontoonline.api.controllers;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.exceptions.RecordNotFoundException;
import com.gutk.pontoonline.api.services.FuncionarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class funcionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Transactional
	@RequestMapping(value = "/funcionarios", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAlunos() {
		return new ResponseEntity<>(funcionarioService.getAllFuncionarios(), HttpStatus.OK);
	}

	@GetMapping("/produtos/id/{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Funcionario func = funcionarioService.getByIdFuncionario (id);

		return new ResponseEntity<Funcionario>(func, HttpStatus.OK);
	}

}
