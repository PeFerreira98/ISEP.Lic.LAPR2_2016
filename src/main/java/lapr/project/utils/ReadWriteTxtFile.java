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
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author zero_
 */
public class ReadWriteTxtFile {

    public ReadWriteTxtFile() {

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
            File file = new File("userList.txt");

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("---");
            bw.newLine();
            bw.write("status:");
            bw.newLine();
            bw.write(estado);
            bw.newLine();
            bw.write("nome:");
            bw.newLine();
            bw.write(nome);
            bw.newLine();
            bw.write("email:");
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write("username:");
            bw.newLine();
            bw.write(username);
            bw.newLine();
            bw.write("password:");
            bw.newLine();
            bw.write(password);
            bw.newLine();
            bw.write("type:");
            bw.newLine();
            bw.write(tipoUtilizador);
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
            } else if (linha.equalsIgnoreCase("type:")) {
                userType = brE.readLine();
                flag = 0;
            }
            if (flag == 0) {
                Utilizador utilizador = new Utilizador(nome, username, password, email, userType);

                if (status.equalsIgnoreCase("PENDING")) {
                    registoUtilizadores.addUtilizadorNaoRegistado(utilizador);
                } else {
                    registoUtilizadores.addUtilizadorNaoRegistado(utilizador);
                    registoUtilizadores.registarUtilizador(utilizador);
                }
            }
        }
        return registoUtilizadores;
    }
}
