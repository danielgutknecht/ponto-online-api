package com.gutk.pontoonline.api.endpoint.v1.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gutk.pontoonline.api.endpoint.response.exceptions.BusinessException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.EmpresaNotFoundException;
import com.gutk.pontoonline.api.endpoint.v1.answersapi.EmpresaAnswerApi;
import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.EmpresaDTOInput;
import com.gutk.pontoonline.api.endpoint.v1.mapper.EmpresaMapperManual;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.services.EmpresaService;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class EmpresaController
{

	@Autowired
	private EmpresaService empresaService;

	@Autowired
	private EmpresaMapperManual empresaMapperManual;

	@GetMapping(value = "/empresas")
	public CollectionModel<EmpresaDTO> findAllEmpresa()
	{
		return empresaMapperManual.toCollectionModel(empresaService.listarTodasEmpresas());
	}

	@GetMapping(value = "/empresas/cnpj/{cnpj}")
	public EmpresaDTO buscarEmpresaPorCnpj(@PathVariable String cnpj)
	{
		return empresaMapperManual.toModel(empresaService.buscarEmpresaPorCnpj(cnpj));
	}
	
	/*
	@GetMapping(value = "/empresas/{id}")
	public EmpresaDTO buscarEmpresaPorId(@PathVariable Long id)
	{
		return empresaMapperManual.toModel(empresaService.buscarEmpresaPorId(id));
	}
	*/	
	
	@PostMapping(value = "/empresas")
	@ResponseStatus(value = HttpStatus.CREATED)
	public EmpresaDTO save(@RequestBody @Valid EmpresaDTOInput empresaInput)
	{
		try
		{
			Empresa empresa = empresaMapperManual.toDomainObject(empresaInput);

			return empresaMapperManual.toModel(empresaService.salvarEmpresa(empresa));
		} catch (EmpresaNotFoundException ex)
		{
			throw new BusinessException(ex.getMessage(), ex);
		}
	}
	
	@DeleteMapping("empresas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarEmpresaPorId(@PathVariable("id") Long id) {
		empresaService.deletarEmpresaById(id);
		
	}

}
