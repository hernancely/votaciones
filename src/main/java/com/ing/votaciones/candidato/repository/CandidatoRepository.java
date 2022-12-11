package com.ing.votaciones.candidato.repository;

import com.ing.votaciones.candidato.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:07 p. m.
 * @Version 1.0
 */
public interface CandidatoRepository extends JpaRepository<Candidato,Integer> {
}
