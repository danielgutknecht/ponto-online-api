package com.gutk.pontoonline.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.exceptions.RecordNotFoundException;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public List<Funcionario> listarTodos() {
		// Obs: ver metodo de paginação futuramente
		List<Funcionario> funcList = funcionarioRepository.findAll();

		if (funcList.size() > 0) {
			return funcList;
		} else {
			return new ArrayList<Funcionario>();
		}

	}

	@Override
	public Funcionario buscarPorName(String name) {
	
		return funcionarioRepository.findByNome(name);
		 
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) throws RecordNotFoundException {
		
		return funcionarioRepository.findByCpf(cpf);
	}

	@Override
	public Funcionario buscarPorEmail(String email) {
		
		return funcionarioRepository.findByEmail(email);
		}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		return funcionarioRepository.findById(id);
	}

	@Override
	public Funcionario criarOuAtualizar(Funcionario funcionario) {
		
		return funcionarioRepository.save(funcionario);
	}

	@Override
	public void excluir(Long id) throws RecordNotFoundException {
		

	}

}
