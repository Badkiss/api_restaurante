package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.ProveedorDTO;
import org.example.api_restaurante.Model.ProveedorModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProveedorEntityMapper {
    ProveedorModel toModel(ProveedorDTO proveedorDTO);
    ProveedorDTO toDTO(ProveedorModel proveedorModel);
}
