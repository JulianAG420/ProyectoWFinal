/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author Roberto
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired 
    public IClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Cliente cliente = this.clienteService.findByNombre(username);
        Userprincipal userPrincipal = new Userprincipal(cliente);
        return userPrincipal;
    }
}
