package com.ing3.votaciones.votacion.model;

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
@Entity
@Data
@Table(name = "votacion")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Votacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "ciudadano_cedula",referencedColumnName = "cedula")
    private Ciudadano ciudadano_cedula;


    @ManyToOne
    @JoinColumn(name = "candidatoId",referencedColumnName = "id")
    private Candidato candidatoId;

    private int conteo;

}
