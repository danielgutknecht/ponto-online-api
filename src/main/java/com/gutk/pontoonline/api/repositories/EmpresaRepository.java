package com.gutk.pontoonline.api.repositories;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gutk.pontoonline.api.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

	@Transactional
	Empresa findByCnpj(String cnpj);
	
	Boolean existsByCnpj(String cnpj);
}
