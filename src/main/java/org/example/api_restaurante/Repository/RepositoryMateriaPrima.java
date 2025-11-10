package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMateriaPrima  extends JpaRepository<MateriaPrimaModel, Long> {
     List<MateriaPrimaModel> findByNombre(String nombre);
     MateriaPrimaModel findByNombreAndProveedor(String nombre, Long proveedor);
     boolean existsByNombreAndProveedor(String nombre, Long proveedor);
}
