/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author Sara Silva
 */
public class Utilizador {

    private String nome;
    private String userName;
    private String password;
    private String email;

    public Utilizador() {
    }

    public Utilizador(String m_strNome, String m_strUser, String m_strPwd, String m_strEmail) {
        this.nome = m_strNome;
        this.userName = m_strUser;
        this.password = m_strPwd;
        this.email = m_strEmail;
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

    public void setNome(String strNome) {
        this.nome = strNome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public boolean valida() {
        System.out.println("Utilizador: valida: " + this.toString());
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("| Nome: %s | Email: %s | Username: %s | Password: %s |", nome, email, userName, password);
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
