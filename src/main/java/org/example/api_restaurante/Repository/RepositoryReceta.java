package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.RecetaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReceta extends JpaRepository<RecetaModel, Integer> {
}
