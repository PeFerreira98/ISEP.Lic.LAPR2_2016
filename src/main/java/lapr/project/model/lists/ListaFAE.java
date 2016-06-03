/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class ListaFAE {

    private List<FAE> listaFAE;

    public ListaFAE() {
        listaFAE = new ArrayList<>();
    }

    public boolean addFAE(FAE fae) {

        //Verificação de ja existe este FAE
        for (FAE f : listaFAE) {
            System.out.println(fae + " =?= " + f);
            if (f.equals(fae)) {
                return false;
            }
        }

        return this.listaFAE.add(fae);
    }

    public List<FAE> getListaFAE() {
        return this.listaFAE;
    }
    
    public boolean valida(){
        if (listaFAE.isEmpty() || listaFAE == null) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nListaFAE{" + "listaFAE=" + listaFAE + '}';
    }

}
