/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ivanmachado
 */
@Setter
@Getter 
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empleado")
public class Empleado {
    @Id @GeneratedValue
    @Column(name="Legajo")
    private int legajo;
    @Column(name="Nombre")
    private String nombre;
    @Column(name="Apellido")
    private String apellido;
    @Column(name="Fecha_Nacimiento")
    private Date fechaNacimiento;
    @Column(name="Fecha_Ingreso")
    private Date fechaIngreso;
    @Column(name="Area")
    private String area;
    @Column(name="Sueldo_Bruto")
    private double sueldoBruto;
    
    @OneToMany(targetEntity = Recibo.class, mappedBy = "empleado")
    @JsonManagedReference    
    private List<Recibo> recibos;
    
    public void addRecibo(Recibo recibo){
        recibo.setEmpleado(this);
        recibos.add(recibo);
    }
    
}
