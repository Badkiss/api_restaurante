package org.example.api_restaurante.Services;

import org.example.api_restaurante.Mapper.MesaEntityMapper;
import org.example.api_restaurante.Model.MesaDTO;
import org.example.api_restaurante.Model.MesaModel;
import org.example.api_restaurante.Repository.RepositoryMesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MesaServices {
    @Autowired
    private RepositoryMesa mesaRepository;
    @Autowired
    private MesaEntityMapper mesaEntityMapper;

    public List<MesaDTO> allMesa( ) {
        List<MesaModel> mesaModels = mesaRepository.findAll();

        return  mesaModels.stream().map(mesaEntityMapper::toDTO).collect(Collectors.toList());
    }
    public MesaDTO mesaById(Long id) {
        return mesaEntityMapper.toDTO(mesaRepository.findById(id).get());
    }
    public String addMesa(MesaDTO mesaDTO) {
        MesaModel mesaModel1 = new MesaModel();
        mesaModel1.setCantidad(mesaDTO.getCantidad());
        mesaRepository.save(mesaModel1);
        return "Mesa agregada";
    }
    public String updateMesa(MesaDTO mesaDTO) {
        if (mesaRepository.existsById(mesaDTO.getId())) {
            return "No se encontro la mesa";
        }
       MesaModel mesaModel = mesaRepository.findById(mesaDTO.getId()).get();
        mesaModel.setCantidad(mesaDTO.getCantidad());
        mesaRepository.save(mesaModel);
        return "Mesa actualizada";
    }
    public String deleteMesa(Long id) {
        mesaRepository.deleteById(id);
        return "Mesa eliminada";
    }
}
