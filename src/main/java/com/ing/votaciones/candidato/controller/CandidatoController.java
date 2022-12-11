package com.ing.votaciones.candidato.controller;

import com.ing.votaciones.candidato.dto.CandidatoDto;
import com.ing.votaciones.candidato.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 11:06 p. m.
 * @Version 1.0
 */
@RestController
@RequestMapping("api/v1/candidato")
public class CandidatoController {

    @Autowired
    private CandidatoService candidatoService;

    @PostMapping
    public Object add(@Validated @RequestBody CandidatoDto candidatoDto) {
        return candidatoService.add(candidatoDto);
    }

    @GetMapping
    public List<CandidatoDto> getAll() {
        return candidatoService.getAll();
    }

    @GetMapping("/detail/{id}")
    public CandidatoDto findById(@PathVariable int id) {
        return candidatoService.findById(id);
    }

    @PutMapping("/{id}")
    public Object update(@PathVariable int id, @RequestBody CandidatoDto candidatoDto) {
        return candidatoService.update(id, candidatoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        candidatoService.delete(id);
    }
}
