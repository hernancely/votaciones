package com.ing.votaciones.candidato.service;

import com.ing.votaciones.candidato.dto.CandidatoDto;
import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:08 p. m.
 * @Version 1.0
 */
public interface CandidatoService {
    Object add(CandidatoDto candidatoDto);

    List<CandidatoDto> getAll();

    CandidatoDto findById(int id);

    Object update(Integer cedula, @MappingTarget CandidatoDto candidatoDto);

    void delete(int id);
}
