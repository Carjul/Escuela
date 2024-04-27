package com.Carjul.EstudiantesRestApi.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Carjul.EstudiantesRestApi.models.dao.GrupoDao;
import com.Carjul.EstudiantesRestApi.models.entity.Grupo;
import com.Carjul.EstudiantesRestApi.services.IGrupo;

@Service
public class GrupoImpl implements IGrupo{
    @Autowired
    private GrupoDao grupoDao;
     @Transactional(readOnly = true)
    @Override
    public List<Grupo> find() {
        List<Grupo> grupoList = (List<Grupo>) grupoDao.findAll();
        return grupoList;
    }

    @Transactional
    @Override
    public Grupo save(Grupo grupo) {
        return grupoDao.save(grupo);
    }
    @Transactional(readOnly = true)
    @Override
    public Grupo findById(Integer id) {
        return grupoDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Grupo grupo) {
        grupoDao.delete(grupo);
    }
}
