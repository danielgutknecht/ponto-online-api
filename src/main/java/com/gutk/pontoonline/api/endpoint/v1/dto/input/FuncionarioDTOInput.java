package com.gutk.pontoonline.api.endpoint.v1.dto.input;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.enums.PerfilEnum;

public class FuncionarioDTOInput
{

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private Float valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private EmpresaDTO empresa;
	// private List<Lancamento> lancamentos;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getCpf()
	{
		return cpf;
	}

	public void setCpf(String cpf)
	{
		this.cpf = cpf;
	}

	public Float getValorHora()
	{
		return valorHora;
	}

	public void setValorHora(Float valorHora)
	{
		this.valorHora = valorHora;
	}

	public Float getQtdHorasTrabalhoDia()
	{
		return qtdHorasTrabalhoDia;
	}

	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia)
	{
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	public Float getQtdHorasAlmoco()
	{
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco)
	{
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	public PerfilEnum getPerfil()
	{
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil)
	{
		this.perfil = perfil;
	}

	public EmpresaDTO getEmpresa()
	{
		return empresa;
	}

	public void setEmpresa(EmpresaDTO empresa)
	{
		this.empresa = empresa;
	}

}
