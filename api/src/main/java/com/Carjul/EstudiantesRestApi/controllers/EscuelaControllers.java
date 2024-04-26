package com.Carjul.EstudiantesRestApi.controllers;

import com.Carjul.EstudiantesRestApi.models.entity.Escuela;
import com.Carjul.EstudiantesRestApi.services.IEscuela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class EscuelaControllers {
    @Autowired
    private IEscuela escuelaService;

    @GetMapping("escuela")
    public ResponseEntity<?> find() {
        try {
            List<Escuela> x = escuelaService.find();
            return new ResponseEntity<>(x, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar escuelas:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("escuela")
    public ResponseEntity<?> create(@RequestBody Escuela escuela) {
        try {
            Escuela y = escuelaService.save(escuela);
            return new ResponseEntity<>(y, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear estudiante:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("escuela/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Escuela z = escuelaService.findById(id);
        if (z != null) {
            return new ResponseEntity<>(z, HttpStatus.OK);
        } else {
            String msg = "No se encontró ninguna escuela con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("escuela")
    public ResponseEntity<?> update(@RequestBody Escuela escuela) {
        try {
            escuelaService.save(escuela);
            return new ResponseEntity<>(new Response("Estudiante actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar estudiante:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("escuela/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Escuela c = escuelaService.findById(id);
        if (c != null) {
            escuelaService.delete(c);
            Response response = new Response("Escuela eliminada");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}
