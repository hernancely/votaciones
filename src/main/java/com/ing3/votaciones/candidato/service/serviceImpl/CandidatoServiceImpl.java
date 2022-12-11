package com.ing3.votaciones.candidato.service.serviceImpl;

import com.ing3.votaciones.candidato.component.CandidatoConverter;
import com.ing3.votaciones.candidato.component.CandidatoMapper;
import com.ing3.votaciones.candidato.dto.CandidatoDto;
import com.ing3.votaciones.candidato.repository.CandidatoRepository;
import com.ing3.votaciones.candidato.service.CandidatoService;
import com.ing3.votaciones.ciudadano.component.CiudadanoConverter;
import com.ing3.votaciones.ciudadano.model.Ciudadano;
import com.ing3.votaciones.ciudadano.repository.CiudadanoRepository;
import com.ing3.votaciones.errorhandler.ErrorHandler;
import com.ing3.votaciones.errorhandler.ErrorMessage;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:11 p. m.
 * @Version 1.0
 */
@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;
    @Autowired
    private CandidatoConverter candidatoConverter;

    @Autowired
    private CiudadanoRepository ciudadanoRepository;

    private  CandidatoMapper candidatoMapper;
    @Override
    public Object add(CandidatoDto candidatoDto) {
        try {
            var ciudadano=ciudadanoRepository.getReferenceById(candidatoDto.getCiudadano_cedula());
            if (ciudadano!=null){
                var candidato = candidatoConverter.dtoToModel(candidatoDto);
                candidato.setCiudadano_cedula(ciudadano);
                candidato.setNombre(ciudadano.getNombres());
                candidato=candidatoRepository.save(candidato);
                if (candidato.getId()!=null){
                    candidatoDto=candidatoConverter.modelToDto(candidato);
                    candidatoDto.setCiudadano_cedula(ciudadano.getCedula());
                }
            }
            return candidatoDto;
        }catch (Exception e){
            return new ResponseEntity<> ("Algo salio mal ",HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<CandidatoDto> getAll() {
        var candidatos = candidatoRepository.findAll();
        return candidatoConverter.listModelToDto(candidatos);
    }

    @Override
    public CandidatoDto findById(int id) {
        var cliente = candidatoRepository.getReferenceById(id);
        return candidatoConverter.modelToDto(cliente);
    }

    @Override
    public Object update(Integer cedula, CandidatoDto candidatoDto) {
//        try {
            var ciudadano=ciudadanoRepository.getReferenceById(cedula);
            if (ciudadano!=null){
                var candidato = candidatoConverter.dtoToModel(candidatoDto);
                candidato.setCiudadano_cedula(ciudadano);
                candidatoMapper.updateCustomerFromDto(candidatoDto,candidato);
                candidato=candidatoRepository.save(candidato);
                if (candidato.getId()!=null){
                    candidatoDto=candidatoConverter.modelToDto(candidato);
                    candidatoDto.setCiudadano_cedula(ciudadano.getCedula());
                }
            }
            return candidatoDto;
//        }catch (Exception e){
//            return new ResponseEntity<> ("Algo salio mal ",HttpStatus.BAD_REQUEST);
//        }


    }

    @Override
    public void delete(int id) {
        candidatoRepository.deleteById(id);
    }
}
