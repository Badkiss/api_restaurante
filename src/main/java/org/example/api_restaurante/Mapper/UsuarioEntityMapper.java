package org.example.api_restaurante.Mapper;

import jakarta.persistence.Column;
import org.example.api_restaurante.Model.UsuarioDTO;
import org.example.api_restaurante.Model.UsuarioModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import org.mapstruct.MappingConstants;
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioEntityMapper {
    UsuarioModel toModel(UsuarioDTO usuarioDTO);
    UsuarioDTO toDTO(UsuarioModel usuarioModel);
}
