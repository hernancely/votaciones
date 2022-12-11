package com.ing3.votaciones.votacion.dto;

import com.ing3.votaciones.candidato.model.Candidato;
import com.ing3.votaciones.ciudadano.model.Ciudadano;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:07 p. m.
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VotacionDto {

    private Integer id;

    private Integer ciudadano_cedula;

    private int candidatoId;

}
