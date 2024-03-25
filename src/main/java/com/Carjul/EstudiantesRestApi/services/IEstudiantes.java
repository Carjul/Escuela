package com.Carjul.EstudiantesRestApi.services;

import com.Carjul.EstudiantesRestApi.models.entity.Estudiantes;

import java.util.List;

public interface IEstudiantes {

     List<Estudiantes> find();
    Estudiantes save(Estudiantes estudiantes);
    Estudiantes findById(Integer id);

    void delete(Estudiantes estudiantes);


}
