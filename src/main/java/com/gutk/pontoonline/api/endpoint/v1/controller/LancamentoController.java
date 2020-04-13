package com.gutk.pontoonline.api.endpoint.v1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.gutk.pontoonline.api.endpoint.response.exceptions.BusinessException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.endpoint.v1.dto.LancamentoDTO;
import com.gutk.pontoonline.api.endpoint.v1.mapper.LancamentoMapperManual;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.services.LancamentoService;

@RestController
@RequestMapping(path = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class LancamentoController
{

	@Autowired
	private LancamentoService lancamentoService;

	@Autowired
	private LancamentoMapperManual lancamentoMapperManual;

	@GetMapping(value = "/lancamentos")
	public CollectionModel<LancamentoDTO> listarTodosLancamentos(Pageable pageable)
	{
		return lancamentoMapperManual.toCollectionModel(lancamentoService.listarTodosLancamentos(pageable));
	}

	@GetMapping(value = "/lancamentos/{id}")
	public LancamentoDTO buscarLancamentosPorId(@PathVariable Long id)
	{
		return lancamentoMapperManual.toModel(lancamentoService.buscarLancamentoPorId(id));
	}

	@PostMapping(value = "/lancamentos")
	@ResponseStatus(value = HttpStatus.CREATED)
	public LancamentoDTO save(@RequestBody @Valid LancamentoDTO lancamentoDto)
	{
		try
		{
			Lancamento lancamento = lancamentoMapperManual.toDomainObjectLancamento(lancamentoDto);

			LancamentoDTO lancamentoDTO = lancamentoMapperManual
					.toModel(lancamentoService.salvarLancamento(lancamento));

			return lancamentoDTO;
		} catch (LancamentoNotFoundExceptions ex)
		{
			throw new BusinessException(ex.getMessage(), ex);
		}
	}

	@GetMapping(value = "/lancamentos/funcionario/{funcionarioId}")
	public CollectionModel<LancamentoDTO> buscarLancamentosPorFuncionario(@PathVariable Long funcionarioId,
			Pageable pageable)
	{
		return lancamentoMapperManual
				.toCollectionModel(lancamentoService.buscarLancamentoPorFuncionarioId(funcionarioId, pageable));
	}

	@PutMapping(value = "/lancamentos/{id}")
	public LancamentoDTO atualizarLancamento(@PathVariable() Long id, @RequestBody @Valid LancamentoDTO lancamentoDto)
	{
		try
		{
			Lancamento lancamentoCorrente = lancamentoService.buscarLancamentoPorId(id);

			Lancamento lancamento = lancamentoMapperManual.copyToDomainObject(lancamentoDto, lancamentoCorrente);

			LancamentoDTO lancamentoDTO = lancamentoMapperManual
					.toModel(lancamentoService.atualizarLancamento(lancamentoCorrente));

			return lancamentoDTO;
		} catch (LancamentoNotFoundExceptions ex)
		{
			throw new BusinessException(ex.getMessage(), ex);
		}
	}

	@DeleteMapping("/lancamentos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id)
	{
		lancamentoService.deletarLancamentoPorId(id);
	}
}
