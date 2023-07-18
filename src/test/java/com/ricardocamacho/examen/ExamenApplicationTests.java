package com.ricardocamacho.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.FilterType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.ExamenDto;
import com.ricardocamacho.examen.dto.GenericResponseDto;
import com.ricardocamacho.examen.dto.PreguntaDto;
import com.ricardocamacho.examen.dto.RespuestasDto;
import com.ricardocamacho.examen.persistence.entity.Estudiantes;
import com.ricardocamacho.examen.persistence.repository.EstudianteRespository;
import com.ricardocamacho.examen.persistence.repository.ExamenRepository;
import com.ricardocamacho.examen.service.EstudianteService;
import com.ricardocamacho.examen.service.EstudianteServiceImpl;
import com.ricardocamacho.examen.service.ExamenService;
import com.ricardocamacho.examen.service.ExamenServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExamenApplicationTests {


	@Autowired
	EstudianteService estudianteService;

	@Autowired
	EstudianteRespository estudianteRespository;


	@Autowired
	ExamenRepository examenRepository;

	@Autowired
	ExamenService  examenService;

	@Description("  * Test estudiante * ")
	@Test
	public void createEstudiante(){

		
		EstudianteDto estudianteDto = new EstudianteDto();
		estudianteDto.setNombre(" Ricardo Camacho");
		estudianteDto.setEdad(28);
		estudianteDto.setCiudad(" CDMX ");
		estudianteDto.setZonaHoraria("MX");
		GenericResponseDto<String> genericResponseDto = estudianteService.crearEstudiante(estudianteDto);

		Assert.isTrue(estudianteRespository.findById(Long.valueOf(genericResponseDto.getResponse())).
			isPresent()," OK Existe Alumno");
	}

	@Description(" *  Crear examen Test * ")
	@Test
	public void createExamenTest(){

		ExamenDto examenDto = new ExamenDto();

		examenDto.setDescripcion("  Examen" );
		PreguntaDto dto = new PreguntaDto();
		dto.setNombrePregunta("Primera Pregunta");

		RespuestasDto  respuestasDto1 = new RespuestasDto();
		respuestasDto1.setDescripcion(" Respuesta " );
		respuestasDto1.setIsCorrectResponse(true);

		RespuestasDto  respuestasDto2 = new RespuestasDto();
		respuestasDto2.setDescripcion(" Respuesta " );
		respuestasDto2.setIsCorrectResponse(false);

		RespuestasDto  respuestasDto3 = new RespuestasDto();
		respuestasDto3.setDescripcion(" Respuesta " );
		respuestasDto3.setIsCorrectResponse(false);

		RespuestasDto  respuestasDto4 = new RespuestasDto();
		respuestasDto4.setDescripcion(" Respuesta " );
		respuestasDto4.setIsCorrectResponse(false);


		dto.setRespuestas( Arrays.asList(respuestasDto1,respuestasDto2,respuestasDto3,respuestasDto4 ));
		examenDto.setPreguntas(Arrays.asList(dto));

		GenericResponseDto<String>  responseDtoExam = examenService.createExam(examenDto);
		
		
		Assert.notEmpty(  examenRepository.findById(Long.parseLong(responseDtoExam.getResponse())).get()
			.getPreguntas(),  " *  OK Passed * ");



	}


}
