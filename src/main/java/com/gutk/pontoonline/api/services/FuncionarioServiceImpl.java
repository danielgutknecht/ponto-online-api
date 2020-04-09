package com.gutk.pontoonline.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gutk.pontoonline.api.endpoint.response.exceptions.EmpresaNotFoundException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.FuncionarioNotFoundException;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService
{

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaService empresaService;

	@Override
	public Page<Funcionario> listarTodosFuncionarios(Pageable pageable)
	{
		return funcionarioRepository.findAll(pageable);
	}

	@Override
	public Funcionario buscarFuncionarioPorCpf(String cpf)
	{
		Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
		if (funcionario == null)
		{
			throw new FuncionarioNotFoundException("CPF não encontrado.");
		}

		return funcionario;
	}

	@Override
	public Funcionario buscarFuncionarioPorEmail(String email)
	{

		// verifica se o E-mail existe no banco de dados
		Boolean func = funcionarioRepository.existsByEmail(email);
		if (func == false)
		{
			throw new FuncionarioNotFoundException("E-mail não foi encontrado");
		}

		return funcionarioRepository.findByEmail(email);
	}

	@Override
	public Funcionario buscarFuncionarioPorId(Long id)
	{

		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);

		return funcionario.orElseThrow(() -> new FuncionarioNotFoundException(id));
	}

	/*
	 * @Override public Funcionario salvarFuncionario(Funcionario novoFuncionario) {
	 * 
	 * // verifica se o CPF existe no banco de dados String existsCpf =
	 * novoFuncionario.getCpf(); Boolean func =
	 * funcionarioRepository.existsByCpf(existsCpf); if (func == true) { throw new
	 * FuncionarioNotFoundException("CPF já cadastrado."); }
	 * 
	 * return funcionarioRepository.save(novoFuncionario); }
	 */

	public Funcionario salvarFuncionario(Funcionario novoFuncionario)
	{
		// verifica se o funcionário existe no banco.
		Boolean func = funcionarioRepository.existsByCpf(novoFuncionario.getCpf());
		if (func == true)
		{
			throw new FuncionarioNotFoundException("Existe um funcionario já cadastrado esse CPF.");
		}

		// Atribui o id da empresa
		Long empresaId = novoFuncionario.getEmpresa().getId();

		// busca o id no banco de dados
		Empresa empresa = empresaService.buscarEmpresaPorId(empresaId);
		// seta o id da empresa ao funcionario (fechando o relacionamento)
		novoFuncionario.setEmpresa(empresa);
		// salva a empresa.

		return funcionarioRepository.save(novoFuncionario);
	}

	@Override
	public Funcionario atualizarFuncionario(Funcionario funcionario)
	{
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void deletarPorId(Long id)
	{
		try
		{
			buscarFuncionarioPorId(id);
			funcionarioRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex)
		{
			throw new EmpresaNotFoundException(id);
		}
	}

}
