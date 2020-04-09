package com.gutk.pontoonline.api.endpoint.v1.controller;


import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gutk.pontoonline.api.endpoint.response.exceptions.BusinessException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.FuncionarioNotFoundException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.endpoint.v1.dto.FuncionarioDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.LancamentoDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.FuncionarioDTOInput;
import com.gutk.pontoonline.api.endpoint.v1.mapper.FuncionarioMapperManual;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.services.EmpresaService;
import com.gutk.pontoonline.api.services.FuncionarioService;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class FuncionarioController
{
	@Autowired
	private FuncionarioService funcionarioService;
		
	@Autowired
	private FuncionarioMapperManual funcionarioMapperManual;

	@GetMapping(value = "/funcionarios")
	public CollectionModel<FuncionarioDTO> listarTodosFuncionarios(Pageable pageable)
	{
		return funcionarioMapperManual.toCollectionModel(funcionarioService.listarTodosFuncionarios(pageable));
	}

	@GetMapping(value = "/funcionarios/cpf/{cpf}")
	public FuncionarioDTO buscarFuncionarioPorCpf(@PathVariable String cpf)
	{
		return funcionarioMapperManual.toModel(funcionarioService.buscarFuncionarioPorCpf(cpf));
	}

	@GetMapping(value = "/funcionarios/email/{email}")
	public FuncionarioDTO buscarEmpresaPorEmail(@PathVariable String email)
	{
		return funcionarioMapperManual.toModel(funcionarioService.buscarFuncionarioPorEmail(email));
	}

	@GetMapping(value = "/funcionarios/{id}")
	public FuncionarioDTO buscarEmpresaPorId(@PathVariable Long id)
	{
		return funcionarioMapperManual.toModel(funcionarioService.buscarFuncionarioPorId(id));
	}	

	@PostMapping(value = "/funcionarios")
	@ResponseStatus(value = HttpStatus.CREATED)
	public FuncionarioDTO save(@RequestBody @Valid FuncionarioDTOInput funcionarioDtoInput)
	{
		try
		{
			Funcionario funcionario = funcionarioMapperManual.toDomainObject(funcionarioDtoInput);			

			FuncionarioDTO funcionarioDTO = funcionarioMapperManual
					.toModel(funcionarioService.salvarFuncionario(funcionario));

			return funcionarioDTO;
		} catch (FuncionarioNotFoundException ex)
		{
			throw new BusinessException(ex.getMessage(), ex);
		}
	}

	@PutMapping(value = "/funcionarios/{id}")
	public FuncionarioDTO atualizaFuncionario(@PathVariable() Long id, @RequestBody @Valid FuncionarioDTOInput funcionarioDtoInput)
	{
		try
		{
			Funcionario funcionarioCorrente = funcionarioService.buscarFuncionarioPorId(id);

			Funcionario funcionario = funcionarioMapperManual.copyToDomainObject(funcionarioDtoInput, funcionarioCorrente);

			return funcionarioMapperManual.toModel(funcionarioService.atualizarFuncionario(funcionario));
		} catch (FuncionarioNotFoundException ex)
		{
			throw new BusinessException(ex.getMessage(), ex);
		}
	}

	@DeleteMapping("funcionario/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarFuncionarioPorId(@PathParam("id") Long id) {
		funcionarioService.deletarPorId(id);
	}

}
