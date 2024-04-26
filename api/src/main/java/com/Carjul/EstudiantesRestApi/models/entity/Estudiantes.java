package com.Carjul.EstudiantesRestApi.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="estudiantes")
public class Estudiantes implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="grado_anterior")
    private int grado_anterior;
    @Column(name="imagen")
    private String imagen;
    @Column(name="tipo_identificacion")
    private String tipo_identificacion;
    @Column(name="identificacion")
    private String identificacion;
    @Column(name="edad")
    private int edad;
    @Column(name="genero")
    private String genero;
    @Column(name="gradoid")
    private int gradoid;
}
