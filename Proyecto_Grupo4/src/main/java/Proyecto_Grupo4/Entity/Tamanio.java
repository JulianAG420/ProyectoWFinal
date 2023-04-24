/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author yulien
 */
@Entity
@Table (name="tamanio")
public class Tamanio implements Serializable{
     @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private long id;
      private String Tamanio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTamanio() {
        return Tamanio;
    }

    public void setTamanio(String Tamanio) {
        this.Tamanio = Tamanio;
    }

    
      
      
}
