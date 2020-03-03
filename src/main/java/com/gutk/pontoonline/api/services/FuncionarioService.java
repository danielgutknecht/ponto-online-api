package com.gutk.pontoonline.api.services;

import java.util.List;
import java.util.Optional;

import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.exceptions.RecordNotFoundException;

public interface FuncionarioService {
	
	public List<Funcionario> listarTodos();
	
	Funcionario buscarPorName (String name);
	
	Funcionario buscarPorCpf(String cpf) throws RecordNotFoundException;
	
	Funcionario buscarPorEmail(String email);
		
	Optional<Funcionario>buscarPorId(Long id) throws RecordNotFoundException;
	
	Funcionario criarOuAtualizar(Funcionario funcionario);
	
	public void excluir(Long id) throws RecordNotFoundException;

}
