package com.Carjul.EstudiantesRestApi.services.Impl;

import com.Carjul.EstudiantesRestApi.models.dao.ActividadDao;
import com.Carjul.EstudiantesRestApi.models.entity.Actividad;
import com.Carjul.EstudiantesRestApi.services.IActividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActividadImpl  implements IActividad{
    @Autowired
    private ActividadDao ActividadDao;
    @Transactional(readOnly = true)
    @Override
    public List<Actividad> find() {
        return (List<Actividad>) ActividadDao.findAll();
    }

    @Override
    @Transactional
    public Actividad save(Actividad Actividad) {
        return ActividadDao.save(Actividad);
    }
    @Transactional(readOnly = true)
    @Override
    public Actividad findById(Integer id) {
        return ActividadDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Actividad Actividad) {
        ActividadDao.delete(Actividad);
    }
}
