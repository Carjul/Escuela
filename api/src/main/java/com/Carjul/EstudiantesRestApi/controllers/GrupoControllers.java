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

import com.Carjul.EstudiantesRestApi.models.entity.Grupo;
import com.Carjul.EstudiantesRestApi.services.IGrupo;

@RestController
@RequestMapping("/api/v1")
public class GrupoControllers {
       @Autowired
    private IGrupo grupoService;

    @GetMapping("grupo")
    public ResponseEntity<?> find() {
        try {
            List<Grupo> grupos = grupoService.find();
            return new ResponseEntity<>(grupos, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar grupos: " + e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("grupo")
    public ResponseEntity<?> create(@RequestBody Grupo grupo) {
        try {
            Grupo createdgrupo = grupoService.save(grupo);
            return new ResponseEntity<>(createdgrupo, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear grupo:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("grupo")
    public ResponseEntity<?> update(@RequestBody Grupo grupo) {
        try {
            grupoService.save(grupo);
            return new ResponseEntity<>(new Response("grupo actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar grupo:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("grupo/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Grupo grupo = grupoService.findById(id);
        if (grupo != null) {
            return new ResponseEntity<>(grupo, HttpStatus.OK);
        } else {
            String msg = "No se encontró ningún grupo con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("grupo/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Grupo x = grupoService.findById(id);
        if (x != null) {
            grupoService.delete(x);
            Response response = new Response("grupo eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    
}
