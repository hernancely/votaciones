package com.ing.votaciones.candidato.component;

import com.ing.votaciones.candidato.dto.CandidatoDto;
import com.ing.votaciones.candidato.model.Candidato;
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
public class CandidatoConverter {

    public CandidatoDto modelToDto(Candidato candidato){
        var candidatoDto= new CandidatoDto();
        BeanUtils.copyProperties(candidato, candidatoDto);
        return candidatoDto;
    }
    public CandidatoDto optionalModelToDto(Optional<Candidato> candidato){
        var candidatoDto= new CandidatoDto();
        BeanUtils.copyProperties(candidato, candidatoDto);
        return candidatoDto;
    }

    public List<CandidatoDto> listModelToDto(List<Candidato> candidatos){
        List<CandidatoDto> candidatoDtos= new ArrayList<>();
        for (Candidato candidato: candidatos
        ) {
            candidatoDtos.add(modelToDto(candidato));
        }
        return candidatoDtos;
    }

    public Candidato dtoToModel(CandidatoDto candidatoDto){
        var candidato= new Candidato();
        BeanUtils.copyProperties(candidatoDto, candidato);
        return candidato;
    }
}
