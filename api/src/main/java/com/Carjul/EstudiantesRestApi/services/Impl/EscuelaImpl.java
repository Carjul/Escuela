package com.Carjul.EstudiantesRestApi.services.Impl;


import com.Carjul.EstudiantesRestApi.models.dao.EscuelaDao;
import com.Carjul.EstudiantesRestApi.models.entity.Escuela;
import com.Carjul.EstudiantesRestApi.services.IEscuela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EscuelaImpl implements IEscuela {
    @Autowired
    private EscuelaDao escuelaDao;
    @Transactional(readOnly = true)
    @Override
    public List<Escuela> find() {
        return (List<Escuela>) escuelaDao.findAll();
    }

    @Override
    @Transactional
    public Escuela save(Escuela escuela) {
        return escuelaDao.save(escuela);
    }
    @Transactional(readOnly = true)
    @Override
    public Escuela findById(Integer id) {
        return escuelaDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Escuela escuela) {
        escuelaDao.delete(escuela);
    }
}
