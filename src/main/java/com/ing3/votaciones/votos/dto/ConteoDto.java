package com.ing3.votaciones.votos.dto;

import com.ing3.votaciones.candidato.model.Candidato;
import com.ing3.votaciones.ciudadano.model.Ciudadano;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author: Hernan Cely
 * @Date: 10/12/2022 12:15 p. m.
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConteoDto {

    private long numero_candidato;
    private String nombre;
    private long conteo;
}
