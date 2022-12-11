package com.ing.votaciones.votacion.component;

import com.ing.votaciones.votacion.dto.VotacionDto;
import com.ing.votaciones.votacion.model.Votacion;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:07 p. m.
 * @Version 1.0
 */
@Component
public class VotacionConverter {

    public VotacionDto modelToDto(Votacion votacion){
        var votacionDto = new VotacionDto();
        BeanUtils.copyProperties(votacion, votacionDto);
        return votacionDto;
    }
    public VotacionDto optionalModelToDto(Optional<Votacion> votacion){
        var votacionDto= new VotacionDto();
        BeanUtils.copyProperties(votacion, votacionDto);
        return votacionDto;
    }

    public List<VotacionDto> listModelToDto(List<Votacion> votacions){
        List<VotacionDto> votacionDtos= new ArrayList<>();
        for (Votacion votacion: votacions
        ) {
            votacionDtos.add(modelToDto(votacion));
        }
        return votacionDtos;
    }

    public Votacion dtoToModel(VotacionDto votacionDto){
        var votacion= new Votacion();
        BeanUtils.copyProperties(votacionDto, votacion);
        return votacion;
    }
}
