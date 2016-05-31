package lapr.project.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lapr.project.model.CalculatorExample;
import lapr.project.model.TipoUtilizador;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
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

        ListaUtilizadores lstU = new ListaUtilizadores();
        ListaExposicoes lstE = new ListaExposicoes();

        List<Utilizador> lstUsers = null;
        List<Exposicao> lstExpo = new ArrayList<>();
        Exposicao expo1 = new Exposicao("expo1", "Expo desc1");
        lstExpo.add(expo1);

        try {
            lstUsers = readFile(new File("userList.txt"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        lstU.setUsersList(lstUsers);
        lstE.setListaExposicoes(lstExpo);

        CentroExposicoes ce = new CentroExposicoes(lstU, lstE);
//        new Main().bootStrap();

        new LoginUI(ce);
    }

    private boolean bootStrap() {
//        ListaUtilizadores listaUtilizadores = new ListaUtilizadores();
//        ListaExposicoes listaExposicoes = new ListaExposicoes();
//        
//        Utilizador utilizador = new Utilizador("Dummy", "user@domain.pt", "User", "User");
//        listaUtilizadores.addUtilizador(utilizador);
//        
//        this.centroExposicoes = new CentroExposicoes(listaUtilizadores, listaExposicoes);
//
        return true;
    }

    public static List<Utilizador> readFile(File file) throws FileNotFoundException, IOException {
        List<Utilizador> lstAux = new ArrayList<>();
        String nome = null, email = null, username = null, password = null, userType = null, status = null;

        FileReader frE;
        frE = new FileReader(file);
        BufferedReader brE = new BufferedReader(frE);
        int flag = 0;

        while (brE.ready()) {

            String linha = brE.readLine();
            if (linha.equalsIgnoreCase("---")) {
                flag = 1;
            }

            if (linha.equalsIgnoreCase("status:")) {
                status = brE.readLine();
            }
            if (linha.equalsIgnoreCase("nome:")) {
                nome = brE.readLine();
            } else if (linha.equalsIgnoreCase("email:")) {
                email = brE.readLine();
            } else if (linha.equalsIgnoreCase("username:")) {
                username = brE.readLine();
            } else if (linha.equalsIgnoreCase("password:")) {
                password = brE.readLine();
                flag = 0;
            } else if (linha.equalsIgnoreCase("type:")) {
                userType = brE.readLine();
                flag = 0;
            }
            if (flag == 0) {
                Utilizador u = new Utilizador(nome, username, password, email, status, userType);
                lstAux.add(u);
            }
        }
        return lstAux;
    }

}
