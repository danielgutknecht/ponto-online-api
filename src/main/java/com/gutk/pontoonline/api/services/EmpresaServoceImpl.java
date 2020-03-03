package com.gutk.pontoonline.api.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;

@Service
public class EmpresaServoceImpl implements EmpresaService {

	private static final Logger log = LoggerFactory.getLogger(EmpresaServoceImpl.class);

	@Autowired
	private EmpresaRepository empresaReposotory;

	@Override
	public Empresa buscarPorCnpj(String cnpj) {
		
		log.info("Buscando uma empresa por CNPJ {}", cnpj);

		return empresaReposotory.findByCnpj(cnpj);
	}

	@Override
	public Empresa salvar(Empresa empresa) {
		
		return empresaReposotory.save(empresa);
	}
	
	


}
