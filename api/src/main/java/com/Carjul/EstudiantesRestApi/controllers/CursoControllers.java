package com.Carjul.EstudiantesRestApi.controllers;
import com.Carjul.EstudiantesRestApi.models.entity.Curso;
import com.Carjul.EstudiantesRestApi.services.ICurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CursoControllers {
    @Autowired
    private ICurso Cursoervice;

    @GetMapping("curso")
    public ResponseEntity<?> find() {
        try {
            List<Curso> curso = Cursoervice.find();
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar Curso: " + e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("curso")
    public ResponseEntity<?> create(@RequestBody Curso Curso) {
        try {
            Curso createdcurso = Cursoervice.save(Curso);
            return new ResponseEntity<>(createdcurso, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear curso:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("curso")
    public ResponseEntity<?> update(@RequestBody Curso Curso) {
        try {
            Cursoervice.save(Curso);
            return new ResponseEntity<>(new Response("curso actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar curso:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("curso/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Curso curso = Cursoervice.findById(id);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            String msg = "No se encontró ningún curso con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("curso/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Curso x = Cursoervice.findById(id);
        if (x != null) {
            Cursoervice.delete(x);
            Response response = new Response("curso eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}

