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

import com.Carjul.EstudiantesRestApi.models.entity.Profesor;
import com.Carjul.EstudiantesRestApi.services.IProfesor;

@RestController
@RequestMapping("/api/v1")
public class ProfesorControllers {
@Autowired
private IProfesor profesorService;

@GetMapping("profesor")
public ResponseEntity<?> find() {
try {
List<Profesor> profesores = profesorService.find();
return new ResponseEntity<>(profesores, HttpStatus.OK);
} catch (Exception e) {
String errorMsg = "Error al buscar profesores: " + e.getMessage();
return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
}        
}

@PostMapping("profesor")
public ResponseEntity<?> create(@RequestBody Profesor x) {
try {
Profesor created = profesorService.save(x);
return new ResponseEntity<>(created, HttpStatus.CREATED);
} catch (Exception e) {
String errorMsg = "Error al crear el profesor:"+ e.getMessage();
return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
}

}

@PutMapping("profesor")
public ResponseEntity<?> update(@RequestBody Profesor x) {
try {
profesorService.save(x);
return new ResponseEntity<>(new Response("profesor actualizado"), HttpStatus.OK);
} catch (Exception e) {
String errorMsg = "Error al actualizar profesor:" +e.getMessage();
return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@GetMapping("profesor/{id}")
public ResponseEntity<?> findById(@PathVariable Integer id) {
Profesor profesor = profesorService.findById(id);
if (profesor != null) {
return new ResponseEntity<>(profesor, HttpStatus.OK);
} else {
String msg = "No se encontró ningún profesor con el ID:" + id;
return new ResponseEntity<>(new Response(msg), HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@DeleteMapping ("profesor/{id}")
public ResponseEntity<Response> delete(@PathVariable Integer id){
Profesor x = profesorService.findById(id);
if (x != null) {
profesorService.delete(x);
return new ResponseEntity<>(new Response("Profesor eliminado"), HttpStatus.OK);
} else {    
return new ResponseEntity<>(new Response("No se encontró ningún profesor con el ID:" + id), HttpStatus.NOT_FOUND);
}

}

}
