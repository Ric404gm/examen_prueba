package com.ricardocamacho.examen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.service.EstudianteService;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {
        

    @Autowired
    private  EstudianteService estudianteService;

    @PostMapping("/create" )
    GenericResponseDto create(@RequestBody  @Valid EstudianteDto estudianteDto ){
        return estudianteService.crearEstudiante(estudianteDto);
    }


}
