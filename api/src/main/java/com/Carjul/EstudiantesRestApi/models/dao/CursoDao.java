package com.Carjul.EstudiantesRestApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Curso;

public interface CursoDao extends CrudRepository<Curso, Integer> {
    
}
