package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.MateriaPrimaEntityMapper;
import org.example.api_restaurante.Model.MateriaPrimaDTO;
import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.example.api_restaurante.Repository.RepositoryMateriaPrima;
import org.example.api_restaurante.Repository.RepositoryProveedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MateriaPrimaServices {
    @Autowired
    private RepositoryMateriaPrima repoMateriaPrima;
    @Autowired
    private MateriaPrimaEntityMapper materiaPrimaEntityMapper;
    @Autowired
    private RepositoryProveedor repositoryProveedor;

    public List<MateriaPrimaDTO> getAll(){
        List<MateriaPrimaModel> materias=repoMateriaPrima.findAll();
        return materias.stream().map(materiaPrimaEntityMapper::toDTO).collect(Collectors.toList());
    }
    public MateriaPrimaDTO getMateriaPrimaById(Long id) {
        return materiaPrimaEntityMapper.toDTO(repoMateriaPrima.findById(id).get());
    }
    public List<MateriaPrimaDTO> getMateriaPrimaByNombre(String nombre) {
        List<MateriaPrimaModel> materias=repoMateriaPrima.findByNombre(nombre);
        List<MateriaPrimaDTO> materiaPrimaDTOS=materias.stream().map(materiaPrimaEntityMapper::toDTO).collect(Collectors.toList());
        return materiaPrimaDTOS;
    }
    public String add(MateriaPrimaDTO materiaPrima) {
        if (repoMateriaPrima.existsByNombreAndProveedor(materiaPrima.getNombre(), materiaPrima.getProveedor())) {
            return "Materia ya creada";
        }
       MateriaPrimaModel materiaPrimaModel= materiaPrimaEntityMapper.toModel(materiaPrima);
        materiaPrimaModel.setProveedor(repositoryProveedor.findById(materiaPrima.getProveedor()).get().getId());
        repoMateriaPrima.save(materiaPrimaModel);
        return "Materia prima creada";

    }
    public String update(MateriaPrimaDTO materiaPrima) {
        if (!repoMateriaPrima.existsByNombreAndProveedor(materiaPrima.getNombre(), materiaPrima.getProveedor())) {
            return "Materia no encontrada";
        }
        MateriaPrimaModel materiaPrimaModel= repoMateriaPrima.findByNombreAndProveedor(materiaPrima.getNombre(), materiaPrima.getProveedor());
        materiaPrimaModel.setCantidadMedida(materiaPrima.getCantidadMedida());
        materiaPrimaModel.setPrecioMedida( materiaPrima.getPrecioMedida());
        materiaPrimaModel.setCantidad(materiaPrima.getCantidad());
        repoMateriaPrima.save(materiaPrimaModel);
        return "Materia prima actualizada";
    }
    public String delete(String nombre,Long proveedor) {
        if (!repoMateriaPrima.existsByNombreAndProveedor(nombre, proveedor)){
            return "Materia no encontrada";
        }
        repoMateriaPrima.deleteById(repoMateriaPrima.findByNombreAndProveedor(nombre, proveedor).getId());
        return "Materia eliminada";

    }
}
