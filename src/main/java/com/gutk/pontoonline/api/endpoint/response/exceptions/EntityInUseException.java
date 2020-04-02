package com.gutk.pontoonline.api.endpoint.response.exceptions;

public class EntityInUseException extends BusinessException {

	private static final long serialVersionUID = 1L;
	
	public EntityInUseException(String message) {
		super(message);
	}

}
