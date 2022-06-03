package com.gutk.pontoonline.api.repositories;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.gutk.pontoonline.api.entities.Funcionario;

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Long> {

	Funcionario findByNome(String nome);

	Optional<Funcionario> findByCpf(String cpf);

	Optional<Funcionario> findByEmail(String email);

	Funcionario findByCpfOrEmail(String cpf, String email);

	Boolean existsByEmail(String email);

	Boolean existsByCpf(String cpf);

}
