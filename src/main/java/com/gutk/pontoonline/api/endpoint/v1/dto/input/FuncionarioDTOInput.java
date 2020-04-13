package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class FuncionarioDTOInput
{
	// não necessita cadastrar o id, pois é gerado pela sequencia no banco.
	// private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private Float valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private Long empresaId;

	@NotBlank(message = "Nome não pode ser vazio.")
	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	@NotBlank(message = "E-mail não pode ser vazio.")
	@Length(min = 3, max = 200, message = "E-mail deve ter entre 3 e 200 caracters.")
	@Email(message = "E-mail inválido")
	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	@NotBlank(message = "Senha não pode ser vazio.")
	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	@NotBlank(message = "CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	@NotNull
	public Float getValorHora()
	{
		return valorHora;
	}

	public void setValorHora(Float valorHora)
	{
		this.valorHora = valorHora;
	}

	@NotNull
	public Float getQtdHorasTrabalhoDia()
	{
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia)
	{
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	@NotNull
	public Float getQtdHorasAlmoco()
	{
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco)
	{
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}
	
	@NotNull
	public Long getEmpresaId()
	{
		return empresaId;
	}

	public void setEmpresaId(Long empresaId)
	{
		this.empresaId = empresaId;
	}

}
