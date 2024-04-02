package com.Carjul.EstudiantesRestApi.models.dao;

import com.Carjul.EstudiantesRestApi.models.entity.Escuela;
import org.springframework.data.repository.CrudRepository;

public interface EcuelaDao extends CrudRepository<Escuela, Integer> {
}
