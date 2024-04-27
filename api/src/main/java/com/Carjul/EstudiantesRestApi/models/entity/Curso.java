package com.Carjul.EstudiantesRestApi.models.entity;

import java.io.Serializable;

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
@Table(name="curso")
public class Curso implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="profesor_id")
    private int profesor_id;

}
