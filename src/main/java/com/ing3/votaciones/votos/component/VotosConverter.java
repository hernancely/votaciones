package com.ing3.votaciones.votos.component;

import com.ing3.votaciones.votos.dto.ConteoDto;
import com.ing3.votaciones.votos.model.Conteo;
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
public class VotosConverter {

    public ConteoDto modelToDto(Conteo conteo){
        var conteoDto = new ConteoDto();
        BeanUtils.copyProperties(conteo, conteoDto);
        conteoDto.setNumero_candidato(conteo.getCandidatoId().getId());
        conteoDto.setNombre(conteo.getCandidatoId().getNombre());
        return conteoDto;
    }
    public ConteoDto optionalModelToDto(Optional<Conteo> votacion){
        var votacionDto= new ConteoDto();
        BeanUtils.copyProperties(votacion, votacionDto);
        return votacionDto;
    }

    public List<ConteoDto> listModelToDto(List<Conteo> conteos){
        List<ConteoDto> conteoDtos= new ArrayList<>();
        for (Conteo votacion: conteos
        ) {
            conteoDtos.add(modelToDto(votacion));
        }
        return conteoDtos;
    }
}
