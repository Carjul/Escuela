package com.Carjul.EstudiantesRestApi.services;

import java.util.List;

import com.Carjul.EstudiantesRestApi.models.entity.Grado;

public interface IGrado {
    List<Grado> find();
    Grado save(Grado grado);
    Grado findById(Integer id);

    void delete(Grado grado);
}
