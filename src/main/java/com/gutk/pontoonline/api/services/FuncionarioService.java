package com.gutk.pontoonline.api.services;

import com.gutk.pontoonline.api.entities.Funcionario;

public interface FuncionarioService {

	//public List<Funcionario> listarTodosFuncionarios();

	Funcionario buscarFuncionarioPorCpf(String cpf);

	Funcionario buscarFuncionarioPorEmail(String email);

	Funcionario buscarFuncionarioPorId(Long id);

	Funcionario criarFuncionario(Funcionario novoFuncionario);

	//Funcionario atualizarFuncionario(Long id, Funcionario atualizarDetalhesfuncionario);

	//public void excluir(Long id);

}
