package com.gutk.pontoonline.api.endpoint.v1.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gutk.pontoonline.api.endpoint.response.exceptions.BusinessException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.EmpresaNotFoundException;
import com.gutk.pontoonline.api.endpoint.v1.dto.CadastroPJDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.CadastroPJDTOInput;
import com.gutk.pontoonline.api.endpoint.v1.mapper.CadastroPjMapperManual;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.services.EmpresaService;
import com.gutk.pontoonline.api.services.FuncionarioService;

@RestController 
@RequestMapping("/api/v2/empresa-pj")
@CrossOrigin(origins = "*")
public class CadastroPJController 
{
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private CadastroPjMapperManual cadastroPjMapperManual;
	
		
	@GetMapping(value = "/{id}")
	public CadastroPJDTO buscarEmpresaPorId(@PathVariable Long id)
	{
		return cadastroPjMapperManual.toModel(funcionarioService.buscarFuncionarioPorId(id));
		
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public CadastroPJDTO save(@RequestBody @Valid CadastroPJDTOInput cadastroPjInput) {
		try {
			Funcionario funcionario = cadastroPjMapperManual.toDomainObjectFuncionario(cadastroPjInput);
			Empresa empresa = cadastroPjMapperManual.toDomainObjectEmpresa(cadastroPjInput);
						
			empresaService.criarEmpresa(empresa);
			
			funcionario.setEmpresa(empresa);
						
			CadastroPJDTO cadastroPJDTO = cadastroPjMapperManual.toModel(funcionarioService.criarFuncionario(funcionario));
			

			return cadastroPJDTO;
		} catch (EmpresaNotFoundException ex) {
			throw new BusinessException(ex.getMessage(), ex);
		}
	}
	

}
