package com.ing3.votaciones.ciudadano.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:22 p. m.
 * @Version 1.0
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CiudadanoDto {

    private Integer cedula;
    private String apellidos;
    private String municipionacimiento;
    private Date fechanacimiento;
    private String municipioresidencia;
    private String nombres;
    private String pais;
    private String lugarvotacion;
    private String departamentoresidencia;

}
