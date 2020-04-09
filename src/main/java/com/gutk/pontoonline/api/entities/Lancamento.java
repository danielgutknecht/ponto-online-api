package com.gutk.pontoonline.api.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.gutk.pontoonline.api.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	public String descriacao;
	private String localizacao;
	private TipoEnum tipo;
	private Funcionario funcionario;


	@Column(name = "descricao", nullable = true)
	public String getDescriacao() {
		return descriacao;
	}

	public void setDescriacao(String descriacao) {
		this.descriacao = descriacao;
	}

	@Column(name = "localizacao", nullable = true)
	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@Override
	public String toString()
	{
		return "Lancamento [descriacao=" + descriacao + ", localizacao=" + localizacao + ", tipo="
				+ tipo + ", funcionario=" + funcionario + "]";
	}	
	
}
