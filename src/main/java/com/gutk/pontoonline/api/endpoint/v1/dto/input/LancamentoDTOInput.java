package com.gutk.pontoonline.api.endpoint.v1.dto.input;

public class LancamentoDTOInput
{
	//private Long id;
	private String descricao;
	private String tipo;
	private String localizacao;
	private Long funcionarioId;

	
	public String getDescricao()
	{
		return descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public String getLocalizacao()
	{
		return localizacao;
	}

	public void setLocalizacao(String localizacao)
	{
		this.localizacao = localizacao;
	}

	public Long getFuncionarioId()
	{
		return funcionarioId;
	}

	public void setFuncionarioId(Long funcionarioId)
	{
		this.funcionarioId = funcionarioId;
	}

}
