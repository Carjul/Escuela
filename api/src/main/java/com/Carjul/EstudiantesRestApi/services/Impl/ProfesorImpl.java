package com.Carjul.EstudiantesRestApi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Carjul.EstudiantesRestApi.models.dao.ProfesorDao;
import com.Carjul.EstudiantesRestApi.models.entity.Profesor;
import com.Carjul.EstudiantesRestApi.services.IProfesor;

@Service
public class ProfesorImpl implements IProfesor{
    @Autowired
    private ProfesorDao profesorDao;

    @Override
    @Transactional
    public List<Profesor> find() {
        return (List<Profesor>) profesorDao.findAll();
    }

    @Override
    @Transactional
    public Profesor save(Profesor profesor) {
        return profesorDao.save(profesor);
    }

    @Override
    @Transactional
    public Profesor findById(Integer id) {
        return profesorDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Profesor profesor) {
        profesorDao.delete(profesor);
    }
    
}
