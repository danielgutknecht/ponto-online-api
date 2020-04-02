package com.gutk.pontoonline.api.endpoint.v1.mapper;

import com.gutk.pontoonline.api.endpoint.v1.dto.CadastroPJDTO;
import com.gutk.pontoonline.api.endpoint.v1.dto.input.CadastroPJDTOInput;
import com.gutk.pontoonline.api.entities.Empresa;
import com.gutk.pontoonline.api.entities.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CadastroPjDtoMapperStruct {

    @Mapping(target = "razaoSocial", source = "empresa.razaoSocial")
    @Mapping(target = "cnpj", source = "empresa.cnpj")
    CadastroPJDTOInput modelToDto(Funcionario funcionario);

    @Mapping(target = "empresa.razaoSocial", source = "razaoSocial")
    @Mapping(target = "empresa.cnpj", source = "cnpj")
    Funcionario dtoToModel(CadastroPJDTOInput cadastroPJDtoInput);

}
