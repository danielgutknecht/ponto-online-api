package com.gutk.pontoonline.api.services;

import java.util.List;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.exceptions.RecordNotFoundException;

public interface FuncionarioService {
	
	public List<Funcionario> getAllFuncionarios();
	
	public List<Funcionario> findByNameFuncionario (String name);
	
	public List<Funcionario> findByCpfFuncionario(String nome) throws RecordNotFoundException;
	
	public Funcionario createOrUpdateFuncionario(Funcionario funcionario);
	
	public Funcionario getByIdFuncionario(Long id) throws RecordNotFoundException;
		
	public void deleteFuncionario(Long id) throws RecordNotFoundException;

}
