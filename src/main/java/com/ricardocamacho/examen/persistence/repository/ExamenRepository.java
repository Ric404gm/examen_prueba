package com.ricardocamacho.examen.persistence.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ricardocamacho.examen.persistence.entity.Examen;

@Repository
public interface ExamenRepository extends CrudRepository<Examen , Long> {
    
}
