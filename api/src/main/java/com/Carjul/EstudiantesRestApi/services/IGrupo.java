package com.Carjul.EstudiantesRestApi.services;

import java.util.List;

import com.Carjul.EstudiantesRestApi.models.entity.Grupo;

public interface IGrupo {
      List<Grupo> find();
    Grupo save(Grupo grupo);
    Grupo findById(Integer id);

    void delete(Grupo grupo);
}
