package com.gutk.pontoonline.api.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Funcionario> funcionario;

	public Empresa() {

	}

	public Empresa(String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
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

	public List<Funcionario> getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString() {
		return "Empresa [razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", funcionario=" + funcionario + "]";
	}

}
