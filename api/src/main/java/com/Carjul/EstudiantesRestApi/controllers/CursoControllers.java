package com.Carjul.EstudiantesRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.Carjul.EstudiantesRestApi.models.entity.Curso;
import com.Carjul.EstudiantesRestApi.services.ICurso;

@Service
@RequestMapping("/api/v1")
public class CursoControllers {
    @Autowired
    private ICurso cursoService;
    @GetMapping("curso")
    public ResponseEntity<?> find() {
        try {
            System.out.println("jjj");
            List<Curso> cursos = cursoService.find();
            return new ResponseEntity<>(cursos, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar cursos: " + e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("curso")
    public ResponseEntity<?> create(@RequestBody Curso curso) {
        try {
            Curso createdcurso = cursoService.save(curso);
            return new ResponseEntity<>(createdcurso, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear curso:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("curso")
    public ResponseEntity<?> update(@RequestBody Curso curso) {
        try {
            cursoService.save(curso);
            return new ResponseEntity<>(new Response("curso actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar curso:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("curso/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Curso curso = cursoService.findById(id);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            String msg = "No se encontró ningún curso con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("curso/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Curso x = cursoService.findById(id);
        if (x != null) {
            cursoService.delete(x);
            Response response = new Response("curso eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
