/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @author yulien
 */
 @Entity
@Table (name="bolsas_cafe")
public class Bolsas_Cafe  implements Serializable{
    @ManyToOne
    @JoinColumn(name="Tueste_id")
     private Tueste tueste;
    
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
            private long id;
        private String Marca;
        private int precio;
        private int Cantidad;

    public Tueste getTueste() {
        return tueste;
    }

    public void setTueste(Tueste tueste) {
        this.tueste = tueste;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
        
}
