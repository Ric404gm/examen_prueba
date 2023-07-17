package com.ricardocamacho.examen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ricardocamacho.examen.dto.EvaluarEstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.service.EvaluarEstudianteService;

@RestController
@RequestMapping("/gestion-examen")
public class GestionExamentesController {

    
    @Autowired
    private EvaluarEstudianteService estudianteService;
    
    @PostMapping("/evaluate" )
    GenericResponseDto  evaluarEstudiante(@RequestBody  EvaluarEstudianteDto evaluarEstudianteDto )
    {
        return   estudianteService.processEvaluation(evaluarEstudianteDto);
    } 


}
