package com.ricardocamacho.examen.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardocamacho.examen.dto.ExamenDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.dto.PreguntaDto;
import com.ricardocamacho.examen.dto.RespuestasDto;
import com.ricardocamacho.examen.persistence.entity.Estudiantes;
import com.ricardocamacho.examen.persistence.entity.Examen;
import com.ricardocamacho.examen.persistence.entity.ExamenPregunta;
import com.ricardocamacho.examen.persistence.entity.Respuesta;
import com.ricardocamacho.examen.persistence.repository.ExamenRepository;
import com.ricardocamacho.examen.persistence.repository.PreguntasRepository;
import com.ricardocamacho.examen.persistence.repository.RespuestaRespository;

@Service
public class ExamenServiceImpl implements ExamenService  {
    

    private static final  Logger LOGGER = LoggerFactory.getLogger(EstudianteServiceImpl.class);  

    @Autowired
    private  ExamenRepository examenRepository;

    @Autowired
    private PreguntasRepository preguntasRepository;

    @Autowired
    private RespuestaRespository respuestaRespository;




    @Override
    public GenericResponseDto createExam(ExamenDto examenDto) {
        try
        {  

            List<ExamenPregunta> examenPreguntas = new ArrayList<>(); 

            examenDto.getPreguntas().stream().forEach( itemPreguntaDto  ->  { 

                ExamenPregunta examenPreguntaEntity = new ExamenPregunta();
                examenPreguntaEntity.setNombrePregunta(itemPreguntaDto.getNombrePregunta());
                
                List<Respuesta> respuestasEntity = new ArrayList<>();  

                itemPreguntaDto.getRespuestas().stream().forEach(respuestasItemDto -> {
                    Respuesta respuestaEntity = new Respuesta();   
                    respuestaEntity.setDescripcion(respuestasItemDto.getDescripcion()); 
                    respuestaEntity.setEsRespuestaCorrecta(respuestasItemDto.getIsCorrectResponse());   
                    respuestaRespository.save(respuestaEntity);

                    respuestasEntity.add(respuestaEntity);
                });

                examenPreguntaEntity.setRespuestas(respuestasEntity);
                preguntasRepository.save(examenPreguntaEntity);
                examenPreguntas.add(examenPreguntaEntity);
                
            });

            
            Examen examenEntity  =  new Examen();
            examenEntity.setPreguntas(examenPreguntas);
            examenEntity.setDescripcion(examenDto.getDescripcion());
           
            Examen examenEntityResult =  examenRepository.save(examenEntity) ;
            return new GenericResponseDto<String>()
                        .build(String.valueOf( examenEntityResult.getId()));
        }catch (Exception e ){
            LOGGER.error( " * Ha ocurrido un error *  " , e);
            return   new GenericResponseDto<String>().build("ERROR")  ;
        }
    }
}
