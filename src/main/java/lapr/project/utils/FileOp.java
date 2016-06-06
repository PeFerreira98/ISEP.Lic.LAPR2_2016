/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class FileOp {

    public FileOp() {

    }

    public void writeFile(Utilizador utilizador) {
        final String nome = utilizador.getNome();
        final String email = utilizador.getEmail();
        final String username = utilizador.getUsername();
        final String password = utilizador.getPassword();
        final String tipoUtilizador = utilizador.getTipoUtilizador();

        String estado = "PENDING";
        if (utilizador.isRegistado()) {
            estado = "REGISTERED";
        }

        try {
            File file = new File("newList.txt");

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(estado + "," + nome + "," + email + "," + username + "," + password + "," + tipoUtilizador);
            bw.newLine();
            bw.close();

        } catch (IOException ex) {
            System.out.println("IOException >> No file found/created");
        }
    }

    public RegistoUtilizadores readFile(File file) throws FileNotFoundException, IOException {
        RegistoUtilizadores registoUtilizadores = new RegistoUtilizadores();

        String nome = null, email = null, username = null, password = null, userType = null, status = null;

        FileReader frE;
        frE = new FileReader(file);
        BufferedReader brE = new BufferedReader(frE);
        int flag = 0;

        while (brE.ready()) {

            String linha = brE.readLine();
            if (!linha.equals("")) {
                String[] aux = linha.split(",");

                Utilizador user = new Utilizador(aux[1], aux[3], aux[4], aux[2], aux[5]);
                if (registoUtilizadores.checkUtilizadorByUsername(aux[3]) == null) {
                    if (aux[0].equalsIgnoreCase("PENDING")) {
                        registoUtilizadores.addUtilizadorNaoRegistadoByFicheiro(user);
                    } else {
                        registoUtilizadores.addUtilizadorNaoRegistadoByFicheiro(user);
                        registoUtilizadores.registarUtilizador(user);
                    }
                }
            }
        }
        return registoUtilizadores;
    }

    public void writeXMLFile(CentroExposicoes centroExposicoes) {
        final String centroExposicoesString = centroExposicoes.exportContentToString();

        try {
            File file = new File("CentroExposicoesXML.xml");

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(centroExposicoesString);
            bw.close();
        } catch (IOException e) {
            System.out.println("IOException >> No file found/created");
        }
    }
}
