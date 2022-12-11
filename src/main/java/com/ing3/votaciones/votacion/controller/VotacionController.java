package com.ing3.votaciones.votacion.controller;

import com.ing3.votaciones.votacion.dto.VotacionDto;
import com.ing3.votaciones.votacion.service.VotacionService;
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
@RequestMapping("api/v1/votar")
public class VotacionController {


    @Autowired
    private VotacionService votacionService;

    @PostMapping
    public Object add(@Validated @RequestBody VotacionDto votacionDto) {
        return votacionService.add(votacionDto);
    }

    @GetMapping("/detail/{id}")
    public VotacionDto findById(@PathVariable int id) {
        return votacionService.findById(id);
    }

}
