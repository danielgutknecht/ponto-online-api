package com.gutk.pontoonline.api.endpoint.v1.dto;

import org.springframework.hateoas.RepresentationModel;

public class CadastroPJDTO extends RepresentationModel<CadastroPJDTO> {

    private long id;
    private String nome;
    private String email;
    private String cpf;
    // Não necessita retornar a senha que foi cadastrada.
    // private String senha;
    private String razaoSocial;
    private String cnpj;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
