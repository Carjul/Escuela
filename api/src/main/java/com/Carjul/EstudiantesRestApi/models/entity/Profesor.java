package com.Carjul.EstudiantesRestApi.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="profesor")
public class Profesor {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="apellido")
    private String apellido;
    @Column(name="telefono")
    private String telefono;
    @Column(name="email")
    private String email;
    @Column(name="especialidad")
    private String especialidad;
}
