package com.ricardocamacho.examen.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.ExamenDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.service.ExamenService;

@RestController
@RequestMapping("/examen")
public class ExamenController {
    

    @Autowired
    private ExamenService examenService;


    
    @PostMapping("/create" )
    GenericResponseDto create(@RequestBody  @Valid ExamenDto examenDto ){
        return examenService.createExam(examenDto);
    }
}
