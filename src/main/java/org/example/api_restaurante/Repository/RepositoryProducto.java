package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProducto extends JpaRepository<ProductoModel,Long> {
}
