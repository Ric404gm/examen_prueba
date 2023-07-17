package com.ricardocamacho.examen.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class EstudianteDto {
    
    
    
    @NotNull
    private String nombre;
    @NotNull
    private Integer edad;
    
    @NotNull
    private String ciudad;
    
    @NotNull
    private String zonaHoraria;
}
