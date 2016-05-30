/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.Objects;

/**
 *
 * @author TiagoSilvestre
 */
public class Utilizador {

    //atributos de instânica
    private String nome;
    private String email;
    private String username;
    private String password;
    private boolean registado;

    //atributos de classe
    private static String NOME_OMISSAO = "no name";
    private static String EMAIL_OMISSAO = "no email";
    private static String USERNAME_OMISSAO = "no username";
    private static String PASSWORD_OMISSAO = "no password";

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

    /**
     * Construtor de Utilizador
     *
     * @param nome o nome do utilizador
     * @param email o email do utilizador
     */
    public Utilizador(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    /**
     * Construtor vazio de objecto Utilizador
     */
    public Utilizador() {
        this.nome = NOME_OMISSAO;
        this.email = EMAIL_OMISSAO;
        this.username = USERNAME_OMISSAO;
        this.password = PASSWORD_OMISSAO;
    }

    /**
     * Construtor cópia de objecto Utilizador
     *
     * @param outroUtilizador outro Utilizador
     */
    public Utilizador(Utilizador outroUtilizador) {
        this(outroUtilizador.getNome(), outroUtilizador.getEmail(), outroUtilizador.getUsername(), outroUtilizador.getPassword());
    }

    /**
     * Devolve o nome do utilizador
     *
     * @return o nome do utilizador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do utilizador
     *
     * @param nome o novo nome do utilizador
     */
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido!");
        }
        this.nome = nome;
    }

    /**
     * Devolve o email do utilizador
     *
     * @return o email do utilizador
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email do utilizador
     *
     * @param email o novo email do utilizador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devolve do username do utilizador
     *
     * @return o username do utilizador
     */
    public String getUsername() {
        return username;
    }

    /**
     * Modifica o username do utilizador
     *
     * @param username o nome username do utilizador
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Devolve a password do utilizador
     *
     * @return a password do utilizador
     */
    public String getPassword() {
        return password;
    }

    /**
     * Modifica a password do utilizador
     *
     * @param password a nova password do utilizador
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Devolve se o utilizador está registado
     *
     * @return true caso esteja, false caso contrario
     */
    public boolean getRegistado() {
        return registado;
    }

    /**
     * Modifica o registo do utilizador
     *
     * @param registado o novo registo
     */
    public void setRegistado(boolean registado) {
        this.registado = registado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    /**
     * Método para comparar um objecto com outro
     *
     * @param outroUtilizador objecto a comparar
     * @return true se todos os parâmetros forem iguais. false caso contrário
     */
    public boolean equals(Utilizador outroUtilizador) {
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

    /**
     * Devolve a informação textual de Utilizador
     *
     * @return informação textual
     */
    @Override
    public String toString() {
        return String.format("Nome: %s\n"
                + "Email: %s\n"
                + "Username: %s\n"
                + "Password: %s\n", this.nome, this.email, this.username, this.password);
    }

    /**
     * Método para validar o Utilizador
     *
     * @return true caso valide, false caso contrario
     */
    public boolean valida() {
        return !(getNome().equalsIgnoreCase("") || getEmail().equalsIgnoreCase("")
                || getUsername().equalsIgnoreCase("") || getPassword().equalsIgnoreCase(""));
    }

    /**
     * Método para verificar se utilizador tem id
     *
     * @param id o id
     * @return true caso tenha, false caso contrario
     */
    public boolean hasID(String id) {
        return username.equalsIgnoreCase(id);
    }

    /**
     * Devolve o id do utilizador
     *
     * @return o username
     */
    public String getID() {
        return username;
    }

    /**
     * Método para clonar o utilizador
     *
     * @return utilizador clonado
     */
    public Utilizador clonar() {
        return new Utilizador(getNome(), getEmail(), getUsername(), getPassword());
    }

    /**
     * Método para validar a password
     *
     * @param password a password inserida
     * @return true caso valide, false contrario
     */
    public boolean validaPassword(String password) {
        return this.password.equalsIgnoreCase(password);
    }

    /**
     * Método para alterar a password
     *
     * @param original a password orginal
     * @param nova a nova password
     * @return true caso altera, false caso contrario
     */
    public boolean mudarPassword(String original, String nova) {
        if (original == null || nova == null) {
            throw new NullPointerException("Password vazia!");
        }
        if (!validaPassword(original)) {
            return false;
        }
        if (nova.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("Nova Password vazia!");
        }
        this.password = nova;
        return true;
    }

}
