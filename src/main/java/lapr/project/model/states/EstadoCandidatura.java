/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.states;

import java.io.Serializable;

/**
 *
 * @author zero_
 */
public interface EstadoCandidatura extends Serializable{

    public boolean setRetirada();

    public boolean setEmSubmissao();

    public boolean setEmAvaliacao();

    public boolean setAvaliada();

    public boolean setNaoAvaliada();

    public boolean setAceite();

    public boolean setRejeitada();

    
    public boolean isRetirada();

    public boolean isEmSubmissao();

    public boolean isEmAvaliacao();

    public boolean isAvaliada();

    public boolean isNaoAvaliada();

    public boolean isAceite();

    public boolean isRejeitada();

}
