/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;

/**
 *
 * @author zero_
 */
public class Utilizador {
    
    private String nome;
    private String email;
    private String username;
    private String password;
    //private boolean registado;
    

    /**
     * Construtor de objecto Utilizador
     *
     * @param nome o nome do Utilizador
     * @param email o email do Utilizador
     * @param username o username do Utillizador
     * @param password a password do Utilizador
     */
    public Utilizador(String nome, String email, String username, String password) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getUser(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getEmail(){
        return this.email;
    }

    /**
     * Método para comparar um objecto com outro
     *
     * @param outroUtilizador objecto a comparar
     * @return true se todos os parâmetros forem iguais. false caso contrário
     */
    @Override
    public boolean equals(Object outroUtilizador) {
        if (outroUtilizador == null) {
            return false;
        }
        if (getClass() != outroUtilizador.getClass()) {
            return false;
        }
        final Utilizador other = (Utilizador) outroUtilizador;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nome);
        hash = 83 * hash + Objects.hashCode(this.email);
        hash = 83 * hash + Objects.hashCode(this.username);
        hash = 83 * hash + Objects.hashCode(this.password);
        return hash;
    }

}
