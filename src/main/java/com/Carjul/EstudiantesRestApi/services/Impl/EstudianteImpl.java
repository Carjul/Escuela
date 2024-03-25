package com.Carjul.EstudiantesRestApi.services.Impl;

import com.Carjul.EstudiantesRestApi.models.dao.EstudianteDao;
import com.Carjul.EstudiantesRestApi.models.entity.Estudiantes;
import com.Carjul.EstudiantesRestApi.services.IEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstudianteImpl implements IEstudiantes {

@Autowired
private EstudianteDao estudianteDao;
    @Transactional(readOnly = true)
    @Override
    public List<Estudiantes> find() {
        List<Estudiantes> estudiantesList = (List<Estudiantes>) estudianteDao.findAll();
        return estudiantesList;
    }

    @Transactional
    @Override
    public Estudiantes save(Estudiantes estudiantes) {
        return estudianteDao.save(estudiantes);
    }
    @Transactional(readOnly = true)
    @Override
    public Estudiantes findById(Integer id) {
        return estudianteDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Estudiantes estudiantes) {
        estudianteDao.delete(estudiantes);
    }
}
