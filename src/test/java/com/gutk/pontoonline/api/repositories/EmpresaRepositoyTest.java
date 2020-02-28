package com.gutk.pontoonline.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.gutk.pontoonline.api.entities.Empresa;


@SpringBootTest
@ActiveProfiles("test")
public class EmpresaRepositoyTest {
	
	@Autowired
	private EmpresaRepository empRepository;
	
	private static final String CNPJ = "432123132000155";
	
	@BeforeEach
	public void setUp() {
		Empresa emp = new Empresa();
		emp.setRazaoSocial("Empresa Test");
		emp.setCnpj(CNPJ);
		empRepository.save(emp);
	}
	
	@AfterEach
	public final void tearDown() {
		empRepository.deleteAll();
	}
	
	@Test
	public void testBuscarPorCnpj() {
		Empresa empr = empRepository.findByCnpj(CNPJ);
		
			
		assertEquals(CNPJ, empr.getCnpj());
	}	
}
