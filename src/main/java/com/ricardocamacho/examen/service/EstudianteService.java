package com.ricardocamacho.examen.service;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;

public interface EstudianteService {
    

    GenericResponseDto  crearEstudiante ( EstudianteDto estudianteDto  );

}
