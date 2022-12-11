package com.ing3.votaciones.votacion.service.serviceImpl;

import com.ing3.votaciones.candidato.repository.CandidatoRepository;
import com.ing3.votaciones.ciudadano.repository.CiudadanoRepository;
import com.ing3.votaciones.votacion.component.VotacionConverter;
import com.ing3.votaciones.votacion.dto.VotacionDto;
import com.ing3.votaciones.votacion.repository.VotacionRepository;
import com.ing3.votaciones.votacion.service.VotacionService;
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
public class VotacionServiceImpl implements VotacionService {

    @Autowired
    private VotacionRepository votacionRepository;
    @Autowired
    private VotacionConverter votacionConverter;
    @Autowired
    private CiudadanoRepository ciudadanoRepository;
    @Autowired
    private CandidatoRepository candidatoRepository;

    @Override
    public Object add(VotacionDto votacionDto) {

        var habilitado= votacionRepository.findVotacionByCiudadano_cedula(votacionDto.getCiudadano_cedula());
        if (habilitado==null){
            var ciudadano= ciudadanoRepository.getReferenceById(votacionDto.getCiudadano_cedula());
            var candidato= candidatoRepository.getReferenceById(votacionDto.getCandidatoId());
            var votacion = votacionConverter.dtoToModel(votacionDto);
            votacion.setCiudadano_cedula(ciudadano);
            votacion.setCandidatoId(candidato);
            return votacionConverter.modelToDto(votacionRepository.save(votacion));
        }else {
            return new ResponseEntity<> ("Ya se encuentra registrado un voto con este usuario", HttpStatus.UNAUTHORIZED);
        }
    }


    @Override
    public VotacionDto findById(int id) {
        var cliente = votacionRepository.getReferenceById(id);
        return votacionConverter.modelToDto(cliente);
    }
}
