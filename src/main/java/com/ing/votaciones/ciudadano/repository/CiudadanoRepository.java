package com.ing.votaciones.ciudadano.repository;

import com.ing.votaciones.ciudadano.model.Ciudadano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:32 p. m.
 * @Version 1.0
 */
@Repository
public interface CiudadanoRepository extends JpaRepository<Ciudadano, Integer> {
    void deleteById(int id);
    Ciudadano getReferenceById(Integer id);
}
