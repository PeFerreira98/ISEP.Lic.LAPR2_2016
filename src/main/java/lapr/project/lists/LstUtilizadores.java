/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class LstUtilizadores {
    
    List<Utilizador> lstU;
    
    public LstUtilizadores(){
        lstU = new ArrayList<>();
        Utilizador u = new Utilizador("nome", "email", "admin", "admin");
        lstU.add(u);
                
    }
    
    public List<Utilizador> getLstUtilizadores(){
        return this.lstU;
    }
    
}
