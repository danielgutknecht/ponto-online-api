package com.gutk.pontoonline.api.endpoint.response.exceptions;

public class EmpresaNotFoundException extends EntityNotFoundException {
	private static final long serialVersionUID = 1L;

	public EmpresaNotFoundException(String message) {
		super(message);
	}

	public EmpresaNotFoundException(Long id) {
		this(String.format("Empresa de ID: %d não existe!", id));
	}

}
