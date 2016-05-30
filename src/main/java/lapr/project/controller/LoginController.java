/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.lists.ListaUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class LoginController {
    
    ListaUtilizadores lstUsers;
    
    public LoginController(){
    }
    
    public Utilizador checkUtilizador(String user){
        lstUsers = new ListaUtilizadores();
        List<Utilizador> lstAux = lstUsers.getListaUtilizadores();
        
        for(Utilizador u : lstAux){
           if(u.getUser().equalsIgnoreCase(user)){
                return u;
           }
        }
        
        return null;
    }
    
}
