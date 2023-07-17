package com.ricardocamacho.examen.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ricardocamacho.examen.persistence.entity.Estudiantes;



@Repository
public interface  EstudianteRespository extends CrudRepository<Estudiantes , Long> {
    
}
