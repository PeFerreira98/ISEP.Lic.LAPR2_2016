/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.mecanismos;

import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.FAE;

/**
 *
 * @author Sara Silva
 */
public interface MecanismoDetecaoConflito {
    public void detectConflitos(Exposicao exposicao);
    public boolean isConflito(FAE fae, Candidatura candidatura);
    
}
