package lapr.project.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.Data;
import lapr.project.utils.ReadWriteTxtFile;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final CentroExposicoes centroExposicoes = new Main().bootStrap();

        new LoginUI(centroExposicoes);
        //Janelas ainda não conectadas (apenas para testes)
        
        //new DefinirFAEUI(centroExposicoes.getRegistoUtilizadores(), centroExposicoes.getListaExposicoes().getListaExposicoes().get(0));
        //new CriarCandidaturaUI(centroExposicoes.getListaExposicoes().getListaExposicoes().get(0));
        
        System.out.println(centroExposicoes);
    }

    private CentroExposicoes bootStrap() {
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();

        try {
            registoUtilizadores = new ReadWriteTxtFile().readFile(new File("userList.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File userlist not found");
        }

        Utilizador utilizador1 = new Utilizador("Dummy2", "representante", "representante", "representante@domain.pt", "REPRESENTANTE");
        Utilizador utilizador2 = new Utilizador("Dummy3", "FAE", "FAE", "fae@domain.pt", "FAE");
        Utilizador utilizador3 = new Utilizador("Dummy4", "gestor", "gestor", "gestor@domain.pt", "GESTOR");
        Utilizador utilizador4 = new Utilizador("Dummy5", "organizador", "organizador", "organizador@domain.pt", "ORGANIZADOR");

        registoUtilizadores.addUtilizadorNaoRegistado(utilizador1);
        registoUtilizadores.addUtilizadorNaoRegistado(utilizador2);
        registoUtilizadores.addUtilizadorNaoRegistado(utilizador3);
        registoUtilizadores.addUtilizadorNaoRegistado(utilizador4);

        registoUtilizadores.registarUtilizador(utilizador1);
        registoUtilizadores.registarUtilizador(utilizador2);
        registoUtilizadores.registarUtilizador(utilizador3);
        registoUtilizadores.registarUtilizador(utilizador4);

        final ListaExposicoes listaExposicoes = new ListaExposicoes();

        Exposicao exposicao1 = new Exposicao("exposicao1", "descricao1", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        Exposicao exposicao2 = new Exposicao("exposicao2", "descricao2", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");
        Exposicao exposicao3 = new Exposicao("exposicao3", "descricao3", new Data(2016, 5, 31), new Data(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House");

        Demonstracao demonstracao1 = new Demonstracao("demo1");
        Demonstracao demonstracao2 = new Demonstracao("demo2");
        Demonstracao demonstracao3 = new Demonstracao("demo3");
        
        exposicao1.getListaDemonstracoes().addDemonstracao(demonstracao1);
        exposicao1.getListaDemonstracoes().addDemonstracao(demonstracao2);
        exposicao1.getListaDemonstracoes().addDemonstracao(demonstracao3);
        
        exposicao2.getListaDemonstracoes().addDemonstracao(demonstracao1);
        exposicao2.getListaDemonstracoes().addDemonstracao(demonstracao2);
        
        exposicao3.getListaDemonstracoes().addDemonstracao(demonstracao1);
        
        Candidatura candidatura1 = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100);
        Candidatura candidatura2 = new Candidatura("GirasPontoPt", "Rua das Pegas", 936969696, 5, 20);
        Candidatura candidatura3 = new Candidatura("SoBrincaLDA", "Parque nacional", 965555555, 100, 800);
       
        listaExposicoes.addExposicao(exposicao1);
        listaExposicoes.addExposicao(exposicao2);
        listaExposicoes.addExposicao(exposicao3);

        CentroExposicoes centroExposicoes = new CentroExposicoes();

        return centroExposicoes;
    }

}
