package com.gutk.pontoonline.api.endpoint.v1.answersapi;

//import com.gutk.pontoonline.api.endpoint.response.errors.ApiError;



import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.endpoint.v1.errors.ApiError;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api
public interface EmpresaAnswerApi
{
	@ApiOperation("Busca uma empra por ID")
	@ApiResponses({
		@ApiResponse(code = 400, message = "Identificador de empresa inválido", response = ApiError.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ApiError.class)
	})	
	public EmpresaDTO buscarEmpresaPorId(@ApiParam(value = "Identificador de uma empresa", example = "1") Long empresaId);
	
	@ApiOperation("Busca uma empresa por CNPJ")
	@ApiResponses({
		@ApiResponse(code = 400, message = "CNPJ de empresa inválido", response = ApiError.class),
		@ApiResponse(code = 404, message = "Empresa não encontrada", response = ApiError.class)
	})	
	public EmpresaDTO buscarEmpresaPorCnpj(@ApiParam(value = "Identificador CNPJ de uma empresa", example = "14521312368524") String cnpj);

}
