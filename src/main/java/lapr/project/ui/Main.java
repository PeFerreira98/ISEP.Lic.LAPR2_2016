package lapr.project.ui;

import java.util.ArrayList;
import lapr.project.model.CalculatorExample;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 * @author Nuno Bettencourt <nmb@isep.ipp.pt> on 24/05/16.
 */
class Main {

    private CentroExposicoes centroExposicoes;

    /**
     * Private constructor to hide implicit public one.
     */
    private Main() {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CalculatorExample calculatorExample = new CalculatorExample();
        System.out.println(calculatorExample.sum(3, 5));

        new Main().bootStrap();
        
        //TODO: Check older projects and associate CentroExposições with Login (UserList)
        
        new LoginUI();
    }

    private boolean bootStrap() {
        ListaUtilizadores listaUtilizadores = new ListaUtilizadores();
        ListaExposicoes listaExposicoes = new ListaExposicoes();
        
        Utilizador utilizador = new Utilizador("Dummy", "user@domain.pt", "User", "User");
        listaUtilizadores.addUtilizador(utilizador);
        
        this.centroExposicoes = new CentroExposicoes(listaUtilizadores, listaExposicoes);

        return true;
    }

}
