/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;

import Proyecto_Grupo4.Entity.Bolsas_Cafe;
import java.util.List;

/**
 *
 * @author yulien
 */
public interface IBolsas_CafeService {
      public List<Bolsas_Cafe> getAllBolsa();
    public Bolsas_Cafe getBolsaById (long id);
    public void saveBolsa(Bolsas_Cafe bolsas_cafe);
    public void delete (long id);
}
