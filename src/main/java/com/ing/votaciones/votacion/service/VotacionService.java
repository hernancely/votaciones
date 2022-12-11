package com.ing.votaciones.votacion.service;

import com.ing.votaciones.votacion.dto.VotacionDto;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:08 p. m.
 * @Version 1.0
 */
public interface VotacionService {

    Object add(VotacionDto votacionDto);

    VotacionDto findById(int id);
}
