package com.gutk.pontoonline.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gutk.pontoonline.api.entities.Funcionario;

public interface FuncionarioService {

	Page<Funcionario> listarTodosFuncionarios(Pageable pageable);	
	
	Funcionario buscarFuncionarioPorCpf(String cpf);

	Funcionario buscarFuncionarioPorEmail(String email);

	Funcionario buscarFuncionarioPorId(Long id);

	Funcionario salvarFuncionario(Funcionario novoFuncionario);
	
	Funcionario atualizarFuncionario(Funcionario atualizaFuncionario);

	public void deletarPorId(Long id);

}
