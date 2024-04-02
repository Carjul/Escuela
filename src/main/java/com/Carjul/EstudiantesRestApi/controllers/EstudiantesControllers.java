package com.Carjul.EstudiantesRestApi.controllers;
import com.Carjul.EstudiantesRestApi.models.entity.Estudiantes;
import com.Carjul.EstudiantesRestApi.services.IEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EstudiantesControllers {
    @Autowired
    private IEstudiantes estudianteService;

    @GetMapping("estudiante")
    public ResponseEntity<?> find() {
        try {
            List<Estudiantes> estudiantes = estudianteService.find();
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = STR."Error al buscar estudiantes: \{e.getMessage()}";
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("estudiante")
    public ResponseEntity<?> create(@RequestBody Estudiantes estudiantes) {
        try {
            Estudiantes createdEstudiante = estudianteService.save(estudiantes);
            return new ResponseEntity<>(createdEstudiante, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = STR."Error al crear estudiante: \{e.getMessage()}";
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("estudiante")
    public ResponseEntity<?> update(@RequestBody Estudiantes estudiantes) {
        try {
            estudianteService.save(estudiantes);
            return new ResponseEntity<>(new Response("Estudiante actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = STR."Error al actualizar estudiante: \{e.getMessage()}";
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("estudiante/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Estudiantes estudiante = estudianteService.findById(id);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            String msg = STR."No se encontró ningún estudiante con el ID: \{id}";
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("estudiante/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Estudiantes x = estudianteService.findById(id);
        if (x != null) {
            estudianteService.delete(x);
            Response response = new Response("Estudiante eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}

