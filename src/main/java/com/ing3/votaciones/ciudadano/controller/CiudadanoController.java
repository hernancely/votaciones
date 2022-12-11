package com.ing3.votaciones.ciudadano.controller;

import com.ing3.votaciones.ciudadano.dto.CiudadanoDto;
import com.ing3.votaciones.ciudadano.service.CiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Hernan Cely
 * @Date: 3/12/2022 7:39 p. m.
 * @Version 1.0
 */

@RestController
@RequestMapping("/api/v1/ciudadano")
public class CiudadanoController {

    @Autowired
    private CiudadanoService ciudadanoService;

    @PostMapping
    public CiudadanoDto add(@Validated @RequestBody CiudadanoDto ciudadanoDto) {
        return ciudadanoService.add(ciudadanoDto);
    }

    @GetMapping
    public List<CiudadanoDto> getAll() {
        return ciudadanoService.getAll();
    }

    @GetMapping("/detail/{id}")
    public CiudadanoDto findById(@PathVariable int id) {
        return ciudadanoService.findById(id);
    }

    @PutMapping("/{cedula}")
    public CiudadanoDto update(@PathVariable Integer cedula, @RequestBody CiudadanoDto ciudadanoDto) {
        return ciudadanoService.update(cedula, ciudadanoDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        ciudadanoService.delete(id);
    }
}
