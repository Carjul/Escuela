package com.Carjul.EstudiantesRestApi.models.dao;

import com.Carjul.EstudiantesRestApi.models.entity.Escuela;
import org.springframework.data.repository.CrudRepository;

public interface EscuelaDao extends CrudRepository<Escuela, Integer> {
}
