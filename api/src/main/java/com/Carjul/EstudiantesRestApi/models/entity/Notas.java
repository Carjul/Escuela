package com.Carjul.EstudiantesRestApi.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="nota")
public class Notas implements Serializable{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name="valor")
    private Double valor;
    @Column(name="fecha_registro")
    private Date fecha_registro;
    @Column(name="estudiante_id")
    private int estudiante_id;
    @Column(name="actividad_id")
    private int actividad_id;

}
