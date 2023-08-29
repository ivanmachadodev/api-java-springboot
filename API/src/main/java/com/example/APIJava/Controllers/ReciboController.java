/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.APIJava.Controllers;

import com.example.APIJava.DTOs.DTORecibo;
import com.example.APIJava.DTOs.DTOReciboLegajo;
import com.example.APIJava.DTOs.DTOSueldosAreas;
import com.example.APIJava.Models.Empleado;
import com.example.APIJava.Models.Recibo;
import com.example.APIJava.Repositories.ReciboRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivanm
 */
@RestController
@RequestMapping("/recibos")
public class ReciboController{
    
    @Autowired
    private ReciboRepository repo;
    
    @PutMapping("/crear")
    @Transactional
    public ResponseEntity<?> crearRecibo(@RequestBody DTORecibo dtoRecibo) throws Exception{
        if (dtoRecibo == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Datos de recibo incorrectos");
        }
        
        try{
            Empleado aux = new Empleado();
            aux.setLegajo(dtoRecibo.getLegajo());
            Recibo recibo = new Recibo(0, 
                    dtoRecibo.getMes(),
                    dtoRecibo.getAnio(),
                    dtoRecibo.getAntiguedad(),
                    dtoRecibo.getJubilacion(),
                    dtoRecibo.getObraSocial(),
                    dtoRecibo.getFondoComplejidad(), 
                    aux);
            repo.crearRecibo(recibo);
            return ResponseEntity.ok("Recibo registrado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al cargar recibo");
        }
    } 
    
    @GetMapping("/obtener/{leg}")
    public ResponseEntity<?> obtenerERecibosPorLegajo(@PathVariable int leg) throws Exception{
        try{
            List<DTOReciboLegajo> encontrado = repo.obtenerReciboPorLegajo(leg);
            return ResponseEntity.ok(encontrado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener datos");
        }
    }
    
    @GetMapping("/obtener/{anio}/{mes}")
    public ResponseEntity<?> obtenerSueldosNetosPorArea(@PathVariable int mes, @PathVariable int anio) throws Exception{
        try{
            List<DTOSueldosAreas> encontrado = repo.obtenerSueldosNetosPorArea(mes, anio);
            return ResponseEntity.ok(encontrado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al obtener datos");
        }
    }
    
}
