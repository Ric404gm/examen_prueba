package com.ricardocamacho.examen.service;

import com.ricardocamacho.examen.dto.ExamenDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;

public interface ExamenService {
    
    GenericResponseDto createExam(ExamenDto examenDto);
}
