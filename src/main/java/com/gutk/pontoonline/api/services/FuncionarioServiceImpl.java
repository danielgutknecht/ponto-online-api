package com.gutk.pontoonline.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;
import com.gutk.pontoonline.api.exceptions.RecordNotFoundException;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	@Transactional
	public List<Funcionario> getAllFuncionarios() {

		// Obs: ver metodo de paginação futuramente
		List<Funcionario> funcList = funcionarioRepository.findAll();

		if (funcList.size() > 0) {
			return funcList;
		} else {
			return new ArrayList<Funcionario>();
		}

	}

	@Override
	@Transactional
	public List<Funcionario> findByNameFuncionario(String nome) {

		return (List<Funcionario>) funcionarioRepository.findByNome(nome);
	}

	@Override
	@Transactional
	public Funcionario getByIdFuncionario(Long id) throws RecordNotFoundException {

		Optional<Funcionario> funcList = funcionarioRepository.findById(id);

		if (funcList.isPresent()) {
			return funcList.get();
		} else {
			throw new RecordNotFoundException("Funcionário não encontrado com este id");
		}
	}

	@Override
	public List<Funcionario> findByCpfFuncionario(String nome) {
		List<Funcionario> funcList = (List<Funcionario>) funcionarioRepository.findByNome(nome);

		if (!funcList.isEmpty()) {
			return funcList;
		} else {
			// throw new RecordNotFoundException("Funcionário não encontrado com este id");
			throw new RuntimeException("CPF não encontrado");

		}
	}

	@Override
	public Funcionario createOrUpdateFuncionario(Funcionario funcionario) {
		Optional<Funcionario> funcList = funcionarioRepository.findById(funcionario.getId());

		if (funcList.isPresent()) {

			Funcionario novoFuncionario = new Funcionario();
			novoFuncionario.setNome(funcionario.getNome());
			novoFuncionario.setSobrenome(funcionario.getSobrenome());
			novoFuncionario.setEmail(funcionario.getEmail());
			// novoFuncionario.setSenha(funcionario.getSenha());
			// novoFuncionario.setValorHora(funcionario.getValorHora());
			// novoFuncionario.setQtdHoraTrabalhoDia(funcionario.getQtdHoraTrabalhoDia());
			// novoFuncionario.setQtdHoraAlmoco(funcionario.getQtdHoraAlmoco());

			// analisar e adicionar os outros atributos

			novoFuncionario = funcionarioRepository.save(novoFuncionario);

			return novoFuncionario;

		} else {

			funcionario = funcionarioRepository.save(funcionario);

			return funcionario;
		}

	}

	@Transactional
	@Override
	public void deleteFuncionario(Long id) throws RecordNotFoundException {

		Optional<Funcionario> funcList = funcionarioRepository.findById(id);

		if (funcList.isPresent()) {
			funcionarioRepository.deleteById(id);
		} else {
			throw new RuntimeException("Funcionário não encontrado com este id");
		}

	}

}
