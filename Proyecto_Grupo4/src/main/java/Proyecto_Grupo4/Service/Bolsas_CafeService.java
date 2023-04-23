/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;

import Proyecto_Grupo4.Entity.Bolsas_Cafe;
import Proyecto_Grupo4.Repository.Bolsas_CafeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class Bolsas_CafeService implements IBolsas_CafeService{
        @Autowired
    private Bolsas_CafeRepository bolsas_cafeRepository;
        
    @Override
    public List<Bolsas_Cafe> getAllBolsa() {
       return (List<Bolsas_Cafe>)bolsas_cafeRepository.findAll();
    }

    @Override
    public Bolsas_Cafe getBolsaById(long id) {
           return bolsas_cafeRepository.findById(id).orElse(null);
    }

    @Override
    public void saveBolsa(Bolsas_Cafe bolsas_cafe) {
           bolsas_cafeRepository.save(bolsas_cafe);
    }

    @Override
    public void delete(long id) {
         bolsas_cafeRepository.deleteById(id);
    }

}
