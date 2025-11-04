package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.MesaDTO;
import org.example.api_restaurante.Model.MesaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface MesaEntityMapper {
    MesaModel toModel(MesaDTO mesaDTO);
    MesaDTO toDTO(MesaModel mesaModel);
}
