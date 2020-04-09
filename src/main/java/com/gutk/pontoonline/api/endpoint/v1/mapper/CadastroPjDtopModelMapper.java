package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.gutk.pontoonline.api.endpoint.v1.controller.CadastroPJController;
import com.gutk.pontoonline.api.endpoint.v1.dto.CadastroPJDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.CadastroPJDTOInput;
import com.gutk.pontoonline.api.entities.Funcionario;


@Component
public class CadastroPjDtopModelMapper extends RepresentationModelAssemblerSupport<Funcionario, CadastroPJDTO>
{
	@Autowired
	private ModelMapper modelMapper;

	public CadastroPjDtopModelMapper()
	{
		super(CadastroPJController.class, CadastroPJDTO.class);
	}

	@Override
	public CadastroPJDTO toModel(Funcionario funcionario)
	{
		CadastroPJDTO cadastroPJDto = createModelWithId(funcionario.getId(), funcionario);
		modelMapper.map(funcionario, cadastroPJDto);
		

		return cadastroPJDto;
	}	

	@Override
	public CollectionModel<CadastroPJDTO> toCollectionModel(Iterable<? extends Funcionario> entities)
	{
		CollectionModel<CadastroPJDTO> cadastroPJDtoModel = super.toCollectionModel(entities);
		return cadastroPJDtoModel;
	}

	public Funcionario toDomainObject(CadastroPJDTOInput cadastroPJInput)
	{
		return modelMapper.map(cadastroPJInput, Funcionario.class);
	}

}
