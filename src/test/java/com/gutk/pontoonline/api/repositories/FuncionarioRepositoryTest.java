package com.gutk.pontoonline.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.enums.PerfilEnum;

@SpringBootTest
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository funcRepository;

	@Autowired
	private EmpresaRepository empRepository;

	private static final String EMAIL = "daniel@daniel.com";
	private static final String CPF = "01359072099";

	@BeforeEach
	public void setUp() {

		Empresa empresa = empRepository.save(obterDadosEmpresa());
		Funcionario funcionario = funcRepository.save(obterDadosFuncionario(empresa));

	}

	@AfterEach
	public final void tearDown() {
		empRepository.deleteAll();
	}

	@Test
	public void testBuscarFuncionarioPorEmail() {
		Optional<Funcionario> func = funcRepository.findByEmail(EMAIL);

		assertEquals(EMAIL, func.get());
	}

	@Test
	public void testBuscaFuncionarioPorCpf() {
		Optional<Funcionario> func = funcRepository.findByCpf(CPF);
		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorCpfOuEmail() {
		Funcionario func = funcRepository.findByCpfOrEmail(CPF, EMAIL);
		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorEmailouCpfParaEmailInvalido() {
		Funcionario func = funcRepository.findByCpfOrEmail(CPF, "email@invalido.com");
		assertNotNull(func);
	}

	@Test
	public void testBuscarFuncionarioPorEmailOuCpfParaCpfInvalido() {
		Funcionario func = funcRepository.findByCpfOrEmail("12345678900", EMAIL);
		assertNotNull(func);
	}

	@Test
	public void testSalvarFuncionario() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Daniel");
		Funcionario func = funcRepository.save(funcionario);

		assertEquals(funcionario.getNome(), func.getNome());
	}

	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf(CPF);
		funcionario.setEmail(EMAIL);
		funcionario.setSenha("123");
		funcionario.setEmpresa(empresa);
		return funcionario;
	}

	private Empresa obterDadosEmpresa() {
		Empresa empresa = new Empresa();
		empresa.setRazaoSocial("Empresa de exemplo");
		empresa.setCnpj("51463645000100");
		return empresa;
	}

}
