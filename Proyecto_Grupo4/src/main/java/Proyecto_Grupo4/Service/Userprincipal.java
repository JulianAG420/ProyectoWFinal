/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto_Grupo4.Service;


import Proyecto_Grupo4.Entity.Cliente;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Roberto
 */
public class Userprincipal implements UserDetails {
    private Cliente cliente;

    public Userprincipal(Cliente cliente) {
        this.cliente = cliente;
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
         this.cliente.gePermissionList().forEach(p ->{
        GrantedAuthority authority= new SimpleGrantedAuthority(p);
        authorities.add(authority);
    });
           this.cliente.getRoleList().forEach(r ->{
        GrantedAuthority authority= new SimpleGrantedAuthority("ROLE_" + r);
        authorities.add(authority);
    });
    return authorities;
    }

    @Override
    public String getPassword() {
       return this.cliente.getPassword();
    }

    @Override
    public String getUsername() {
        return this.cliente.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
       return this.cliente.getActive()==1;
    }
    
}
