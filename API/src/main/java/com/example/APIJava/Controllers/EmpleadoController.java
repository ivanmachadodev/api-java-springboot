package com.example.APIJava.Controllers;

import com.example.APIJava.DTOs.DTOEmpleado;
import com.example.APIJava.Models.Empleado;
import com.example.APIJava.Repositories.EmpleadoRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ivanm
 */

@RestController
@RequestMapping("/empleados")
public class EmpleadoController{
    
    @Autowired
    private EmpleadoRepository repo;
    
    @PutMapping("/crear")
    @Transactional
    public ResponseEntity<?> crearEmpleado(@RequestBody Empleado empleado) throws Exception{
        
        try{
            repo.crearEmpleado(empleado);
            return ResponseEntity.ok("El empleado fue creado correctamente");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al cargar empleado");
        }
    } 
    
    
    @GetMapping("/obtener")
    public ResponseEntity<?> obtenerEmpleados() throws Exception{
        try{
            List<DTOEmpleado> encontrado = repo.obtenerEmpleados();
            return ResponseEntity.ok(encontrado);
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al cobtener empleados");
        }
    }
    
    
    
}
