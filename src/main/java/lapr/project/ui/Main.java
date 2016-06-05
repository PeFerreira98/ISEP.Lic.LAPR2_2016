package lapr.project.ui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        Exposicao exposicao1 = new Exposicao("exposicao1", "descricao1", new Date(2016, 5, 31), new Date(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House", new ListaOrganizadores(), new ListaFAE(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Exposicao exposicao2 = new Exposicao("exposicao1", "descricao1", new Date(2016, 5, 31), new Date(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House", new ListaOrganizadores(), new ListaFAE(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        Exposicao exposicao3 = new Exposicao("exposicao1", "descricao1", new Date(2016, 5, 31), new Date(2016, 7, 29), new Data(2016, 6, 31), new Data(2016, 5, 31), "My House", new ListaOrganizadores(), new ListaFAE(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        listaExposicoes.addExposicao(exposicao1);
        listaExposicoes.addExposicao(exposicao2);
        listaExposicoes.addExposicao(exposicao3);

        CentroExposicoes centroExposicoes = new CentroExposicoes();

        return centroExposicoes;
    }

}
