/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.users;

import java.util.Objects;

/**
 *
 * @author Sara Silva
 */
public class Utilizador {

    private String nome;
    private String username;
    private String password;
    private String email;

    //TODO: Change string to respective state class
    private String tipoUtilizador;
    private String estado;

    public Utilizador(String nome, String username, String password, String email, String tipoUtilizador) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.email = email;

        this.estado = "PENDING";
        this.tipoUtilizador = tipoUtilizador;
    }

    public boolean validateUsername(String username) {
        return this.username.equals(username);
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public boolean validateEmail(String email) {
        return this.email.equals(email);
    }

    public boolean isRegistado() {
        return this.estado.equalsIgnoreCase("REGISTERED");
    }

    public boolean isGestor() {
        return this.tipoUtilizador.equalsIgnoreCase("GESTOR");
    }

    public boolean isFAE() {
        return this.tipoUtilizador.equalsIgnoreCase("FAE");
    }

    public void setRegistado() {
        this.estado = "REGISTERED";
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public String getEstado() {
        return this.estado;
    }

    public String getTipoUtilizador() {
        return this.tipoUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.username);
        hash = 71 * hash + Objects.hashCode(this.password);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.tipoUtilizador);
        hash = 71 * hash + Objects.hashCode(this.estado);
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
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tipoUtilizador, other.tipoUtilizador)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "\nUtilizador{" + "nome=" + nome + ", username=" + username + ", password=" + password + ", email=" + email + ", tipoUtilizador=" + tipoUtilizador + ", estado=" + estado + '}';
    }

}
