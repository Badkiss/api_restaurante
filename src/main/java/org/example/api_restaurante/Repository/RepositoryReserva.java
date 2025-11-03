package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryReserva extends JpaRepository<ReservaModel, Long> {
}
