package com.Carjul.EstudiantesRestApi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Carjul.EstudiantesRestApi.models.dao.GradoDao;
import com.Carjul.EstudiantesRestApi.models.entity.Grado;
import com.Carjul.EstudiantesRestApi.services.IGrado;

@Service
public class GradoImpl implements IGrado{
    @Autowired
    private GradoDao gradoDao;
     @Transactional(readOnly = true)
    @Override
    public List<Grado> find() {
        List<Grado> gradoList = (List<Grado>) gradoDao.findAll();
        return gradoList;
    }

    @Transactional
    @Override
    public Grado save(Grado grado) {
        return gradoDao.save(grado);
    }
    @Transactional(readOnly = true)
    @Override
    public Grado findById(Integer id) {
        return gradoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Grado grado) {
        gradoDao.delete(grado);
    }
}
