package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.gutk.pontoonline.api.endpoint.response.exceptions.FuncionarioNotFoundException;
import com.gutk.pontoonline.api.endpoint.response.exceptions.LancamentoNotFoundExceptions;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.enums.PerfilEnum;
import com.gutk.pontoonline.api.repositories.EmpresaRepository;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@Transactional
@SpringBootTest
//@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
public class funcionarioServiceTest
{

	@MockBean
	private FuncionarioRepository funcReposotory;
	@MockBean
	private EmpresaRepository empRepository;

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private EmpresaService empService;

	private static final String EMAIL = "daniel@daniel.com";
	private static final String CPF = "01359072099";

	@BeforeEach
	public void setUp()
	{
		Empresa empresa = new Empresa();
		Funcionario funcionario = new Funcionario();
		funcionario.setEmpresa(empresa);

		BDDMockito.when(funcReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(funcionario));
		BDDMockito.given(funcReposotory.findByEmail(Mockito.anyString())).willReturn(funcionario);
		BDDMockito.given(funcReposotory.findByCpf(Mockito.anyString())).willReturn(funcionario);
		BDDMockito.given(funcReposotory.save(Mockito.any(Funcionario.class))).willReturn(funcionario);
		

	}

	@Test
	public void testBuscarFuncionarioPorId()
	{
		Funcionario func = funcionarioService.buscarFuncionarioPorId(1L);

		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorEmail()
	{

		Funcionario func = funcionarioService.buscarFuncionarioPorEmail(EMAIL);

		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorCpf()
	{
		Funcionario func = funcionarioService.buscarFuncionarioPorCpf(CPF);

		assertNotNull(func);
	}


	/*
	@Test
	public void testSalvarFuncionario()
	{		
		Empresa emp = new Empresa();
		emp.setId(2L);
		emp.setRazaoSocial("teste LTDA");
		emp.setCnpj("70906492000164");
		Funcionario fun = new Funcionario();
		fun.setId(1L);
		fun.setNome("Daniel");
		fun.setEmpresa(new Empresa());
		fun.getEmpresa().setId(emp.getId());

		try
		{
			Empresa empre = empService.salvarEmpresa(emp);
			Funcionario func = funcionarioService.salvarFuncionario(fun);

			fail("Falha. Uma exceção deve ser lançada!");
		} catch (FuncionarioNotFoundException ex)
		{
			equals(ex.getMessage());
		}

	}*/

	private Funcionario obterDadosFuncionario(Empresa empresa)
	{
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setSenha("123");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private Empresa obterDadosEmpresa()
	{
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("51463645000100");
		return empresa;
	}

}
