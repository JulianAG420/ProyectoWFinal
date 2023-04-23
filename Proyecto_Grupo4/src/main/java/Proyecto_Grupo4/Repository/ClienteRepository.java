/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Repository;

import Proyecto_Grupo4.Entity.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author yulien
 */
@Repository
public interface ClienteRepository  extends CrudRepository<Cliente,Long>{
     Cliente findByNombre(String nombre);
     
       @Query(value="select * from cliente e where e.apellido1 like %:keyword% or e.apellido2 like %:keyword%", nativeQuery =true)
    List<Cliente> findByKeyword(@Param("keyword") String keyword);
}
