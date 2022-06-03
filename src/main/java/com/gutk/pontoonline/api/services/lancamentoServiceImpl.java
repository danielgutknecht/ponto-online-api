package com.gutk.pontoonline.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.repositories.LancamentoRepository;

@Service
public class lancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	public Page<Lancamento> buscarLancamentoPorFuncionarioId(Long funcionarioId, Pageable page) {
		return lancamentoRepository.findByFuncionarioId(funcionarioId, page);
	}

	public Lancamento salvarLancamento(Lancamento novoLancamento) {
		// Atribui o id para funcionario
		Long funcionarioId = novoLancamento.getFuncionario().getId();
		// busca o id no banco de dados
		Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(funcionarioId);
		// Atribui id ao funcionario (fechando o relacionamento)
		novoLancamento.setFuncionario(funcionario);

		// salva a empresa.
		return lancamentoRepository.save(novoLancamento);
	}

	public Page<Lancamento> listarTodosLancamentos(Pageable pageable) {
		return lancamentoRepository.findAll(pageable);
	}

	public Lancamento buscarLancamentoPorId(Long id) {
		return lancamentoRepository.findById(id).orElseThrow(() -> new LancamentoNotFoundExceptions(id));
	}

	public void deletarLancamentoPorId(Long id) {
		buscarLancamentoPorId(id);
		lancamentoRepository.deleteById(id);
	}

	public Lancamento atualizarLancamento(Lancamento atualizaLancamento) {
		return lancamentoRepository.save(atualizaLancamento);
	}

}
