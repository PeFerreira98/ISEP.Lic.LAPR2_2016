/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Sara Silva
 */
public class Local {

    private String local;

    public Local() {
    }

    public Local(String local) {
        this.local = local;
    }

    /**
     *
     * @param local
     */
    public void setLocal(String local) {
        this.local = local;
    }

    public boolean valida() {
        return local != null && !local.isEmpty();
    }

}
