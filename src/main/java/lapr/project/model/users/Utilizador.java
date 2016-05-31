/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;
import lapr.project.model.TipoUtilizador;

/**
 *
 * @author zero_
 */
public class Utilizador {

    private String nome;
    private String email;
    private String username;
    private String password;
    private TipoUtilizador tipoUtilizador;
    //private boolean registado;

    /**
     * Construtor de objecto Utilizador
     *
     * @param nome o nome do Utilizador
     * @param email o email do Utilizador
     * @param username o username do Utillizador
     * @param password a password do Utilizador
     */
    public Utilizador(String nome, String email, String username, String password, TipoUtilizador tipoUtilizador) {
        this.nome = nome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.tipoUtilizador = tipoUtilizador;
    }

    public boolean validatePassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean validateUsername(String username) {
        if (this.username.equals(username)) {
            return true;
        }
        return false;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
        this.tipoUtilizador = tipoUtilizador;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.username);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.tipoUtilizador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (getClass() != obj.getClass()) {
            return false;
        }

        final Utilizador other = (Utilizador) obj;
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
        if (this.tipoUtilizador != other.tipoUtilizador) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "\nUtilizador{" + "nome=" + nome + ", email=" + email + ", username=" + username + ", password=" + password + ", tipoUtilizador=" + tipoUtilizador + '}';
    }

}
