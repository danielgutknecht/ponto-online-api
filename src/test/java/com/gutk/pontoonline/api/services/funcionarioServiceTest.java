package com.gutk.pontoonline.api.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;


@SpringBootTest
//@TestPropertySource("classpath:application-test.properties")
//@ActiveProfiles("test")
public class funcionarioServiceTest {
	
	@Autowired
	private FuncionarioRepository funcReposotory;
	
	@Autowired
	private FuncionarioService funcService;
	
	@BeforeEach
	public void setUp() {
		BDDMockito.given(this.funcReposotory.save(Mockito.any(Funcionario.class))).willReturn(new Funcionario());
	}
	
	@Test
	public void testSalvarFuncionario() {
		Funcionario funcionario = funcService.createOrUpdateFuncionario(new Funcionario());
		
		assertNotNull(funcionario);
	}
}
