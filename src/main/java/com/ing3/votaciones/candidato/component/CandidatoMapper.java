package com.ing3.votaciones.candidato.component;

import com.ing3.votaciones.candidato.dto.CandidatoDto;
import com.ing3.votaciones.candidato.model.Candidato;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author: Hernan Cely
 * @Date: 8/12/2022 6:45 p. m.
 * @Version 1.0
 */
@Component
@Mapper(componentModel = "spring")
public interface CandidatoMapper {
    void updateCustomerFromDto(CandidatoDto dto, @MappingTarget Candidato entity);
}

