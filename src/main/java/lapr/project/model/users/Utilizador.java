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
 * @author Sara Silva
 */
public class Utilizador {

    private String nome;
    private String userName;
    private String password;
    private String email;
    private String userType;
    private String status;

    public Utilizador() {
    }

    public Utilizador(String m_strNome, String m_strUser, String m_strPwd, String m_strEmail, String status, String userType) {
        this.nome = m_strNome;
        this.userName = m_strUser;
        this.password = m_strPwd;
        this.email = m_strEmail;
        this.status = status;
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setNome(String strNome) {
        this.nome = strNome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public void setTipoUtilizador(String tipoUtilizador) {
        this.userType = tipoUtilizador;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.email);
        hash = 67 * hash + Objects.hashCode(this.userName);
        hash = 67 * hash + Objects.hashCode(this.password);
        hash = 67 * hash + Objects.hashCode(this.userType);
        return hash;
    }

    @Override
    public String toString() {
        return String.format("| Nome: %s | Email: %s | Username: %s | Password: %s | TipoUtilizador: %s |", nome, email, userName, password, userType);
    }

    public boolean hasID(String strUserName) {
        return userName.equalsIgnoreCase(strUserName);
    }

    public boolean validaEmail() {
        String ePattern = "(([a-z0-9!#$%&'*+-/=?^_`{|}~]+)|([a-z0-9!#$%&'*+-/=?^_`{|}~]+.[a-z0-9!#$%&'*+-/=?^_`{|}~]+))@[a-z]+([.][a-z]+)*";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public boolean validateUsername(String username) {
        if (this.userName.equals(username)) {
            return true;
        }
        return false;
    }

    public boolean validatePassword(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean valida() {
        return validaEmail();
    }

    public boolean equals(Utilizador u) {
        if (this == u) {
            return true;
        }
        if (u == null || getClass() != u.getClass()) {
            return false;
        }
        Utilizador outroUtilizador = (Utilizador) u;
        return email.equalsIgnoreCase(outroUtilizador.email) && nome.equals(outroUtilizador.nome) && userName.equalsIgnoreCase(outroUtilizador.userName)
                && password.equalsIgnoreCase(outroUtilizador.password);
    }
}
