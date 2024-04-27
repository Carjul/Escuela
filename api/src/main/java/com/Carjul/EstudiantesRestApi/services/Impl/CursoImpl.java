package com.Carjul.EstudiantesRestApi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Carjul.EstudiantesRestApi.models.dao.CursoDao;
import com.Carjul.EstudiantesRestApi.models.entity.Curso;
import com.Carjul.EstudiantesRestApi.services.ICurso;
@Service
public class CursoImpl implements ICurso {

    @Autowired
    private CursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> find() {
        return (List<Curso>) cursoDao.findAll();
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoDao.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso findById(Integer id) {
        return cursoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Curso curso) {
        cursoDao.delete(curso);
    }
    
}
