/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

//import java.util.Objects;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Atribuicao {

    private FAE fae;
    private Candidatura candidatura;
    
    public Atribuicao(FAE f, Candidatura c) {
        this.fae = f;
        this.candidatura = c;
    }

    /**
     * @return the fae
     */
    public FAE getFae() {
        return fae;
    }
    
    public Candidatura getCandidatura(){
        return this.candidatura;
    }

    @Override
    public String toString() {
        return "\n Atribuicao{" + "fae=" + fae + ", candidatura=" + candidatura + '}';
    }

}
