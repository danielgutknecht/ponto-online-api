package com.gutk.pontoonline.api.endpoint.response.errors;

import lombok.Getter;

public enum ApiErrorType {
	
	RESOURCE_NOT_FOUND("/recurso-nao-encontrado", "Recurso não encontrado"),
	ENTITY_IN_USE("/entidade-em-uso", "Entidade em uso"),
	BUSINESS_EXCEPTION("/erro-de-negocio", "Violação de regra de negócio"),
	REQUEST_BODY_ERROR("/erro-no-corpo-da-requisicao", "Erro no corpo da requisição"),
	REQUEST_INVALID_PARAMETER("/parametro-invalido", "Parâmetro inválido"),
	INTERNAL_SERVER_ERROR("/erro-de-sistema", "Erro de sistema"),
	INVALID_DATA("/dados-invalidos", "Dados inválidos"),
	ACCESS_DENIED("/acesso-negado", "Acesso negado");
	
	private String title;
	private String uri;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	private ApiErrorType(String path, String title) {
		this.uri = "https://pontoonline.com.br".concat(path);
		this.title = title;
	}

}
