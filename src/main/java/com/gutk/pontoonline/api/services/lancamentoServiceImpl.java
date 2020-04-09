package com.gutk.pontoonline.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.repositories.LancamentoRepository;

@Service
public class lancamentoServiceImpl implements LancamentoService
{

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscarLancamentoPorFuncionarioId(Long funcionarioId, Pageable page)
	{
		Page<Lancamento> lanc = lancamentoRepository.findByFuncionarioId(funcionarioId, page);
		if (lanc.isEmpty())
		{
			throw new LancamentoNotFoundExceptions("Lançamentos não encontrado por funcionário.");
		}

		return lancamentoRepository.findByFuncionarioId(funcionarioId, page);
	}

	@Override
	public Lancamento salvarLancamento(Lancamento novoLancamento)
	{

		return lancamentoRepository.save(novoLancamento);
	}

	@Override
	public Page<Lancamento> listarTodosLancamentos(Pageable pageable)
	{
		return lancamentoRepository.findAll(pageable);
	}

	@Override
	public Lancamento buscarLancamentoPorId(Long id)
	{
		Optional<Lancamento> lancamento = lancamentoRepository.findById(id);

		return lancamento.orElseThrow(() -> new LancamentoNotFoundExceptions(id));
	}

	public void deletarLancamentoPorId(Long id)
	{
		try
		{
			buscarLancamentoPorId(id);
			lancamentoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException ex)
		{
			throw new LancamentoNotFoundExceptions(id);
		}
	}

	@Override
	public Lancamento atualizarLancamento(Lancamento atualizaLancamento)
	{
		return lancamentoRepository.save(atualizaLancamento);
	}

}
