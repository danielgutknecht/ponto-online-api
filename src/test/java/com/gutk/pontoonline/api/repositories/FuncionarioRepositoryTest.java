package com.gutk.pontoonline.api.repositories;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.gutk.pontoonline.api.entities.Funcionario;

@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {
	
	@Autowired
	private FuncionarioRepository funcRepository;
	
	private static final String EMAIL = "daniel@daniel.com";
	private static final String CPF = "01359072099";
	
	@BeforeAll
	public void setUp() {
		
	}
	public Funcionario setupEmpresa() {
		Funcionario func = new Funcionario();
		func.setNome("Daniel");
		func.setEmail(EMAIL);
		func.setCpf(CPF);
		
		
		return func;
	}
	
	
	
	

}
