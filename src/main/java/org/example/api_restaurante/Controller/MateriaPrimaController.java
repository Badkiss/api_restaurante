package org.example.api_restaurante.Controller;

import org.example.api_restaurante.Mapper.MateriaPrimaEntityMapper;
import org.example.api_restaurante.Model.MateriaPrimaDTO;
import org.example.api_restaurante.Model.MateriaPrimaModel;
import org.example.api_restaurante.Repository.RepositoryMateriaPrima;
import org.example.api_restaurante.Services.MateriaPrimaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/material")
public class MateriaPrimaController {
    @Autowired
    private MateriaPrimaServices materiaPrimaServices;
    @Autowired
    private MateriaPrimaEntityMapper materiaPrimaEntityMapper;

    @GetMapping("/all")
    public List<MateriaPrimaDTO> getAllMateriaPrima() {
        List<MateriaPrimaDTO> materiaPrimaDTOS = materiaPrimaServices.getAll().stream().map(materiaPrimaEntityMapper::toDTO).collect(Collectors.toList());
        return materiaPrimaDTOS;
    }
    @GetMapping("/{id}")
    public MateriaPrimaDTO getMateriaPrimaId(@PathVariable Long id) {
        return materiaPrimaEntityMapper.toDTO(materiaPrimaServices.getMateriaPrimaById(id));
    }
    @GetMapping("/{nombre}")
    public MateriaPrimaDTO getMateriaPrimaName(@PathVariable String nombre ){
        return materiaPrimaEntityMapper.toDTO(materiaPrimaServices.getMateriaPrimaByNombre(nombre));
    }
    @PostMapping("/add")
    public void addMateriaPrima(@RequestBody MateriaPrimaDTO materiaPrimaDTO) {
        materiaPrimaServices.add(materiaPrimaEntityMapper.toModel(materiaPrimaDTO));
    }
    @PutMapping("/update")
    public void updateMateriaPrima(@RequestBody MateriaPrimaModel materiaPrimaModel) {
        materiaPrimaServices.update( materiaPrimaModel );
    }
   @DeleteMapping("/delete/{id}")
    public void deleteMateriaPrima(@PathVariable Long id) {
         materiaPrimaServices.delete(id);
   }
}
