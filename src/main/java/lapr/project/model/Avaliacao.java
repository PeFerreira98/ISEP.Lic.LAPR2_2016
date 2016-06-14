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
public class Avaliacao {

    private String decisao;
    private String justificacao;
    int[] array = new int[5];

    public Avaliacao() {
        //To use with sets
    }

    /**
     * @return the decisao
     */
    public String getDecisao() {
        return decisao;
    }

    public void setDecisao(String decisao) {
        this.decisao = decisao;
    }

    public String getJustificacao() {
        return justificacao;
    }

    public void setJustificacao(String justificacao) {
        this.justificacao = justificacao;
    }

    public boolean valida() {
        if (justificacao == null || justificacao.trim().isEmpty()) {
            throw new IllegalArgumentException("Texto descritivo inválido!");
        } else if (decisao == null || decisao.trim().isEmpty()) {
            throw new IllegalArgumentException("Decisão inválida!");
        } else if (!"sim".equalsIgnoreCase(decisao) && !"Nao".equalsIgnoreCase(decisao)) {
            return false;
        }
        return true;
    }

}
