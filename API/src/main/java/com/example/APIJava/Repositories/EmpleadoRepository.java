/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.Repositories;

import com.example.APIJava.DTOs.DTOEmpleado;
import com.example.APIJava.Models.Empleado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ivanm
 */
@Repository
public class EmpleadoRepository{
    
    @PersistenceContext
    private EntityManager em;
    
    
    public List<DTOEmpleado> obtenerEmpleados() throws Exception{
        return (List<DTOEmpleado>) em.createNativeQuery("SELECT Legajo, Nombre, Apellido, Fecha_Nacimiento, Fecha_Ingreso, ROUND(DATEDIFF(CURDATE(), Fecha_Ingreso)/365) AS Antiguedad, "
            + "Area, Sueldo_Bruto FROM segundoparciallabiv.empleado;").getResultList();
    }
    
    public void crearEmpleado(Empleado empleado) throws Exception{
        em.persist(empleado);
    }
    
    
    
}
