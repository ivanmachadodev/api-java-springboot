/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.DTOs;

import com.example.APIJava.Models.Empleado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * @author ivanm
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class DTORecibo {
    private int mes;
    private int anio;
    private double antiguedad;
    private double jubilacion;
    private double obraSocial;
    private double fondoComplejidad;
    private int legajo;
    
}
