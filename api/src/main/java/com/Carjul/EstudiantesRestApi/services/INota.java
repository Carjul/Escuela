package com.Carjul.EstudiantesRestApi.services;


import java.util.List;

import com.Carjul.EstudiantesRestApi.models.entity.Notas;

public interface INota {
    List<Notas> find();
    Notas save(Notas nota);
    Notas findById(Integer id);
    void delete(Notas nota);
}
