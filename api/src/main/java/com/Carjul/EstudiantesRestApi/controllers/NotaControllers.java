package com.Carjul.EstudiantesRestApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.Carjul.EstudiantesRestApi.models.entity.Notas;
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

import com.Carjul.EstudiantesRestApi.services.INota;

@RestController
@RequestMapping("/api/v1")
public class NotaControllers {
@Autowired
private INota notaService;

@GetMapping("nota")
public ResponseEntity<?> find() {
try {
List<Notas> notas = notaService.find();
return new ResponseEntity<>(notas, HttpStatus.OK);
} catch (Exception e) {
String errorMsg = "Error al buscar notas: " + e.getMessage();
return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
}        
}
 @PostMapping("nota")
    public ResponseEntity<?> create(@RequestBody Notas x) {
        try {
            Notas created = notaService.save(x);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMsg = "Error al crear la nota:"+ e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@PutMapping("nota")
    public ResponseEntity<?> update(@RequestBody Notas x) {
        try {
            notaService.save(x);
            return new ResponseEntity<>(new Response("nota actualizada"), HttpStatus.OK);
        } catch (Exception e) {
            String errorMsg = "Error al actualizar grupo:" +e.getMessage();
            return new ResponseEntity<>(new Response(errorMsg), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@GetMapping("nota/{id}")
public ResponseEntity<?> findById(@PathVariable Integer id) {
Notas nota = notaService.findById(id);
if (nota != null) {
return new ResponseEntity<>(nota, HttpStatus.OK);
} else {
String msg = "No se encontró ninguna nota con el ID:" + id;
return new ResponseEntity<>(new Response(msg), HttpStatus.NOT_FOUND);
}


}
@DeleteMapping("nota/{id}")
public ResponseEntity<Response> delete(@PathVariable Integer id){
Notas x = notaService.findById(id);
if (x != null) {
notaService.delete(x);
return new ResponseEntity<>(new Response("Nota eliminada"), HttpStatus.OK);
} else {
return new ResponseEntity<>(new Response("No se encontró ninguna nota con el ID:" + id), HttpStatus.NOT_FOUND);
}

}

}
