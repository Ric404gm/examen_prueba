package com.ricardocamacho.examen.dto;

import lombok.Data;

@Data
public class ResponseEvaluationDto {
    
    private String estudiante;
    private Double evaluacion; 


    public ResponseEvaluationDto  nombre (String nombre){
        this.estudiante = nombre;
        return this;
    }

    
    public ResponseEvaluationDto  calificacion(Double  calificacion){
        this.evaluacion = calificacion;
        return this;
    }
}
