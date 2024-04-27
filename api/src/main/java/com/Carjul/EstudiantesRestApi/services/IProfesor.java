package com.Carjul.EstudiantesRestApi.services;

import java.util.List;

import com.Carjul.EstudiantesRestApi.models.entity.Profesor;

public interface IProfesor {
    List<Profesor> find();
    Profesor save(Profesor profesor);
    Profesor findById(Integer id);
    void delete(Profesor profesor);
}
