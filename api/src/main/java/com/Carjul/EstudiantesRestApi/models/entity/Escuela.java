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
@Table(name="escuela")
public class Escuela implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="descripcion")
    private String descripcion;
    @Column(name="imagen")
    private String imagen;
 


}
