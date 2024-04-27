package com.Carjul.EstudiantesRestApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Notas;
public interface NotaDao extends CrudRepository<Notas, Integer> {
    
}
