package com.gutk.pontoonline.api.endpoint.v1.mapper;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import com.gutk.pontoonline.api.endpoint.v1.controller.LancamentoController;
import com.gutk.pontoonline.api.endpoint.v1.dto.LancamentoDTO;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.enums.TipoEnum;

@Component
public class LancamentoMapperManual extends RepresentationModelAssemblerSupport<Lancamento, LancamentoDTO>
{

	public LancamentoMapperManual()
	{
		super(LancamentoController.class, LancamentoDTO.class);
	}

	@Override
	public LancamentoDTO toModel(Lancamento lancamento)
	{
		LancamentoDTO lancamentoDto = createModelWithId(lancamento.getId(), lancamento);
		lancamentoDto.setId(lancamento.getId());
		lancamentoDto.setDescricao(lancamento.getDescriacao());
		lancamentoDto.setTipo(lancamento.getTipo().toString());
		lancamentoDto.setLocalizacao(lancamento.getLocalizacao());
		lancamentoDto.setFuncionarioId(lancamento.getFuncionario().getId());

		return lancamentoDto;
	}

	@Override
	public CollectionModel<LancamentoDTO> toCollectionModel(Iterable<? extends Lancamento> entities)
	{
		CollectionModel<LancamentoDTO> LancamentoModel = super.toCollectionModel(entities);
		return LancamentoModel;
	}

	public Lancamento toDomainObjectLancamento(LancamentoDTO lancamentoDto)
	{
		Lancamento lancamento = new Lancamento();

		// lancamento.setId(lancamentoDto.getId());
		lancamento.setDescriacao(lancamentoDto.getDescricao());
		lancamento.setTipo(TipoEnum.valueOf(lancamentoDto.getTipo()));
		lancamento.setLocalizacao(lancamentoDto.getLocalizacao());
		lancamento.setFuncionario(new Funcionario());
		lancamento.getFuncionario().setId(lancamentoDto.getFuncionarioId());
		return lancamento;
	}

	public Lancamento copyToDomainObject(LancamentoDTO lancamentoDto, Lancamento lancamento)
	{
		lancamento.setId(lancamentoDto.getId());
		lancamento.setDescriacao(lancamentoDto.getDescricao());
		lancamento.setTipo(TipoEnum.valueOf(lancamentoDto.getTipo()));
		lancamento.setLocalizacao(lancamentoDto.getLocalizacao());
		//lancamento.setFuncionario(new Funcionario());
		//lancamento.getFuncionario().setId(lancamentoDto.getFuncionarioId());
		return lancamento;

	}

}
