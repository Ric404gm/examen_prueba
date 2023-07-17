package com.ricardocamacho.examen.dto;

import java.util.List;

import lombok.Data;

@Data
public class EvaluarEstudianteDto {
    
    private  Long idEstudiante;
    private  Long idExamen;
    private List<RespuestaEstudianteDto> respuestasEstudianteDtos;


}
