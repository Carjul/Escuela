package com.Carjul.EstudiantesRestApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Grupo;

public interface GrupoDao extends CrudRepository<Grupo, Integer>{
    
}
