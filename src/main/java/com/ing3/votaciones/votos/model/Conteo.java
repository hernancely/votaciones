package com.ing3.votaciones.votos.model;

import com.ing3.votaciones.candidato.model.Candidato;
import com.ing3.votaciones.ciudadano.model.Ciudadano;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Hernan Cely
 * @Date: 10/12/2022 12:15 p. m.
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conteo {

    private Candidato candidatoId;
    private Long conteo;
}
