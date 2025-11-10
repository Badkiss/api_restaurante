package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.ProductoModel;
import org.example.api_restaurante.Model.RecetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryReceta extends JpaRepository<RecetaModel, Integer> {
    List<RecetaModel> findByProducto_Id(Long productoId);
    List<RecetaModel> findByProducto_Nombre(String productoNombre);
    void deleteByProducto_Id(Long productoId);
}
