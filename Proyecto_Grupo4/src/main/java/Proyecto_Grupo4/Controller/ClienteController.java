/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Controller;


import Proyecto_Grupo4.Entity.Cliente;
import Proyecto_Grupo4.Entity.puesto;
import Proyecto_Grupo4.Service.ClienteService;
import Proyecto_Grupo4.Service.IClienteService;
import Proyecto_Grupo4.Service.IPuestoService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService clienteService;
    
    @Autowired
    private IPuestoService puestoService;
    
     @Autowired
    private ClienteService clienteService1;

    @GetMapping("/cliente")
    public String index(Model model, String keyword){
        List<Cliente> listaCliente = clienteService.getAllClientes();
        model.addAttribute("titulo", "Clientes Registrados");
        model.addAttribute("cliente", listaCliente);
        
        
             if(keyword != null){
            model.addAttribute("cliente", clienteService1.findByKeyword(keyword));
        }else{
          model.addAttribute("cliente", clienteService1.getAllClientes());
        }
       
        return "cliente";
        
        
        
        
    }
    @GetMapping("/clienteN")
    public String crearCliente(Model model){
         List<puesto> listpuesto = puestoService.listpuesto();
         model.addAttribute("cliente", new Cliente());
         model.addAttribute("puesto", listpuesto);
         return "crear";
    }
    
    
   @PostMapping("/save")
   public String guardarCliente(@ModelAttribute Cliente cliente){
       clienteService.saveCliente(cliente);
       return "redirect:/cliente";
   }
    
     @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id ){
       clienteService.delete(id);
        return "redirect:/cliente";
   
    }
    
      @GetMapping("/editCliente/{id}")
    public String editarCliente(@PathVariable("id") Long idCliente, Model model){
        Cliente cliente = clienteService.getClienteById(idCliente);
        List<puesto> listpuesto = puestoService.listpuesto();
        model.addAttribute("cliente", cliente);
        model.addAttribute("puesto", listpuesto);
        return "crear";
    }
}
