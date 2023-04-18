/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Controller;


import Proyecto_Grupo4.Entity.Empleado;
import Proyecto_Grupo4.Entity.seccion;
import Proyecto_Grupo4.Service.EmpleadoService;
import Proyecto_Grupo4.Service.IEmpleadoService;
import Proyecto_Grupo4.Service.ISeccionService;
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
public class EmpleadoController {
     @Autowired
    private IEmpleadoService empleadoService;
    
    @Autowired
    private ISeccionService seccionService;
    
     @Autowired
    private EmpleadoService EmpleadoService;

    @GetMapping("/empleado")
    public String index(Model model, String keyword){
        List<Empleado> listaEmpleado = empleadoService.getAllEmpleados();
        model.addAttribute("titulo", "Empleados Contratados");
        model.addAttribute("empleado", listaEmpleado);
        
        
             if(keyword != null){
            model.addAttribute("empleado", EmpleadoService.findByKeyword(keyword));
        }else{
          model.addAttribute("empleado", EmpleadoService.getAllEmpleados());
        }
       
        return "empleado";
        
        
        
        
    }
    @GetMapping("/empleadoN")
    public String crearCliente(Model model){
         List<seccion> listseccion = seccionService.listseccion();
         model.addAttribute("empleado", new Empleado());
         model.addAttribute("seccion", listseccion);
         return "crearE";
    }
    
    
   @PostMapping("/saveE")
   public String guardarEmpleado(@ModelAttribute Empleado empleado){
       empleadoService.saveEmpleado(empleado);
       return "redirect:/empleado";
   }
    
     @GetMapping("/deleteE/{id}")
    public String delete(@PathVariable("id") long id ){
       empleadoService.delete(id);
        return "redirect:/empleado";
   
    }
    
      @GetMapping("/editEmpleado/{id}")
    public String editarEmpleado(@PathVariable("id") Long idEmpleado, Model model){
        Empleado empleado = empleadoService.getEmpleadoById(idEmpleado);
        List<seccion> listseccion = seccionService.listseccion();
        model.addAttribute("empleado", empleado);
        model.addAttribute("seccion", listseccion);
        return "crearE";
    }
}
