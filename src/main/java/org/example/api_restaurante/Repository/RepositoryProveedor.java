package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.ProveedorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryProveedor extends JpaRepository<ProveedorModel,Long> {
}
