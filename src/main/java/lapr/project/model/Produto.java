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
public class Produto {

    private String descricao;

    public Produto(String designacao) {
        this.descricao = designacao;
    }

    /**
     * @return the designacao
     */
    public String getDescricao() {
        return descricao;
    }

}
