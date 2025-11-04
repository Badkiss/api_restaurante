package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.MateriaPrimaDTO;
import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface MateriaPrimaEntityMapper {
    MateriaPrimaModel toModel(MateriaPrimaDTO materiaPrimaDTO);
    MateriaPrimaDTO toDTO(MateriaPrimaModel materiaPrimaModel);
}
