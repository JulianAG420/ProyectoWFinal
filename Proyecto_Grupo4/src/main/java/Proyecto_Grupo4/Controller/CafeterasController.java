/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Controller;


import Proyecto_Grupo4.Entity.Cafeteras;
import Proyecto_Grupo4.Entity.Tamanio;
import Proyecto_Grupo4.Service.ICafeterasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import Proyecto_Grupo4.Service.ITamanioService;

/**
 *
 * @author yulien
 */
@Controller
public class CafeterasController {
     @Autowired
    private ICafeterasService cafeterasService;
       
          @Autowired
    private  ITamanioService tamañoService;
          
          
           @GetMapping("/inventario1")
    public String index(Model model ){ 
        List<Cafeteras> listaCafeteras = cafeterasService.getAllCafeteras();
        model.addAttribute("titulo", "Inventario de Cafeteras");
        model.addAttribute("cafeteras", listaCafeteras);
        
      
    return "inventario1";
        }
    
    
     @GetMapping("/inventarioN11")
    public String crearInventario(Model model){
         List<Tamanio> listTamaño = tamañoService.listTamaño();
         model.addAttribute("cafeteras", new Cafeteras());
         model.addAttribute("Tamanio", listTamaño);
         return "Ingresar1";
    }
    
    @PostMapping("/saveIN1")
   public String guardarCafetera(@ModelAttribute Cafeteras cafeteras){
       cafeterasService.saveCafeteras(cafeteras);
       return "redirect:/inventario1";
   }
    
      @GetMapping("/deleteIn1/{id}")
    public String delete(@PathVariable("id") long id ){
       cafeterasService.delete(id);
        return "redirect:/inventario1";
   
    }
    
      @GetMapping("/editInventario12/{id}")
    public String editarInventario12(@PathVariable("id") Long idCafeteras, Model model){
        Cafeteras cafeteras = cafeterasService.getCafeterasById(idCafeteras);
        List<Tamanio> listTamanio = tamañoService.listTamaño();
        model.addAttribute("cafeteras", cafeteras);
        model.addAttribute("Tamanio", listTamanio);
        return "Ingresar1";
    }
}

