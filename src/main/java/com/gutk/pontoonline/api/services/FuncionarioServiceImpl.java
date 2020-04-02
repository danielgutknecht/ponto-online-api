package com.gutk.pontoonline.api.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gutk.pontoonline.api.endpoint.response.exceptions.FuncionarioNotFoundException;
import com.gutk.pontoonline.api.entities.Funcionario;
import com.gutk.pontoonline.api.repositories.FuncionarioRepository;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EmpresaService empresaService;
 

    @Override
    public Funcionario buscarFuncionarioPorCpf(String cpf) {

        return funcionarioRepository.findByCpf(cpf);
    }

    @Override
    public Funcionario buscarFuncionarioPorEmail(String email) {

        return funcionarioRepository.findByEmail(email);
    }

    @Override
    public Funcionario buscarFuncionarioPorId(Long id) {
    	
    	Optional<Funcionario> funcionario = funcionarioRepository.findById(id); 

        return funcionario.orElseThrow(() -> new FuncionarioNotFoundException(id));
    }
    
    @Override
    public Funcionario criarFuncionario(Funcionario novoFuncionario) {

        return funcionarioRepository.save(novoFuncionario);
    } 

}
