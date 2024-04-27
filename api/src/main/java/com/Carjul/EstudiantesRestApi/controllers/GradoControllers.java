package com.Carjul.EstudiantesRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Carjul.EstudiantesRestApi.models.entity.Grado;
import com.Carjul.EstudiantesRestApi.services.IGrado;

@RestController
@RequestMapping("/api/v1")
public class GradoControllers {
       @Autowired
    private IGrado gradoService;

    @GetMapping("grado")
    public ResponseEntity<?> find() {
        try {
            List<Grado> grados = gradoService.find();
            return new ResponseEntity<>(grados, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar grados: " + e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("grado")
    public ResponseEntity<?> create(@RequestBody Grado grado) {
        try {
            Grado createdgrado = gradoService.save(grado);
            return new ResponseEntity<>(createdgrado, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear grado:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("grado")
    public ResponseEntity<?> update(@RequestBody Grado grado) {
        try {
            gradoService.save(grado);
            return new ResponseEntity<>(new Response("grado actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar grado:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("grado/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Grado grado = gradoService.findById(id);
        if (grado != null) {
            return new ResponseEntity<>(grado, HttpStatus.OK);
        } else {
            String msg = "No se encontró ningún grado con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("grado/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Grado x = gradoService.findById(id);
        if (x != null) {
            gradoService.delete(x);
            Response response = new Response("grado eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    
}
