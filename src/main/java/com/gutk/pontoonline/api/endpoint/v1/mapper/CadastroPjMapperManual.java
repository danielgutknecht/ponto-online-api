package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.gutk.pontoonline.api.endpoint.v1.controller.CadastroPJController;
import com.gutk.pontoonline.api.endpoint.v1.dto.CadastroPJDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.CadastroPJDTOInput;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;

@Component
public class CadastroPjMapperManual extends RepresentationModelAssemblerSupport<Funcionario, CadastroPJDTO>
{

	public CadastroPjMapperManual()
	{
		super(CadastroPJController.class, CadastroPJDTO.class);
	}

	@Override
	public CadastroPJDTO toModel(Funcionario funcionario)
	{
		CadastroPJDTO cadastroPjDto = createModelWithId(funcionario.getId(), funcionario);
		cadastroPjDto.setId(funcionario.getId());
		cadastroPjDto.setNome(funcionario.getNome());
		cadastroPjDto.setEmail(funcionario.getEmail());
		cadastroPjDto.setCpf(funcionario.getCpf());
		cadastroPjDto.setRazaoSocial(funcionario.getEmpresa().getRazaoSocial());
		cadastroPjDto.setCnpj(funcionario.getEmpresa().getCnpj());
		return cadastroPjDto;
	}
	
	public CollectionModel<CadastroPJDTO> toCollectionModel(Iterable<? extends Funcionario> entities) {
	    CollectionModel<CadastroPJDTO> empresaModel = super.toCollectionModel(entities);
	    	   	    
	    return empresaModel;
	}
	
	public Funcionario toDomainObjectFuncionario(CadastroPJDTOInput cadastroPJDtoInput) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(cadastroPJDtoInput.getNome());
		funcionario.setEmail(cadastroPJDtoInput.getEmail());
		funcionario.setSenha(cadastroPJDtoInput.getSenha());
		funcionario.setCpf(cadastroPJDtoInput.getCpf());
						
		return funcionario;
	}
	
	public Empresa toDomainObjectEmpresa(CadastroPJDTOInput cadastroPJDtoInput) {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial(cadastroPJDtoInput.getRazaoSocial());
		empresa.setCnpj(cadastroPJDtoInput.getCnpj());
		return empresa;
	}

	

}
