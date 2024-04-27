package com.Carjul.EstudiantesRestApi.controllers;
import com.Carjul.EstudiantesRestApi.models.entity.Actividad;
import com.Carjul.EstudiantesRestApi.services.IActividad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ActividadControllers {
    @Autowired
    private IActividad Actividadervice;

    @GetMapping("actividad")
    public ResponseEntity<?> find() {
        try {
            List<Actividad> actividad = Actividadervice.find();
            return new ResponseEntity<>(actividad, HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al buscar Actividad: " + e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("actividad")
    public ResponseEntity<?> create(@RequestBody Actividad Actividad) {
        try {
            Actividad createdEstudiante = Actividadervice.save(Actividad);
            return new ResponseEntity<>(createdEstudiante, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear estudiante:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("actividad")
    public ResponseEntity<?> update(@RequestBody Actividad Actividad) {
        try {
            Actividadervice.save(Actividad);
            return new ResponseEntity<>(new Response("Estudiante actualizado"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar estudiante:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("actividad/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Actividad estudiante = Actividadervice.findById(id);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            String msg = "No se encontró ningún estudiante con el ID:" + id;
            return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("actividad/{id}")
    public ResponseEntity<Response> delete(@PathVariable Integer id){
        Actividad x = Actividadervice.findById(id);
        if (x != null) {
            Actividadervice.delete(x);
            Response response = new Response("Estudiante eliminado");
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}

