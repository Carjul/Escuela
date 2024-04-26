package com.Carjul.EstudiantesRestApi.services;

import com.Carjul.EstudiantesRestApi.models.entity.Escuela;

import java.util.List;

public interface IEscuela {
    List<Escuela> find();
    Escuela save(Escuela escuela);
    Escuela findById(Integer id);

    void delete(Escuela escuela);
}
