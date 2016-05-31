/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import lapr.project.model.lists.ListaUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class LoginController {
    
    List<Utilizador> lstUsers;
    
    public LoginController(List<Utilizador> lst){
        this.lstUsers =lst;
        
    }
    
    public Utilizador getUtilizador(String user) throws IOException{
        
        for(Utilizador u : this.lstUsers){
           if(u.getUser().equalsIgnoreCase(user)){
                return u;
           }
        }
        return null;
    }
    
}
