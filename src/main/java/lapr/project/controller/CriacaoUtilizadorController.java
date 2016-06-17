/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.io.Serializable;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class CriacaoUtilizadorController implements Serializable {

    RegistoUtilizadores registoUtilizadores;

    public CriacaoUtilizadorController(RegistoUtilizadores registoUtilizadores) {
        this.registoUtilizadores = registoUtilizadores;
    }

    public boolean addUtilizadorNaoRegistado(Utilizador utilizador) {
        return registoUtilizadores.addUtilizadorNaoRegistado(utilizador);
    }

    public boolean checkUtilizadorByUsername(String username) {
        if (registoUtilizadores.checkUtilizadorByUsername(username) == null) {
            return false;
        }
        return true;
    }

    public boolean checkUtilizadorByEmail(String email) {
        if (registoUtilizadores.checkUtilizadorByEmail(email) == null) {
            return false;
        }
        return true;
    }

    public boolean validaEmailPattern(String email) {
        String ePattern = "(([a-z0-9!#$%&'*+-/=?^_`{|}~]+)|([a-z0-9!#$%&'*+-/=?^_`{|}~]+.[a-z0-9!#$%&'*+-/=?^_`{|}~]+))@[a-z]+([.][a-z]+)*";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
