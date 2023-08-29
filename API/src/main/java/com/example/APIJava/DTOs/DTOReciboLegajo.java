/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.DTOs;

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
public class DTOReciboLegajo {
    
    private int legajo;
    private int mes;
    private int anio;
    private double sieldoBruto;
    private double sueldoNeto;
    
}
