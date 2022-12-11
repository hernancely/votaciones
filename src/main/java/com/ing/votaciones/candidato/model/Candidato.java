package com.ing.votaciones.candidato.model;

import com.ing.votaciones.votacion.model.Votacion;
import com.ing.votaciones.ciudadano.model.Ciudadano;
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
@Entity
@Data
@Table(name = "candidato")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Candidato {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombre;
    @Column
    private String eslogan;
    @Column
    private String patidoPolitico;
    @Column
    private String propuesta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ciudadano_cedula", referencedColumnName = "cedula", nullable = false, unique = true)
    private Ciudadano ciudadano_cedula;

    @OneToMany(mappedBy = "candidatoId")
    private List<Votacion> voto;

}
