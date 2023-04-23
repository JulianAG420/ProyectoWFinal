/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Controller;

import Proyecto_Grupo4.Entity.Bolsas_Cafe;

import Proyecto_Grupo4.Entity.Tueste;
import Proyecto_Grupo4.Service.Bolsas_CafeService;


import Proyecto_Grupo4.Service.IBolsas_CafeService;
import Proyecto_Grupo4.Service.ITuesteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author yulien
 */
@Controller
public class Bolsas_CafeController {
       @Autowired
    private IBolsas_CafeService bolsas_cafeService;
       
          @Autowired
    private ITuesteService tuesteService;
          
          private Bolsas_CafeService bolsas_cafeService1;
          
            @GetMapping("/inventario")
    public String index(Model model ){ 
        List<Bolsas_Cafe> listaBolsa = bolsas_cafeService.getAllBolsa();
        model.addAttribute("titulo", "Inventario De Bolsas de cafe");
        model.addAttribute("bolsas_cafe", listaBolsa);
        
      
    return "inventario";
        }
    
    
     @GetMapping("/inventarioN")
    public String crearInventario(Model model){
         List<Tueste> listTueste = tuesteService.listTueste();
         model.addAttribute("bolsas_cafe", new Bolsas_Cafe());
         model.addAttribute("tueste", listTueste);
         return "Ingresar";
    }
    
    @PostMapping("/saveIN")
   public String guardarBolsa(@ModelAttribute Bolsas_Cafe bolsas_cafe){
       bolsas_cafeService.saveBolsa(bolsas_cafe);
       return "redirect:/inventario";
   }
    
      @GetMapping("/deleteIn/{id}")
    public String delete(@PathVariable("id") long id ){
       bolsas_cafeService.delete(id);
        return "redirect:/inventario";
   
    }
    
      @GetMapping("/editInventario/{id}")
    public String editarInventario(@PathVariable("id") Long idBolsas_Cafe, Model model){
        Bolsas_Cafe bolsas_cafe = bolsas_cafeService.getBolsaById(idBolsas_Cafe);
        List<Tueste> listTueste = tuesteService.listTueste();
        model.addAttribute("bolsas_cafe", bolsas_cafe);
        model.addAttribute("tueste", listTueste);
        return "Ingresar";
    }
}
