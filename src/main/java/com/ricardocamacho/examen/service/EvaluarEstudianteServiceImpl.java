package com.ricardocamacho.examen.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;
import com.ricardocamacho.examen.dto.EvaluarEstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.dto.ResponseEvaluationDto;
import com.ricardocamacho.examen.dto.RespuestaEstudianteDto;
import com.ricardocamacho.examen.persistence.entity.Estudiantes;
import com.ricardocamacho.examen.persistence.entity.Examen;
import com.ricardocamacho.examen.persistence.entity.ExamenPregunta;
import com.ricardocamacho.examen.persistence.entity.Respuesta;
import com.ricardocamacho.examen.persistence.repository.EstudianteRespository;
import com.ricardocamacho.examen.persistence.repository.ExamenRepository;
import com.ricardocamacho.examen.persistence.repository.PreguntasRepository;
import com.ricardocamacho.examen.persistence.repository.RespuestaRespository;

@Service
public class EvaluarEstudianteServiceImpl implements EvaluarEstudianteService{
    
    
    private static final  Logger LOGGER = LoggerFactory.getLogger(EstudianteServiceImpl.class);  

    @Autowired
    private EstudianteRespository estudianteRespository;
    
    @Autowired
    private ExamenRepository examenRepository; 

    @Autowired 
    private PreguntasRepository preguntasRepository;

    @Autowired
    private RespuestaRespository respuestaRespository;

    public EvaluarEstudianteServiceImpl (EstudianteRespository estudianteRespository ){
        this.estudianteRespository = estudianteRespository;
    }
    

    @Override
    public GenericResponseDto processEvaluation(EvaluarEstudianteDto estudianteDto) {
         try
        {  
            
            Optional<Examen> examenEnt =  examenRepository.findById(estudianteDto.getIdExamen());


            if(examenEnt.isPresent())
            {
                
                Double aculmulator = new Double(0);
                    
                for(  RespuestaEstudianteDto itemRespuestasDto : estudianteDto.getRespuestasEstudianteDtos()){
                    Optional<ExamenPregunta> examenPregunta =  preguntasRepository.findById(itemRespuestasDto.getIdPregunta());

                    Respuesta idCorrectoResponse  = examenPregunta.get().getRespuestas()
                        .stream().filter(item -> item.getEsRespuestaCorrecta()  ==true).
                        findFirst().
                        orElse(null);

                    boolean isMatchSelectedResponse =  idCorrectoResponse.getId() == itemRespuestasDto.getIdRespuestaSeleccionada();

                    aculmulator = aculmulator  + 100 ;
                        
                    LOGGER.info("  *  Pregunta selecccionada {}  , *   Respuestas posibles   {}   , Respuesta Correcta ,   {}  , Match Seleted {}  * ", 
                    itemRespuestasDto.getIdRespuestaSeleccionada(),  examenPregunta.toString() , idCorrectoResponse.toString() , isMatchSelectedResponse );  

                }
                
                return  new GenericResponseDto<ResponseEvaluationDto>().build( new ResponseEvaluationDto().
                    nombre( " ").calificacion(aculmulator / examenEnt.get().getPreguntas().size() ));
            }
            else
            {
                
            return   new GenericResponseDto<ResponseEvaluationDto>().build(new ResponseEvaluationDto().
                nombre(null).
                    calificacion( null))  ;
            }

        }catch (Exception e ){
            LOGGER.error( " * Ha ocurrido un error *  " , e);
            return   new GenericResponseDto<ResponseEvaluationDto>().build(new ResponseEvaluationDto().
                nombre(null).
                    calificacion( null))  ;
        }
    }
}
