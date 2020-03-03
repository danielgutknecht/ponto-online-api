package com.gutk.pontoonline.api.services;

import java.util.List;
import java.util.Optional;

import com.gutk.pontoonline.api.entities.Empresa;

public interface EmpresaService {
	
	Empresa buscarPorCnpj(String cnpj);
	
	Empresa salvar(Empresa empresa);
}
