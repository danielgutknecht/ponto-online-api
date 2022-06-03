package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

public class CadastroPJDTOInput {

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String nome;
	@NotEmpty(message = "E-mail não pode ser vazio.")
	@Length(min = 3, max = 200, message = "E-mail deve ter entre 3 e 200 caracters.")
	@Email(message = "E-mail inválido")
	private String email;
	@NotEmpty(message = "Senha não pode ser vazio.")
	private String senha;
	@NotEmpty(message = "CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	@NotEmpty(message = "Razão Social não pode ser vazio.")
	private String razaoSocial;
	@NotEmpty(message = "CPF não pode ser vazio.")
	@CNPJ(message = "CNPJ inválido.")
	private String cnpj;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
