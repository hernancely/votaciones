package com.ing.votaciones.ciudadano.service;

import com.ing.votaciones.ciudadano.dto.CiudadanoDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:37 p. m.
 * @Version 1.0
 */
@Service
public interface CiudadanoService {

    CiudadanoDto add(CiudadanoDto ciudadanoDto);

    List<CiudadanoDto> getAll();

    CiudadanoDto update(int id, CiudadanoDto ciudadanoDto);

    void delete(int id);

    CiudadanoDto findById(int id);

}
