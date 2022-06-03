package com.gutk.pontoonline.api.endpoint.response.exceptions;

public abstract class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
