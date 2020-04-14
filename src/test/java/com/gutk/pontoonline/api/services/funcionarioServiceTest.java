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
import com.gutk.pontoonline.api.enums.PerfilEnum;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@SpringBootTest
//@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
public class funcionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcReposotory;

	@Autowired
	private FuncionarioService funcService;
	
	
	private static final String EMAIL = "daniel@daniel.com";
	private static final String CPF = "01359072099";

	@BeforeEach
	public void setUp() {
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setSenha("123");
		//funcionario.setEmpresa(empresa);
		//return funcionario;
			

		BDDMockito.when(funcReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(funcionario));
		BDDMockito.given(funcReposotory.findByEmail(Mockito.anyString())).willReturn(funcionario);
		BDDMockito.given(funcReposotory.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(funcReposotory.save(Mockito.any(Funcionario.class))).willReturn(funcionario);

	}

	@Test
	public void testBuscarFuncionarioPorId() {
		Optional<Funcionario> func = Optional.ofNullable(funcService.buscarFuncionarioPorId(1L));

		assertNotNull(func);
	}
	
	/*

	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario funcio = funcService.salvarFuncionario(obterDadosFuncionario());
		Funcionario func = funcService.buscarFuncionarioPorEmail(EMAIL);

		assertEquals(EMAIL, func.getEmail());
	}*/

	@Test
	public void testBuscarFuncionarioPorCpf()  {
		Funcionario func = funcService.buscarFuncionarioPorCpf(CPF);

		assertNotNull(func);
	}

	/*
	@Test
	public void testSalvarFuncionario() {
		Funcionario funcionario = funcService.salvarFuncionario(new Funcionario());

		assertNotNull(funcionario);
	}*/
	
	private Funcionario obterDadosFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setSenha("123");
		//funcionario.setEmpresa(empresa);
		return funcionario;
	}
	
}
