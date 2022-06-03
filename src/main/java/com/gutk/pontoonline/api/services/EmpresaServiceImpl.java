package com.gutk.pontoonline.api.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.EmpresaNotFoundException;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;

	public List<Empresa> listarTodasEmpresas() {
		return empresaRepository.findAll();
	}

	public Empresa buscarEmpresaPorCnpj(String cnpj) {
		return empresaRepository.existsByCnpj(cnpj).orElseThrow(() -> new EmpresaNotFoundException("CNPJ NOT FOUND"));
	}

	public Empresa buscarEmpresaPorId(Long id) {
		return empresaRepository.findById(id).orElseThrow(() -> new EmpresaNotFoundException(id));
	}

	public Empresa salvarEmpresa(Empresa novaEmpresa) {
		buscarEmpresaPorCnpj(novaEmpresa.getCnpj());

		return empresaRepository.saveAndFlush(novaEmpresa);
	}

	public void deletarEmpresaById(Long id) {
		buscarEmpresaPorId(id);
		empresaRepository.deleteById(id);
	}

}
