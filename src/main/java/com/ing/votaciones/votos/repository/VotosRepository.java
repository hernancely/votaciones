package com.ing.votaciones.votos.repository;

import com.ing.votaciones.votos.model.Conteo;
import com.ing.votaciones.votacion.model.Votacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:07 p. m.
 * @Version 1.0
 */
@Repository
public interface VotosRepository extends JpaRepository<Votacion,Integer> {

    @Query(value = "select NEW com.ing.votaciones.votos.model.Conteo( v.candidatoId,count(v.candidatoId)) from Votacion v group by v.candidatoId")
    List<Conteo> countAll();
}
