package com.gutk.pontoonline.api.endpoint.v1.dto;

import org.springframework.hateoas.RepresentationModel;

public class EmpresaDTO extends RepresentationModel<EmpresaDTO> {
	private Long id;
	private String razaoSocial;
	private String cnpj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
