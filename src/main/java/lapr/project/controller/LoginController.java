/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Marcos
 */
public class LoginController {

    RegistoUtilizadores registoUtilizadores;

    public LoginController(RegistoUtilizadores registoUtilizadores) {
        this.registoUtilizadores = registoUtilizadores;
    }

    public Utilizador getUtilizador(String username) {
        return registoUtilizadores.checkUtilizadorByUsername(username);
    }

}
