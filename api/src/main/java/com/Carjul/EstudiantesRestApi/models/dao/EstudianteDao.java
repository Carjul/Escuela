package com.Carjul.EstudiantesRestApi.models.dao;

import com.Carjul.EstudiantesRestApi.models.entity.Estudiantes;
import org.springframework.data.repository.CrudRepository;

public interface EstudianteDao extends CrudRepository<Estudiantes, Integer> {
}
