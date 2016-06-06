/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import javax.swing.text.Utilities;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class AlterarPerfilUtilizadorController {
    
    private Utilizador user;
    private RegistoUtilizadores registoUtilizadores;
    
    public AlterarPerfilUtilizadorController(Utilizador u, RegistoUtilizadores rUers){
        this.registoUtilizadores = rUers;
        this.user = u;
    }
    
    public void setName(String name){
        registoUtilizadores.checkUtilizadorByUsername(this.user.getUsername()).setNome(name);
    }
    
    public boolean confirmPassword(String pw){
        if(this.user.getPassword().equals(pw)){
            return true;
        }
        return false;
    }
    
    public void setPassword(String pw){
        this.user.setPassword(pw);
    }
    
    public boolean setEmail(String email){
        if(this.registoUtilizadores.checkUtilizadorByEmail(email)==null){
            this.user.setEmail(email);
            return true;
        }
        return false;
    }
    
}
