package lapr.project.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.Candidatura;
import lapr.project.model.Demonstracao;
import lapr.project.model.Recurso;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.mecanismos.atribuicao.MecanismoAtribuicao1;
import lapr.project.model.mecanismos.atribuicao.MecanismoCargaFAE;
import lapr.project.model.mecanismos.atribuicao.MecanismoExpProfissional;
import lapr.project.model.mecanismos.atribuicao.MecanismoNumeroFAE;
import lapr.project.model.users.FAE;
import lapr.project.model.users.GestorExposicoes;
import lapr.project.utils.Data;
import lapr.project.utils.FileOp;

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
        new CriarCandidaturaUI(centroExposicoes.getListaExposicoes().getListaExposicoes().get(0));
        //new OrganizadorUI(centroExposicoes.getRegistoUtilizadores().checkUtilizadorByUsername("organizador"), centroExposicoes);
        //new AtribuirCandidaturaUI(centroExposicoes);

        System.out.println(centroExposicoes);

        new FileOp().writeXMLFile(centroExposicoes);
    }

    private CentroExposicoes bootStrap() {
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();

        try {
            registoUtilizadores = new FileOp().readFile(new File("newList.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

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

        Candidatura candidatura1 = new Candidatura("EfoCorp", "Rua do queijo", 916658064, 20, 100, new ArrayList<>());
        Candidatura candidatura2 = new Candidatura("GirasPontoPt", "Rua das Pegas", 936969696, 5, 20, new ArrayList<>());
        Candidatura candidatura3 = new Candidatura("SoBrincaLDA", "Parque nacional", 965555555, 100, 800, new ArrayList<>());

        exposicao1.getListaOrganizadores().addOrganizador(registoUtilizadores.checkUtilizadorByUsername("organizador"));

        exposicao1.setGestor(new GestorExposicoes(registoUtilizadores.checkUtilizadorByUsername("gestor")));
        exposicao2.setGestor(new GestorExposicoes(registoUtilizadores.checkUtilizadorByUsername("gestor")));
        exposicao3.setGestor(new GestorExposicoes(registoUtilizadores.checkUtilizadorByUsername("gestor")));

        exposicao1.addCandidatura(candidatura1);
        exposicao1.addCandidatura(candidatura2);
        exposicao1.addCandidatura(candidatura3);

        exposicao1.getListaFAE().addFAE(new FAE(registoUtilizadores.checkUtilizadorByUsername("FAE")));
        exposicao2.getListaFAE().addFAE(new FAE(registoUtilizadores.checkUtilizadorByUsername("FAE")));

        listaExposicoes.addExposicao(exposicao1);
        listaExposicoes.addExposicao(exposicao2);
        listaExposicoes.addExposicao(exposicao3);

        CentroExposicoes centroExposicoes = new CentroExposicoes(registoUtilizadores, listaExposicoes);
        
        centroExposicoes.addMecanismo(new MecanismoCargaFAE());
        centroExposicoes.addMecanismo(new MecanismoExpProfissional());
        centroExposicoes.addMecanismo(new MecanismoNumeroFAE());
        centroExposicoes.addMecanismo(new MecanismoAtribuicao1());

        Recurso r1 = new Recurso("Desc1");
        Recurso r2 = new Recurso("Desc2");

        centroExposicoes.getListaRecursos().addRecurso(r1);
        centroExposicoes.getListaRecursos().addRecurso(r2);

        return centroExposicoes;
    }

}