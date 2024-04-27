package com.Carjul.EstudiantesRestApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Profesor;

public interface ProfesorDao extends CrudRepository<Profesor, Integer>{
    
}
