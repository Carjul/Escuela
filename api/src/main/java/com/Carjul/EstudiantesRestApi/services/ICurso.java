package com.Carjul.EstudiantesRestApi.services;

import java.util.List;

import com.Carjul.EstudiantesRestApi.models.entity.Curso;

public interface ICurso {
      List<Curso> find();
    Curso save(Curso curso);
    Curso findById(Integer id);

    void delete(Curso curso);
}
