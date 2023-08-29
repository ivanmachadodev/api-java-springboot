/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ivanm
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "")

public class Recibo {
    @Id
    @GeneratedValue
    @Column ( name = "Nro_Recibo")
    private int nroRecibo;
    @Column ( name = "Mes")
    private int mes;
    @Column ( name = "Anio")
    private int anio;
    @Column ( name = "Antiguedad")
    private double antiguedad;
    @Column ( name = "Jubilacion")
    private double jubilacion;
    @Column ( name = "Obra_Social")
    private double obraSocial;
    @Column ( name = "Fondo_Complejidad")
    private double fondoComplejidad;
    
    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "legajo")
    @JsonBackReference
    private Empleado empleado;
    
}
