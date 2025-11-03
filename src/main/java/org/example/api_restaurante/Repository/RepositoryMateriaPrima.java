package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMateriaPrima  extends JpaRepository<MateriaPrimaModel, Long> {
}
