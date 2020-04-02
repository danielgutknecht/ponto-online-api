package com.gutk.pontoonline.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.repositories.LancamentoRepository;

@Service
public class lancamentoServiceImpl implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, Pageable page) {

		return lancamentoRepository.findByFuncionarioId(funcionarioId, page);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {

		return lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento criarOuAtualizar(Lancamento lancamento) {

		return lancamentoRepository.save(lancamento);
	}

	public void remover(Long id) {
		
		lancamentoRepository.deleteById(id);
	}

}
