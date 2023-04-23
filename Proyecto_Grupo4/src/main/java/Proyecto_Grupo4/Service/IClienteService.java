/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;

import Proyecto_Grupo4.Entity.Cliente;
import java.util.List;

/**
 *
 * @author yulien
 */
public interface IClienteService {
     public List<Cliente> getAllClientes();
    public Cliente getClienteById (long id);
    public void saveCliente(Cliente cliente);
    public void delete (long id);
      public Cliente findByNombre(String username);
}
