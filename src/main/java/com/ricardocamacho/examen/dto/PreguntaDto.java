package com.ricardocamacho.examen.dto;

import java.util.List;

import lombok.Data;

@Data
public class PreguntaDto 
{
    private String nombrePregunta;
    private List<RespuestasDto> respuestas;
}
