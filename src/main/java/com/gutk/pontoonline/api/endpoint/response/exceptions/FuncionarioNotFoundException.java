package com.gutk.pontoonline.api.endpoint.response.exceptions;

public class FuncionarioNotFoundException extends EntityNotFoundException
{
	private static final long serialVersionUID = 1L;
	
	public FuncionarioNotFoundException(String message)
	{
		super(message);
	}
	
	public FuncionarioNotFoundException(Long id) {
		this(String.format("Funcionário com ID: %d não existe ", id));
	}	

}
