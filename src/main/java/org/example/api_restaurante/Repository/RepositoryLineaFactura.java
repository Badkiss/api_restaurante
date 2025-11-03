package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.LineaFacturaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryLineaFactura extends JpaRepository<LineaFacturaModel,Long> {
}
