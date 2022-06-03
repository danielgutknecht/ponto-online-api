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
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = true)
	private PerfilEnum perfil;
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;

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

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf + ", valorHora="
				+ valorHora + ", qtdHorasTrabalhoDia=" + qtdHorasTrabalhoDia + ", qtdHorasAlmoco=" + qtdHorasAlmoco
				+ ", perfil=" + perfil + ", empresa=" + empresa + ", lancamentos=" + lancamentos + "]";
	}

}
