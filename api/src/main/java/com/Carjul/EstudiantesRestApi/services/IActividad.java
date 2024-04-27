package com.Carjul.EstudiantesRestApi.services;

import com.Carjul.EstudiantesRestApi.models.entity.Actividad;

import java.util.List;

public interface IActividad {
    List<Actividad> find();
    Actividad save(Actividad actividad);
    Actividad findById(Integer id);

    void delete(Actividad actividad);
}
