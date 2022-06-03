package com.gutk.pontoonline.api.services;

import java.util.List;
import com.gutk.pontoonline.api.entities.Empresa;

public interface EmpresaService {

	List<Empresa> listarTodasEmpresas();

	Empresa buscarEmpresaPorId(Long id);

	Empresa buscarEmpresaPorCnpj(String cnpj);

	Empresa salvarEmpresa(Empresa novaEmpresa);

	void deletarEmpresaById(Long id);

}
