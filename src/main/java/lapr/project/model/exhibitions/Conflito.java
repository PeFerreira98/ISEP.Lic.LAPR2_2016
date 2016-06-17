/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exhibitions;

import java.io.Serializable;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public class Conflito implements Serializable {

    private Candidatura candidatura;
    private FAE fae;

    public Conflito(FAE fae, Candidatura candidatura) {
        this.fae = fae;
        this.candidatura = candidatura;
    }

}
