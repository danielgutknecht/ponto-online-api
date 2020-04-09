package com.gutk.pontoonline.api.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.gutk.pontoonline.api.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario extends AbstractEntity {

	private static final long serialVersionUID = 1L;	
	
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private Float valorHora;
	private Float qtdHorasTrabalhoDia;
	private Float qtdHorasAlmoco;
	private PerfilEnum perfil;
	private Empresa empresa;
	private List<Lancamento> lancamentos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "cpf", nullable = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Column(name = "valor_hora", nullable = true)
	public Float getValorHora() {
		return valorHora;
	}

	public void setValorHora(Float valorHora) {
		this.valorHora = valorHora;
	}

	@Column(name = "qtd_horas_trabalho_dia", nullable = true)
	public Float getQtdHorasTrabalhoDia() {
		return qtdHorasTrabalhoDia;
	}
	
	public void setQtdHorasTrabalhoDia(Float qtdHorasTrabalhoDia) {
		this.qtdHorasTrabalhoDia = qtdHorasTrabalhoDia;
	}

	@Column(name = "qtd_horas_almoco", nullable = true)
	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}

	public void setQtdHorasAlmoco(Float qtdHorasAlmoco) {
		this.qtdHorasAlmoco = qtdHorasAlmoco;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = true)
	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	@Column(name = "senha", nullable = true)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", empresa=" + empresa + ", lancamentos=" + lancamentos + "]";
	}

}
