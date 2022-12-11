package com.ing3.votaciones.votacion.repository;

import com.ing3.votaciones.votacion.model.Votacion;
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
public interface VotacionRepository extends JpaRepository<Votacion,Integer> {


    @Query(value = "SELECT * FROM votacion WHERE ciudadano_cedula=?1",nativeQuery = true)
    Votacion findVotacionByCiudadano_cedula(Integer cedula);

    @Query(value = "select id,candidato_id,ciudadano_cedula, count(v.candidato_id) as conteo from votacion v group by v.candidato_id",nativeQuery = true)
    List<Object> countAll();
}
