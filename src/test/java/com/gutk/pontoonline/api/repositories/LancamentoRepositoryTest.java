package com.gutk.pontoonline.api.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.entities.Lancamento;
import com.gutk.pontoonline.api.enums.PerfilEnum;
import com.gutk.pontoonline.api.enums.TipoEnum;

@SpringBootTest
@ActiveProfiles("test")
public class LancamentoRepositoryTest {

	@Autowired
	private LancamentoRepository lancRepository;
	@Autowired
	private FuncionarioRepository funcRepository;
	@Autowired
	private EmpresaRepository empRepository;

	private Long funcionario_id;

	@BeforeEach
	public void setUP() {
		Empresa emp = empRepository.save(obterDadosEmpresa());

		Funcionario func = funcRepository.save(obterDadosFuncionario(emp));
		funcionario_id = func.getId();

		lancRepository.save(obterDadosLancamentos(func));
	}

	@AfterEach
	public final void tearDown() {
		empRepository.deleteAll();
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioId() {
		List<Lancamento> lancamentos = lancRepository.findByFuncionarioId(funcionario_id);

		assertEquals(1, lancamentos.size());
	}

	@Test
	public void testBuscarLancamentoPorFuncionarioIdPaginado() {
		
		Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		Page<Lancamento> lancamentos = lancRepository.findByFuncionarioId(funcionario_id, firstPageWithTwoElements);
		
		assertEquals(2, lancamentos.getSize());
	}

	private Lancamento obterDadosLancamentos(Funcionario funcionario) {
		Lancamento lancamento = new Lancamento();
		lancamento.setTipo(TipoEnum.INICIO_ALMOCO);
		lancamento.setFuncionario(funcionario);
		return lancamento;
	}

	private Funcionario obterDadosFuncionario(Empresa empresa) {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Fulano de Tal");
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf("01375634298");
		funcionario.setEmail("daniel@email.com");
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
