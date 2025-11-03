package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.FacturaDTO;
import org.example.api_restaurante.Model.FacturaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface FacturaEntityMapper {
    FacturaModel toModel(FacturaDTO facturaDTO);
    FacturaDTO toDTO(FacturaModel facturaModel);
}
