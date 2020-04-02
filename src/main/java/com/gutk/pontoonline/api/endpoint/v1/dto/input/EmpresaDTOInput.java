package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;

public class EmpresaDTOInput
{
	//id não é necessário! A sequencia é gerada pelo banco
	private String cnpj;
	private String razaoSocial;
	
	@NotBlank
	@CNPJ(message = "CNPJ inválido!")
	public String getCnpj()
	{
		return cnpj;
	}
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}
	public String getRazaoSocial()
	{
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}
	
	

}
