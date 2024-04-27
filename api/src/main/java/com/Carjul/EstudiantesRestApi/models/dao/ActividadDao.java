package com.Carjul.EstudiantesRestApi.models.dao;
import org.springframework.data.repository.CrudRepository;

import com.Carjul.EstudiantesRestApi.models.entity.Actividad;

public interface ActividadDao extends CrudRepository<Actividad, Integer>{
    
}
