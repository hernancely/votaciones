package com.ing3.votaciones.votos.controller;

import com.ing3.votaciones.votos.dto.ConteoDto;
import com.ing3.votaciones.votos.service.VotosService;
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
@RequestMapping("api/v1/consulta")
public class VotosController {


    @Autowired
    private VotosService votosService;

    @GetMapping
    public List<ConteoDto> getAll() {
        return votosService.getAll();
    }

}
