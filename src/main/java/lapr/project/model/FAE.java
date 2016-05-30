/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

/**
 *
 * @author TiagoSilvestre
 */
public class FAE extends Utilizador {

    /**
     * Construtor de objecto FAE (Funcionário de Apoio à Exposição)
     *
     * @param nome o nome do FAE
     * @param email o email do FAE
     * @param username o username do FAE
     * @param password a password do FAE
     */
    public FAE(String nome, String email, String username, String password) {
        super(nome, email, username, password);
    }

    /**
     * Construtor vazio de objecto FAE
     */
    public FAE() {
        super();
    }

    /**
     * Construtor cópia de objecto FAE
     *
     * @param outroFAE outro objecto FAE
     */
    public FAE(FAE outroFAE) {
        super(outroFAE);
    }

    /**
     * Devolve a informação textual de FAE
     *
     * @return informação textual
     */
    @Override
    public String toString() {
        return String.format("FAE\n"
                + "%s", super.toString());
    }

    /**
     * Método para validar FAE
     *
     * @return true caso valide, false caso contrario
     */
    @Override
    public boolean valida() {
        return !(getNome().equalsIgnoreCase("") || getEmail().equalsIgnoreCase("")
                || getUsername().equalsIgnoreCase("") || getPassword().equalsIgnoreCase(""));
    }
}
