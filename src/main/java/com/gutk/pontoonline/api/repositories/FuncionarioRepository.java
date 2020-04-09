package com.gutk.pontoonline.api.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.gutk.pontoonline.api.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long>
{

	Funcionario findByNome(String nome);

	Funcionario findByCpf(String cpf);

	Funcionario findByEmail(String email);

	Funcionario findByCpfOrEmail(String cpf, String email);

	Boolean existsByEmail(String email);
	
	Boolean existsByCpf(String cpf);

}
