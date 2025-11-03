package org.example.api_restaurante.Repository;

import org.example.api_restaurante.Model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuario extends JpaRepository<UsuarioModel,Long> {
}
