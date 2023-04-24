/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.Cafeteras;
import Proyecto_Grupo4.Repository.CafeterasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class CafeterasService implements ICafeterasService {
      @Autowired
    private CafeterasRepository cafeterasRepository;

    @Override
    public List<Cafeteras> getAllCafeteras() {
       return (List<Cafeteras>)cafeterasRepository.findAll();
    }

    @Override
    public Cafeteras getCafeterasById(long id) {
        return cafeterasRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCafeteras(Cafeteras cafeteras) {
       cafeterasRepository.save(cafeteras);
    }

    @Override
    public void delete(long id) {
       cafeterasRepository.deleteById(id);
    }
}
