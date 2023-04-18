/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.Empleado;
import Proyecto_Grupo4.Repository.EmpleadoRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class EmpleadoService implements IEmpleadoService{
    
      @Autowired
    private EmpleadoRepository empleadoRepository;
      
       @Override
    public List<Empleado> getAllEmpleados() {
   return (List<Empleado>)empleadoRepository.findAll();
    }

 @Override
    public Empleado getEmpleadoById(long id) {
        return empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEmpleado(Empleado empleado) {
       empleadoRepository.save(empleado);
    }

    @Override
    public void delete(long id) {
      empleadoRepository.deleteById(id);
    }
    
     public List<Empleado> findByKeyword(String keyword){
        return empleadoRepository.findByKeyword(keyword);
    }

  
}
