/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.submissions;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author Sara Silva
 */
public class Avaliacao implements Serializable{

    private int[] array = new int[5]; //conhecimento, adequacaoExpo, adequDemo, adequConv, reco
    
    private String texto;
    private Atribuicao atribuicao;
    
    public Avaliacao() {
        //To use with sets
    }
    
    public Avaliacao(String texto, int conhecimentoFAE, int adequacaoExpo, int adequacaoDemo, int adequacaoCon, int recomendacao){
        this.texto = texto;
        this.array[0] = conhecimentoFAE;
        this.array[1] = adequacaoExpo;
        this.array[2] = adequacaoDemo;
        this.array[3] = adequacaoCon;
        this.array[4] = recomendacao;
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
    
    public void setTexto(String texto){
        this.texto = texto;
    }
    
    public Atribuicao getAtribuicao(){
        return this.atribuicao;
    }
    
    public int getRecomendacao(){
        return this.array[4];
    }
    
    public String getTexto(){
        return this.texto;
    }
    public boolean valida() {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        for(int i = 0; i < array.length; i++){
            if(this.array[i]>6 || this.array[i]<0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        if (!Arrays.equals(this.array, other.array)) {
            return false;
        }
        return true;
    }
    
    

}
