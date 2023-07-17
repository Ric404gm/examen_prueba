package com.ricardocamacho.examen.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.ricardocamacho.examen.persistence.entity.ExamenPregunta;
import com.ricardocamacho.examen.persistence.entity.Respuesta;

import lombok.Data;

@Data
public class ExamenDto {
    

    private String  descripcion;
    
    private List<PreguntaDto> preguntas;
    
    
}

