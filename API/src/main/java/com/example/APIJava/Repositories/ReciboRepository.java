/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.APIJava.Repositories;

import com.example.APIJava.DTOs.DTOReciboLegajo;
import com.example.APIJava.DTOs.DTOSueldosAreas;
import com.example.APIJava.Models.Empleado;
import com.example.APIJava.Models.Recibo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author ivanm
 */
@Repository
public class ReciboRepository{
    
    @PersistenceContext
    private EntityManager em;
    
    public void crearRecibo(Recibo recibo) throws Exception{
        Empleado emp = em.find(Empleado.class, recibo.getEmpleado().getLegajo());
        emp.addRecibo(recibo);
        em.merge(recibo);
    }
    
    public List<DTOReciboLegajo> obtenerReciboPorLegajo(int legajo) throws Exception{
        return (List<DTOReciboLegajo>) em.createNativeQuery("SELECT r.Legajo, Anio, Mes, e.Sueldo_Bruto,"
                                                    + "(e.Sueldo_Bruto + r.Antiguedad - r.Jubilacion - r.Obra_Social - Fondo_Complejidad) AS 'Sueldo Neto'" +
                                                    "      FROM segundoparciallabiv.recibo r join segundoparciallabiv.empleado e on r.Legajo = e.Legajo" +
                                                    "      where r.Legajo = " + legajo +";").getResultList();
    }
    
    public List<DTOSueldosAreas> obtenerSueldosNetosPorArea(int mes, int anio) throws Exception{
        return (List<DTOSueldosAreas>) em.createNativeQuery("SELECT e.Area, sum((e.Sueldo_Bruto + r.Antiguedad - r.Jubilacion - r.Obra_Social - Fondo_Complejidad)) AS 'Sueldo Neto'" +
                                                    " FROM segundoparciallabiv.recibo r join segundoparciallabiv.empleado e on r.Legajo = e.Legajo" +
                                                    " WHERE r.Mes = " + mes + " and r.Anio = " + anio +
                                                    " GROUP BY e.Area" +
                                                    " ORDER BY sum((e.Sueldo_Bruto + r.Antiguedad - r.Jubilacion - r.Obra_Social - Fondo_Complejidad)) desc").getResultList();
    }
    
}
