package com.gutk.pontoonline.api.services;

import java.util.List;
import com.gutk.pontoonline.api.endpoint.v1.dto.EmpresaDTO;
import com.gutk.pontoonline.api.entities.Empresa;

public interface EmpresaService {
	
	List<Empresa> listarTodasEmpresas();
	
	Empresa buscarEmpresaPorId(Long id);

	Empresa buscarEmpresaPorCnpj(String cnpj);
	
	Empresa criarEmpresa(Empresa novaEmpresa);
	
	//Empresa atualizarEmpresa(Long idEmpresa, EmpresaDTO updateEmpresaDtoDetails);
	
	//void deletarEmpresa(Long id);
	

}
