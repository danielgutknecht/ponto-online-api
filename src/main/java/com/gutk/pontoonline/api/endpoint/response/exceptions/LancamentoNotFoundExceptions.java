package com.gutk.pontoonline.api.endpoint.response.exceptions;

public class LancamentoNotFoundExceptions extends EntityNotFoundException
{
	private static final long serialVersionUID = 1L;

	public LancamentoNotFoundExceptions(String message)
	{
		super(message);
	}

	public LancamentoNotFoundExceptions(Long id)
	{
		this(String.format("Lancamento com ID: %d não existe ", id));
	}

}
