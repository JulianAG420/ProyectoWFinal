/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Repository;


import Proyecto_Grupo4.Entity.Tamanio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yulien
 */
@Repository
public interface TamanioRepository extends CrudRepository<Tamanio,Long>{
    
}
