package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.repositories.LancamentoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class lancamentoServiceTest {

	@MockBean
	private LancamentoRepository lancRepository;

	@Autowired
	private LancamentoService lancService;

	@BeforeEach
	public void setUp() {

		Lancamento lanc = new Lancamento();

		BDDMockito.given(lancRepository.findByFuncionarioId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
				.willReturn(new PageImpl<Lancamento>(new ArrayList<Lancamento>()));
		BDDMockito.when(this.lancRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(lanc));
		BDDMockito.given(this.lancRepository.save(Mockito.any(Lancamento.class))).willReturn(new Lancamento());

	}

	@Test
	public void testBuscarLancamentoPorFuncionarioId() {

		try {
			Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
			Page<Lancamento> lanc = lancService.buscarLancamentoPorFuncionarioId(1L, firstPageWithTwoElements);
			fail("Falha. Uma exceção deve ser lançada!");
		} catch (LancamentoNotFoundExceptions ex) {
			equals(ex.getMessage());
		}

	}

	@Test
	public void testBuscarPorLancamentoPorId() {
		Lancamento lanc = lancService.buscarLancamentoPorId(1L);

		assertNotNull(lanc);
	}

	/*
	 * @Test public void testCriarLancamento() { Lancamento lanc =
	 * lancService.salvarLancamento(new Lancamento());
	 * 
	 * assertNotNull(lanc);
	 * 
	 * }
	 */
}
