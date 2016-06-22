/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author Sara Silva
 */
public class Avaliacao implements Serializable{

    private String decisao;
    private String justificacao;
    private int[] array = new int[5]; //conhecimento, adequacaoExpo, adequDemo, adequConv, reco
    
    private String texto;
    private Atribuicao atribuicao;
    
    public Avaliacao() {
        //To use with sets
    }
    
    public Avaliacao(String texto, int conhecimentoFAE, int adequacaoExpo, int adequacaoDemo, int adequacaoCon, int recomendacao, Atribuicao atribuicao){
        this.texto = texto;
        this.array[0] = conhecimentoFAE;
        this.array[1] = adequacaoExpo;
        this.array[2] = adequacaoDemo;
        this.array[3] = adequacaoCon;
        this.array[4] = recomendacao;
        this.atribuicao = atribuicao;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.decisao);
        hash = 89 * hash + Objects.hashCode(this.justificacao);
        hash = 89 * hash + Arrays.hashCode(this.array);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avaliacao other = (Avaliacao) obj;
        if (!Objects.equals(this.decisao, other.decisao)) {
            return false;
        }
        if (!Objects.equals(this.justificacao, other.justificacao)) {
            return false;
        }
        if (!Arrays.equals(this.array, other.array)) {
            return false;
        }
        return true;
    }
    
    

}
