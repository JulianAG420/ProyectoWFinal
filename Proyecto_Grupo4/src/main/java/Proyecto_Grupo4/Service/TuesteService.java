/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;



import Proyecto_Grupo4.Entity.Tueste;
import Proyecto_Grupo4.Repository.TuesteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class TuesteService implements ITuesteService {
       @Autowired
    private TuesteRepository tuesteRepository;
       
         @Override
    public List<Tueste> listTueste() {
        return (List<Tueste>)tuesteRepository.findAll();
    }
}
