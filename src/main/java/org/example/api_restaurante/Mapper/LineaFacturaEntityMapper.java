package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.LineaFacturaDTO;
import org.example.api_restaurante.Model.LineaFacturaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface LineaFacturaEntityMapper {
    LineaFacturaModel toModel(LineaFacturaDTO lineaFacturaDTO);
    LineaFacturaDTO toDTO(LineaFacturaModel lineaFacturaModel);
}
