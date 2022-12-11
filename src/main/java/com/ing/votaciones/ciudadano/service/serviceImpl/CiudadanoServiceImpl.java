package com.ing.votaciones.ciudadano.service.serviceImpl;

import com.ing.votaciones.ciudadano.dto.CiudadanoDto;
import com.ing.votaciones.ciudadano.repository.CiudadanoRepository;
import com.ing.votaciones.ciudadano.service.CiudadanoService;
import com.ing.votaciones.ciudadano.component.CiudadanoConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:37 p. m.
 * @Version 1.0
 */
@Service
public class CiudadanoServiceImpl implements CiudadanoService {

    @Autowired
    private CiudadanoRepository ciudadanoRepository;
    @Autowired
    private CiudadanoConverter ciudadanoConverter;


    @Override
    public CiudadanoDto add(CiudadanoDto ciudadanoDto) {
        var ciudadano = ciudadanoConverter.dtoToModel(ciudadanoDto);
        return ciudadanoConverter.modelToDto(ciudadanoRepository.save(ciudadano));
    }

    @Override
    public List<CiudadanoDto> getAll() {
        var ciudadanos = ciudadanoRepository.findAll();
        return ciudadanoConverter.listModelToDto(ciudadanos);
    }

    @Override
    public CiudadanoDto update(int id, CiudadanoDto ciudadanoDto) {
        var ciudadano = ciudadanoConverter.dtoToModel(ciudadanoDto);
        ciudadano = ciudadanoRepository.save(ciudadano);
        return ciudadanoConverter.modelToDto(ciudadano);
    }

    @Override
    public void delete(int id) {
        ciudadanoRepository.deleteById(id);
    }

    @Override
    public CiudadanoDto findById(int id) {
        var cliente = ciudadanoRepository.getReferenceById(id);
        return ciudadanoConverter.modelToDto(cliente);
    }
}
