package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.gutk.pontoonline.api.endpoint.v1.controller.FuncionarioController;
import com.gutk.pontoonline.api.endpoint.v1.dto.FuncionarioDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.FuncionarioDTOInput;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;

@Component
public class FuncionarioMapperManual extends RepresentationModelAssemblerSupport<Funcionario, FuncionarioDTO>
{
	
	public FuncionarioMapperManual()
	{
		super(FuncionarioController.class, FuncionarioDTO.class);
	}

	@Override
	public FuncionarioDTO toModel(Funcionario funcionario)
	{
		FuncionarioDTO funcionarioDto = createModelWithId(funcionario.getId(), funcionario);
		funcionarioDto.setId(funcionario.getId());
		funcionarioDto.setNome(funcionario.getNome());
		funcionarioDto.setEmail(funcionario.getEmail());
		funcionarioDto.setSenha(funcionario.getSenha());
		funcionarioDto.setCpf(funcionario.getCpf());
		funcionarioDto.setValorHora(funcionario.getValorHora());
		funcionarioDto.setQtdHorasTrabalhoDia(funcionario.getQtdHorasTrabalhoDia());
		funcionarioDto.setQtdHorasAlmoco(funcionario.getQtdHorasAlmoco());
		//logica especial no método salvar funcionario, para buscar os atributos do relacionamento.
		funcionarioDto.setRazaoSocial(funcionario.getEmpresa().getRazaoSocial());
		funcionarioDto.setCnpj(funcionario.getEmpresa().getCnpj());
				
		return funcionarioDto;
	}

	@Override
	public CollectionModel<FuncionarioDTO> toCollectionModel(Iterable<? extends Funcionario> entities)
	{
		CollectionModel<FuncionarioDTO> funcionarioModel = super.toCollectionModel(entities);
		return funcionarioModel;
	}


	public Funcionario toDomainObject(FuncionarioDTOInput funcionarioInput)
	{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(funcionarioInput.getNome());
		funcionario.setEmail(funcionarioInput.getEmail());
		funcionario.setSenha(funcionarioInput.getSenha());
		funcionario.setCpf(funcionarioInput.getCpf());
		funcionario.setValorHora(funcionarioInput.getValorHora());
		funcionario.setQtdHorasTrabalhoDia(funcionarioInput.getQtdHorasTrabalhoDia());
		funcionario.setQtdHorasAlmoco(funcionarioInput.getQtdHorasAlmoco());
		funcionario.setEmpresa(new Empresa());
		funcionario.getEmpresa().setId(funcionarioInput.getEmpresaId());
		return funcionario;
	}
	
	public Funcionario copyToDomainObject(FuncionarioDTOInput funcionarioInput, Funcionario funcionario)
	{
		funcionario.setNome(funcionarioInput.getNome());
		funcionario.setEmail(funcionarioInput.getEmail());
		funcionario.setSenha(funcionarioInput.getSenha());
		funcionario.setCpf(funcionarioInput.getCpf());
		funcionario.setValorHora(funcionarioInput.getValorHora());
		funcionario.setQtdHorasTrabalhoDia(funcionarioInput.getQtdHorasTrabalhoDia());
		funcionario.setQtdHorasAlmoco(funcionarioInput.getQtdHorasAlmoco());
		return funcionario;
	}
}
