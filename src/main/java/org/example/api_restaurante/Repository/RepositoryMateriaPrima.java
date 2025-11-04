package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryMateriaPrima  extends JpaRepository<MateriaPrimaModel, Long> {
    @Query("select  m from MateriaPrimaModel m where m.nombre like %?1%")
    public List<MateriaPrimaModel> findByNombre(String nombre);
}
