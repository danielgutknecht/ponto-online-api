package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaDTOInput {

	@NotBlank
	@CNPJ(message = "CNPJ inválido!")
	private String cnpj;
	@NotBlank(message = "Razão Social não pode ser vazio.")
	private String razaoSocial;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

}
