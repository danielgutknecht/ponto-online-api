package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.gutk.pontoonline.api.endpoint.v1.controller.EmpresaController;
import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.EmpresaDTOInput;
import com.gutk.pontoonline.api.entities.Empresa;

@Component
public class EmpresaModelMapper extends RepresentationModelAssemblerSupport<Empresa, EmpresaDTO>
{
	@Autowired
	private ModelMapper modelMapper;

	
	public EmpresaModelMapper() {
		super(EmpresaController.class, EmpresaDTO.class);
	}

	@Override
	public EmpresaDTO toModel(Empresa empresa) {
		EmpresaDTO empresaDto = createModelWithId(empresa.getId(), empresa);
		modelMapper.map(empresa, empresaDto);

		return empresaDto;
	}

	@Override
	public CollectionModel<EmpresaDTO> toCollectionModel(Iterable<? extends Empresa> entities) {
		CollectionModel<EmpresaDTO> empresaModel = super.toCollectionModel(entities);
		return empresaModel;
	}

	public Empresa toDomainObject(EmpresaDTOInput empresaInput) {
		return modelMapper.map(empresaInput, Empresa.class);
	}

}