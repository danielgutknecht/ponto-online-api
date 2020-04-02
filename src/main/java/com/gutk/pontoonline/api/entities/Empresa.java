package com.gutk.pontoonline.api.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Table(name = "empresa")
public class Empresa extends AbstractEntity
{

	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String cnpj;
	private List<Funcionario> funcionario;
	
	public Empresa() {
		
	}	

	public Empresa(String razaoSocial, String cnpj)
	{
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}

	@Column(name = "razao_social", nullable = false)
	public String getRazaoSocial()
	{
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}
	
	@Column(name = "cnpj", nullable = false)
	public String getCnpj()
	{
		return cnpj;
	}

	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Funcionario> getFuncionario()
	{
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario)
	{
		this.funcionario = funcionario;
	}

	@Override
	public String toString()
	{
		return "Empresa [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", funcionario=" + funcionario + "]";
	}
	
}
