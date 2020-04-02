package com.gutk.pontoonline.api.services;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.gutk.pontoonline.api.entities.Lancamento;

public interface LancamentoService {

	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, Pageable page);

	Optional<Lancamento> buscarPorId(Long id);

	Lancamento criarOuAtualizar(Lancamento lancamento);

	void remover(Long id);

}
