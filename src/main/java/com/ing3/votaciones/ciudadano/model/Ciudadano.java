package com.ing3.votaciones.ciudadano.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ing3.votaciones.candidato.model.Candidato;
import com.ing3.votaciones.votacion.model.Votacion;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:22 p. m.
 * @Version 1.0
 */

@Entity
@Data
@Table(name = "ciudadano")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Ciudadano {

    @Id
    @Generated
    private Integer cedula;
    @Column
    private String apellidos;
    @Column
    private String municipionacimiento;
    @Column
    private Date fechanacimiento;
    @Column
    private String municipioresidencia;
    @Column
    private String nombres;
    @Column
    private String pais;
    @Column
    private String lugarvotacion;
    @Column
    private String departamentoresidencia;

    @OneToOne(mappedBy = "ciudadano_cedula")
    private Votacion votacion;

    @OneToOne(mappedBy = "ciudadano_cedula")
    private Candidato candidato;

}
