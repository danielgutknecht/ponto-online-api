package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class empresaServiceTest
{

	@MockBean
	private EmpresaRepository empRepository;

	@Autowired
	private EmpresaService empService;

	private static final String CNPJ = "05432187100193";

	@BeforeEach
	public void setUp()
	{

		Empresa emp = empRepository.save(obterDadosEmpresa());

		BDDMockito.given(empRepository.findByCnpj(Mockito.anyString())).willReturn(new Empresa());
		BDDMockito.given(empRepository.save(Mockito.any(Empresa.class))).willReturn(new Empresa());
		BDDMockito.when(empRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new Empresa()));

	}

	/*
	 * @Test public void testBuscaEmpresaPorCnpj() { Optional<Empresa> emp =
	 * empService.buscarPorCnpj(CNPJ);
	 * 
	 * assertTrue(emp.isPresent()); }
	 */

	@Test
	public void testBuscarEmpresaPorCnpj()
	{
		Empresa empresa = empService.buscarEmpresaPorCnpj(CNPJ);

		assertNotNull(empresa);
	}

	@Test
	public void testSalvarEmpresa()
	{		
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("empresa LTDA");
		empService.salvarEmpresa(empresa);
		
		assertEquals(empresa.getRazaoSocial(), empresa.getRazaoSocial());
	}
	/*
	 * @Test public void testBuscarEmpresaPorId(){ Empresa func =
	 * empService.buscarEmpresaPorId(1L);
	 * 
	 * assertNotNull(func); }
	 */

	private Empresa obterDadosEmpresa()
	{
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj(CNPJ);
		return empresa;
	}

}
