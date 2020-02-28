package com.gutk.pontoonline.api.repositories;

import java.awt.print.Pageable;
import java.util.Collection;
import javax.persistence.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.gutk.pontoonline.api.entities.Lancamento;


@NamedQuery(name = "LancamentoRepository.findByFuncionarioId", 
			query = "SELECT lanc FROM Funcionario lanc WHERE lanc.funcionario.id = :funcionarioId")

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	Collection<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	//Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
		
}
