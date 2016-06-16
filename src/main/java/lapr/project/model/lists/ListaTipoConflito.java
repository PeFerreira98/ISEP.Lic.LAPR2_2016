/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.lists;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.TipoConflito;

/**
 *
 * @author zero_
 */
public class ListaTipoConflito {

    private List<TipoConflito> listTipoConflito;

    public ListaTipoConflito() {
        listTipoConflito = new ArrayList<>();
    }

    public List<TipoConflito> getListaTipoConflito() {
        return this.listTipoConflito;
    }
    
    public boolean addTipoConflito(TipoConflito tipoConflito){
        return this.listTipoConflito.add(tipoConflito);
    }

    @Override
    public String toString() {
        return "\nListaTipoConflito{" + "listTipoConflito=" + listTipoConflito + '}';
    }

}
