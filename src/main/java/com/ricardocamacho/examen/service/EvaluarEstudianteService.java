package com.ricardocamacho.examen.service;

import com.ricardocamacho.examen.dto.EvaluarEstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;

public interface EvaluarEstudianteService {
    
    GenericResponseDto  processEvaluation(EvaluarEstudianteDto estudianteDto);
}
