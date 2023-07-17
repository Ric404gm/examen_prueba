package com.ricardocamacho.examen;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.ricardocamacho.examen.dto.EstudianteDto;
import com.ricardocamacho.examen.dto.ExamenDto;
import com.ricardocamacho.examen.dto.PreguntaDto;
import com.ricardocamacho.examen.dto.RespuestasDto;
import com.ricardocamacho.examen.persistence.repository.EstudianteRespository;
import com.ricardocamacho.examen.persistence.repository.ExamenRepository;
import com.ricardocamacho.examen.service.EstudianteService;
import com.ricardocamacho.examen.service.ExamenService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ExamenApplicationTests {


	@MockBean
	private  ExamenRepository examenRepository;
	
	@MockBean
	private  EstudianteRespository estudianteRespository;
	
	
	@Autowired
	private  EstudianteService estudianteService;


	@Autowired
	private   ExamenService examenService;



	@Test
	void contextLoads() {

		
		EstudianteDto estudianteDto = new EstudianteDto();
		estudianteDto.setNombre(" Ricardo Camacho");
		estudianteDto.setEdad(28);
		estudianteDto.setCiudad(" CDMX ");
		estudianteDto.setZonaHoraria("MX");


		estudianteService.crearEstudiante(estudianteDto);



		ExamenDto examenDto = new ExamenDto();

		examenDto.setDescripcion("  Examnee" );
		PreguntaDto dto = new PreguntaDto();
		dto.setNombrePregunta("Primera Pregunta");

		RespuestasDto  respuestasDto = new RespuestasDto();
		respuestasDto.setDescripcion(" Respuesta " );

		dto.setRespuestas( Arrays.asList(respuestasDto));
		examenDto.setPreguntas(Arrays.asList(dto));



		examenService.createExam(examenDto);


		Assert.isTrue(estudianteRespository.findById(1L).get().
			getNombre().equals(estudianteDto.getNombre()), " OK "); ;



	}

}
