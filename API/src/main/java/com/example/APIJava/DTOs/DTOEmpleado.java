/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.DTOs;

import java.util.Date;
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
public class DTOEmpleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int antiguedad;
    private String area;
    private double sueldoBruto;
    
}
