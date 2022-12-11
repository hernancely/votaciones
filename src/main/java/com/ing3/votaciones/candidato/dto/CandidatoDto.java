package com.ing3.votaciones.candidato.dto;

import com.ing3.votaciones.ciudadano.model.Ciudadano;
import com.ing3.votaciones.votacion.model.Votacion;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:07 p. m.
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoDto {

    private Integer ciudadano_cedula;
    private String nombre;
    private String eslogan;
    private String patidoPolitico;
    private String propuesta;
}
