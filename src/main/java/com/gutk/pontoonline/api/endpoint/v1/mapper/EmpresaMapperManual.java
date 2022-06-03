package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.gutk.pontoonline.api.endpoint.v1.controller.EmpresaController;
import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.EmpresaDTOInput;
import com.gutk.pontoonline.api.entities.Empresa;

@Component
public class EmpresaMapperManual extends RepresentationModelAssemblerSupport<Empresa, EmpresaDTO> {
	public EmpresaMapperManual() {
		super(EmpresaController.class, EmpresaDTO.class);
	}

	@Override
	public EmpresaDTO toModel(Empresa empresa) {
		EmpresaDTO empresaDto = createModelWithId(empresa.getId(), empresa);
		empresaDto.setId(empresa.getId());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());
		empresaDto.setCnpj(empresa.getCnpj());

		return empresaDto;
	}

	public CollectionModel<EmpresaDTO> toCollectionModel(Iterable<? extends Empresa> entities) {
		CollectionModel<EmpresaDTO> empresaModel = super.toCollectionModel(entities);

		return empresaModel;
	}

	public Empresa toDomainObject(EmpresaDTOInput empresaInput) {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial(empresaInput.getRazaoSocial());
		empresa.setCnpj(empresaInput.getCnpj());

		return empresa;
	}

}
