/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller.organizador;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;

/**
 *
 * @author Sara Silva
 */
public class DefinirDemoEfetivasController {

    private final CentroExposicoes centroExp;
    private Exposicao exposicao;
    private Demonstracao demonstracao;
    private Data date;
    private Utilizador utilizador;

    public DefinirDemoEfetivasController(CentroExposicoes ce) {
        this.centroExp = ce;
    }

    public List<Exposicao> getListaExposicoes() {
        return centroExp.getListaExposicoes().getListaExposicoes();
    }

    public List<Demonstracao> getListaDemonstracoes() {
        List<Demonstracao> demos = exposicao.getListaDemonstracoes().getListaDemonstracoes();
        List<Demonstracao> lista= new ArrayList<>();
        for(Demonstracao demo: demos){
            if(demo.getData()==null){
                lista.add(demo);
            }
        }
        return lista;
    }

    public void setDemonstracao(Demonstracao demonstracao) {
        this.demonstracao = demonstracao;
    }

    public void setDemonstracaoEfetiva() {
        demonstracao.setDemonstracaoEfetiva(true);
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicao = exposicao;
    }

    public void setData(String data) {
        date = convertStringToData(data);
        demonstracao.setData(date);
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public Data getDate() {
        return date;
    }

    public Data convertStringToData(String data) {
        final Data d;

        String[] aux = data.split("-");
        int dia = Integer.parseInt(aux[0]);
        int mes = Integer.parseInt(aux[1]);
        int ano = Integer.parseInt(aux[2]);

        d = new Data(ano, mes, dia);

        return d;
    }
    
    public String getInfo(){
        return String.format("Código: %s%nDesignação: %s",demonstracao.getCod(),demonstracao.getDesignacao());
    }

}
