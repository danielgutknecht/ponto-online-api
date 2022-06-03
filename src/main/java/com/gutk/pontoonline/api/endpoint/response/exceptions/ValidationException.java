package com.gutk.pontoonline.api.endpoint.response.exceptions;

import org.springframework.validation.BindingResult;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BindingResult bindingResult;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

}
