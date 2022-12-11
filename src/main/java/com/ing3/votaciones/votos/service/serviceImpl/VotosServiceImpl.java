package com.ing3.votaciones.votos.service.serviceImpl;

import com.ing3.votaciones.candidato.repository.CandidatoRepository;
import com.ing3.votaciones.ciudadano.repository.CiudadanoRepository;
import com.ing3.votaciones.votos.component.VotosConverter;
import com.ing3.votaciones.votos.dto.ConteoDto;
import com.ing3.votaciones.votos.repository.VotosRepository;
import com.ing3.votaciones.votos.service.VotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:11 p. m.
 * @Version 1.0
 */
@Service
public class VotosServiceImpl implements VotosService {

    @Autowired
    private VotosRepository votosRepository;
    @Autowired
    private VotosConverter votosConverter;

    @Override
    public List<ConteoDto> getAll() {
       var votacionList = votosRepository.countAll();
        return votosConverter.listModelToDto(votacionList);
    }

}
