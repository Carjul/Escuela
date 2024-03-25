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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Name")
    private String Name;
    @Column(name="Identificacion")
    private String Identificacion;
    @Column(name="Tipo_Id")
    private String Tipo_Id;
    @Column(name="Edad")
    private int Edad;
    @Column(name="Sexo")
    private String Sexo;
}
