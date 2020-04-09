package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
	public void testBuscarFuncionarioPorId() {
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Page<Lancamento> lanc = lancService.buscarLancamentoPorFuncionarioId(1L, firstPageWithTwoElements);
		
		assertNotNull(lanc);
	}
	
	@Test
	public void testBuscarPorId() {
		Lancamento lanc = lancService.buscarLancamentoPorId(1L);
		
		assertNotNull(lanc);
	}
	
	@Test
	public void testCriarLancamento() {
		Lancamento lanc = lancService.salvarLancamento(new Lancamento());
		
		assertNotNull(lanc);
		
	}
}
