package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDTOInput {

	@NotBlank(message = "Nome não pode ser vazio.")
	private String nome;
	@NotBlank(message = "E-mail não pode ser vazio.")
	@Length(min = 3, max = 200, message = "E-mail deve ter entre 3 e 200 caracters.")
	@Email(message = "E-mail inválido")
	private String email;
	@NotBlank(message = "Senha não pode ser vazio.")
	private String senha;
	@NotBlank(message = "CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	@NotNull
	private Float valorHora;
	@NotNull
	private Float qtdHorasTrabalhoDia;
	@NotNull
	private Float qtdHorasAlmoco;
	@NotNull
	private Long empresaId;

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

	public Float getValorHora() {
		return valorHora;
	}

	public void setValorHora(Float valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public Long getEmpresaId() {
		return empresaId;
	}

	public void setEmpresaId(Long empresaId) {
		this.empresaId = empresaId;
	}

}
