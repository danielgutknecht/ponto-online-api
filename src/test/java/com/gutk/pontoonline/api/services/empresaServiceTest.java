package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class empresaServiceTest {

	@MockBean
	private EmpresaRepository empRepository;

	@Autowired
	private EmpresaService empService;

	private static final String CNPJ = "05432187100193";

	@BeforeEach
	public void setUp() {
		BDDMockito.given(empRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(empRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
	}

	@Test
	public void testBuscaEmpresaPorCnpj() {
		Empresa emp = empService.buscarPorCnpj(CNPJ);

		assertNotNull(emp);
	}
	
	@Test
	public void testSalvarEmpresa() {
		Empresa emp = empService.salvar(new Empresa());
		
		assertNotNull(emp);
	}

}
