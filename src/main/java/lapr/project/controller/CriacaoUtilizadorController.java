/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.IOException;
import java.util.List;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class CriacaoUtilizadorController {
    
    List<Utilizador> lstUsers;
    
    public CriacaoUtilizadorController(List<Utilizador> lst){
        this.lstUsers =lst;
        
    }
    
    public boolean checkUsername(String user){
        for(Utilizador u : this.lstUsers){
           if(u.getUser().equalsIgnoreCase(user)){
                return true;
           }
        }
        return false;
    }
    
    public boolean checkEmail(String email){
        for(Utilizador u: this.lstUsers){
            if(u.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }
    
}
