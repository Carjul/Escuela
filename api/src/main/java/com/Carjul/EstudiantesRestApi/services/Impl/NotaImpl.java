package com.Carjul.EstudiantesRestApi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carjul.EstudiantesRestApi.models.dao.NotaDao;
import com.Carjul.EstudiantesRestApi.models.entity.Notas;
import com.Carjul.EstudiantesRestApi.services.INota;

import jakarta.transaction.Transactional;

@Service
public class NotaImpl implements INota {
@Autowired
    private NotaDao notaDao;
     @Transactional
    @Override
    public List<Notas> find() {
        return (List<Notas>) notaDao.findAll();
    }

    @Override
    @Transactional
    public Notas save(Notas nota) {
        return notaDao.save(nota);
    }
    @Transactional
    @Override
    public Notas findById(Integer id) {
        return notaDao.findById(id).orElse(null);
    }
    @Transactional
    @Override
    public void delete(Notas nota) {
        notaDao.delete(nota);
    }
}
