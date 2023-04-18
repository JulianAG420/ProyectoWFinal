/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;

import Proyecto_Grupo4.Entity.Cliente;
import Proyecto_Grupo4.Repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yulien
 */
@Service
public class ClienteService implements IClienteService{
    
    
          @Autowired
    private ClienteRepository clienteRepository;
    
    @Override
    public List<Cliente> getAllClientes() {
   return (List<Cliente>)clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteById(long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCliente(Cliente cliente) {
       clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
      clienteRepository.deleteById(id);
    }
    
     public List<Cliente> findByKeyword(String keyword){
        return clienteRepository.findByKeyword(keyword);
    }
}
