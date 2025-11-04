package org.example.api_restaurante.Mapper;

import org.example.api_restaurante.Model.ProductoDTO;
import org.example.api_restaurante.Model.ProductoModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoEntityMapper {
    ProductoModel toModel(ProductoDTO productoDTO);
    ProductoDTO toDTO(ProductoModel productoModel);
}
