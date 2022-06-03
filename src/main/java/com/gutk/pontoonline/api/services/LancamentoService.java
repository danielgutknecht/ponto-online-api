package com.gutk.pontoonline.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gutk.pontoonline.api.entities.Lancamento;

public interface LancamentoService {

	Page<Lancamento> buscarLancamentoPorFuncionarioId(Long funcionarioId, Pageable page);

	Lancamento buscarLancamentoPorId(Long id);

	Page<Lancamento> listarTodosLancamentos(Pageable pageable);

	Lancamento salvarLancamento(Lancamento novoLancamento);

	Lancamento atualizarLancamento(Lancamento atualizaLancamento);

	void deletarLancamentoPorId(Long id);

}
