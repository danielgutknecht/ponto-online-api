package com.gutk.pontoonline.api.services;

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
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@SpringBootTest
//@TestPropertySource("classpath:application-test.properties")
@ActiveProfiles("test")
public class funcionarioServiceTest {

	@MockBean
	private FuncionarioRepository funcReposotory;

	@Autowired
	private FuncionarioService funcService;

	@BeforeEach
	public void setUp() {

		Funcionario func = new Funcionario();

		BDDMockito.when(funcReposotory.findById(Mockito.anyLong())).thenReturn(Optional.of(func));
		BDDMockito.given(funcReposotory.findByEmail(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(funcReposotory.findByCpf(Mockito.anyString())).willReturn(new Funcionario());
		BDDMockito.given(funcReposotory.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());

	}

	@Test
	public void testBuscarFuncionarioPorId() {
		Optional<Funcionario> func = Optional.ofNullable(funcService.buscarFuncionarioPorId(1L));

		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorEmail() {
		Funcionario func = funcService.buscarFuncionarioPorEmail("email@email.com");

		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorCpf()  {
		Funcionario func = funcService.buscarFuncionarioPorCpf("01353498712");

		assertNotNull(func);
	}

	@Test
	public void testSalvarFuncionario() {
		Funcionario funcionario = funcService.criarFuncionario(new Funcionario());

		assertNotNull(funcionario);
	}
	
	/*
	@Test
	public void testAtualizarFuncionario() {
		Funcionario func = funcService.(1L, new Funcionario());
		
		assertNotNull(func);
	}*/
}
