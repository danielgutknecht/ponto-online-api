package com.gutk.pontoonline.api.dtos;

import java.util.Optional;

public class funcionarioDto {
	private Long id;
	private String nome;
	private String email;
	
	//Atualiza a senha se for modificada
	private Optional<String> senha = Optional.empty();
	private Optional<String> valorHora = Optional.empty();
	private Optional<String> qtdHorasTrabalhoDia = Optional.empty();
	private Optional<String> qtdHorasAlmoco = Optional.empty();
	
	
}
