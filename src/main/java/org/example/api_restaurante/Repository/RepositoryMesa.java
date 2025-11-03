package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.MesaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryMesa extends JpaRepository<MesaModel, Long> {
}
