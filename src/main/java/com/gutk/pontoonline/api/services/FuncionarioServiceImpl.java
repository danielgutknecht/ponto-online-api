package com.gutk.pontoonline.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.FuncionarioNotFoundException;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EmpresaService empresaService;

	public Page<Funcionario> listarTodosFuncionarios(Pageable pageable) {
		return funcionarioRepository.findAll(pageable);
	}

	public Funcionario buscarFuncionarioPorCpf(String cpf) {
		return funcionarioRepository.findByCpf(cpf)
				.orElseThrow(() -> new FuncionarioNotFoundException("CPF NOT FOUND"));
	}

	public Funcionario buscarFuncionarioPorEmail(String email) {
		return funcionarioRepository.findByEmail(email)
				.orElseThrow(() -> new FuncionarioNotFoundException("E-MAIL NOT FOUND"));
	}

	public Funcionario buscarFuncionarioPorId(Long id) {
		return funcionarioRepository.findById(id).orElseThrow(() -> new FuncionarioNotFoundException(id));
	}

	public Funcionario salvarFuncionario(Funcionario novoFuncionario) {
		buscarFuncionarioPorCpf(novoFuncionario.getCpf());

		// Atribui o id para empresa
		Long empresaId = novoFuncionario.getEmpresa().getId();

		// busca o id no banco de dados
		Empresa empresa = empresaService.buscarEmpresaPorId(empresaId);
		// seta o id da empresa ao funcionario (fechando o relacionamento)
		novoFuncionario.setEmpresa(empresa);
		// salva a empresa.

		return funcionarioRepository.save(novoFuncionario);
	}

	public Funcionario atualizarFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}

	public void deletarPorId(Long id) {
		buscarFuncionarioPorId(id);
		funcionarioRepository.deleteById(id);
	}

}
