package com.Carjul.EstudiantesRestApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Grado;

public interface GradoDao extends CrudRepository<Grado, Integer>{
    
}
