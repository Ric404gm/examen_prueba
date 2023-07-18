package com.ricardocamacho.examen.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.persistence.entity.Estudiantes;
import com.ricardocamacho.examen.persistence.repository.EstudianteRespository;

@Service
public class EstudianteServiceImpl implements EstudianteService {
 
    private static final  Logger LOGGER = LoggerFactory.getLogger(EstudianteServiceImpl.class);  



    private final  ModelMapper mapper = new ModelMapper();


    
    @Autowired
    private EstudianteRespository estudianteRespository;

    @Autowired
    public EstudianteServiceImpl (EstudianteRespository estudianteRespository ){
        this.estudianteRespository = estudianteRespository;
    }

    @Override
    public GenericResponseDto crearEstudiante(EstudianteDto estudianteDto) {
        try
        {  
           /*  return   new GenericResponseDto<String>().
                build(String.valueOf(estudianteRespository.
                    save( mapper.map(estudianteDto, Estudiantes.class)).getId()))  ;*/
            Estudiantes estudiantes = mapper.map(estudianteDto, Estudiantes.class);

            Estudiantes estudiantesResult =  estudianteRespository.save(estudiantes);

            return   new GenericResponseDto<String>().build(String.valueOf(estudiantesResult.getId()));

        }catch (Exception e ){
            LOGGER.error( " * Ha ocurrido un error *  " , e);
            return   new GenericResponseDto<String>().build("ERROR")  ;
        }
        
    }

}
