/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.seccion;

import Proyecto_Grupo4.Repository.seccionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class seccionService implements ISeccionService{
       @Autowired
    private seccionRepository seccionRepository;
    
 @Override
    public List<seccion> listseccion() {
        return (List<seccion>)seccionRepository.findAll();
    }
}
