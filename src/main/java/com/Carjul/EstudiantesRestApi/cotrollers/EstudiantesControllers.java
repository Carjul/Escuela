package com.Carjul.EstudiantesRestApi.cotrollers;
import com.Carjul.EstudiantesRestApi.models.entity.Estudiantes;
import com.Carjul.EstudiantesRestApi.services.IEstudiantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EstudiantesControllers {
    @Autowired
    private IEstudiantes estudianteService;

    @GetMapping("/")
    public String get(){
        return "hello world springboot";
    }
    @GetMapping("estudiante")
    public List<Estudiantes> find(){
        return estudianteService.find();
    }
    @GetMapping("estudiante/{id}")
    public Estudiantes findById(@PathVariable Integer id){
        return estudianteService.findById(id);
    }

    @PostMapping("estudiante")
    public Estudiantes create(@RequestBody Estudiantes estudiantes){
        return estudianteService.save(estudiantes);
    }
    @PutMapping("estudiante")
    public Estudiantes update(@RequestBody Estudiantes estudiantes){
        return estudianteService.save(estudiantes);
    }
    @DeleteMapping("estudiante/{id}")
    public void delete(@PathVariable Integer id){
        Estudiantes x =estudianteService.findById(id);
        estudianteService.delete(x);
    }
}
