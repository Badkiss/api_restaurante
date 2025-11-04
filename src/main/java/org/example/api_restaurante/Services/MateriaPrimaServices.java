package org.example.api_restaurante.Services;

import org.example.api_restaurante.Model.MateriaPrimaDTO;
import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.example.api_restaurante.Repository.RepositoryMateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaPrimaServices {
    @Autowired
    private RepositoryMateriaPrima repoMateriaPrima;

    public List<MateriaPrimaModel> getAll(){
        return repoMateriaPrima.findAll();
    }
    public MateriaPrimaModel getMateriaPrimaById(Long id) {
        return repoMateriaPrima.findById(id).get();
    }
    public MateriaPrimaModel getMateriaPrimaByNombre(String nombre) {

        return repoMateriaPrima.findByNombre(nombre).get(0);
    }
    public void add(MateriaPrimaModel materiaPrima) {
        repoMateriaPrima.save(materiaPrima);
    }
    public void update(MateriaPrimaModel materiaPrima) {
        repoMateriaPrima.save(materiaPrima);
    }
    public void delete(Long id) {
        repoMateriaPrima.deleteById(id);
    }
}
