package com.gutk.pontoonline.api.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.EmpresaNotFoundException;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService
{

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public List<Empresa> listarTodasEmpresas()
	{
		return empresaRepository.findAll();
	}

	@Override
	public Empresa buscarEmpresaPorCnpj(String cnpj)
	{ 
		// verifica se o CNPJ existe no banco de dados
		Boolean emp = empresaRepository.existsByCnpj(cnpj);
		if (emp == false)
		{
			throw new EmpresaNotFoundException("CNPJ não foi encontrado");
		}
		return empresaRepository.findByCnpj(cnpj);
	}

	@Override
	public Empresa buscarEmpresaPorId(Long id)
	{
		Optional<Empresa> emp = empresaRepository.findById(id);

		return emp.orElseThrow(() -> new EmpresaNotFoundException(id));

	}

	@Override
	public Empresa criarEmpresa(Empresa novaEmpresa)
	{
		// verifica se o CNPJ existe no banco de dados
		String existsCnpj = novaEmpresa.getCnpj();
		Boolean emp = empresaRepository.existsByCnpj(existsCnpj);
		if (emp == true)
		{
			throw new EmpresaNotFoundException("CNPJ já cadastrada.");
		}
		// se não existe salva no banco de dados
		return empresaRepository.save(novaEmpresa);
	}

}
