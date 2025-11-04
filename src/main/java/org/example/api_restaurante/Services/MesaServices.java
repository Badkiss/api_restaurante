package org.example.api_restaurante.Services;

import org.example.api_restaurante.Model.MesaDTO;
import org.example.api_restaurante.Model.MesaModel;
import org.example.api_restaurante.Repository.RepositoryMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServices {
    @Autowired
    private RepositoryMesa mesaRepository;

    public List<MesaModel> allMesa( ) {
        List<MesaModel> mesaModels = mesaRepository.findAll();
        return mesaModels;
    }
    public MesaModel mesaById(Long id) {
        return mesaRepository.findById(id).get();
    }
    public void addMesa(MesaDTO mesaDTO) {
        MesaModel mesaModel1 = new MesaModel();
        mesaModel1.setCantidad(mesaDTO.getCantidad());
        mesaRepository.save(mesaModel1);
    }
    public void updateMesa(MesaModel mesaModel) {
        mesaRepository.save(mesaModel);
    }
    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }
}
