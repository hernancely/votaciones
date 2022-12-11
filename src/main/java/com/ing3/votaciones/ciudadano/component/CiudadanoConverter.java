package com.ing3.votaciones.ciudadano.component;

import com.ing3.votaciones.ciudadano.dto.CiudadanoDto;
import com.ing3.votaciones.ciudadano.model.Ciudadano;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CiudadanoConverter {

    public CiudadanoDto modelToDto(Ciudadano ciudadano){
        var ciudadanoDto= new CiudadanoDto();
        BeanUtils.copyProperties(ciudadano, ciudadanoDto);
        return ciudadanoDto;
    }
    public CiudadanoDto optionalModelToDto(Optional<Ciudadano> ciudadano){
        var ciudadanoDto= new CiudadanoDto();
        BeanUtils.copyProperties(ciudadano, ciudadanoDto);
        return ciudadanoDto;
    }

    public List<CiudadanoDto> listModelToDto(List<Ciudadano> ciudadanos){
        List<CiudadanoDto> ciudadanoDto= new ArrayList<>();
        for (Ciudadano ciudadano: ciudadanos
             ) {
            ciudadanoDto.add(modelToDto(ciudadano));
        }
        return ciudadanoDto;
    }

    public Ciudadano dtoToModel(CiudadanoDto ciudadanoDto){
        var ciudadano= new Ciudadano();
        BeanUtils.copyProperties(ciudadanoDto, ciudadano);
        return ciudadano;
    }
}
