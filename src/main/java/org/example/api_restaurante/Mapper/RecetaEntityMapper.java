package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.RecetaDTO;
import org.example.api_restaurante.Model.RecetaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface RecetaEntityMapper {
    RecetaModel toModel(RecetaDTO recetaDTO);
    RecetaDTO toDTO(RecetaModel recetaModel);
}
