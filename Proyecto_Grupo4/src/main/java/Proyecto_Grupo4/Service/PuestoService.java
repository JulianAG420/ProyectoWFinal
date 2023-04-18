/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;

import Proyecto_Grupo4.Entity.puesto;
import Proyecto_Grupo4.Repository.PuestoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class PuestoService implements IPuestoService{
       @Autowired
    private PuestoRepository puestoRepository;
    
    @Override
    public List<puesto> listpuesto() {
        return (List<puesto>)puestoRepository.findAll();
    }
}
