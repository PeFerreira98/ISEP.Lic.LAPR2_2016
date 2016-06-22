/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import lapr.project.model.Stand;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.lists.ListaAtribuicoes;
import lapr.project.model.lists.ListaCandidaturas;
import lapr.project.model.lists.ListaExposicoes;
import lapr.project.model.lists.ListaFAE;
import lapr.project.model.lists.ListaOrganizadores;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Avaliacao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.submissions.Keyword;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;

/**
 *
 * @author Pedro Ferreira
 */
public class StAXParser {

    private CentroExposicoes centroExposicoes;
    private RegistoUtilizadores registoUtilizadores;
    private ListaExposicoes listaExposicoes;
    private Utilizador user;
    private ListaOrganizadores listaOrganizadores;
    private ListaFAE listaFAE;
    private ListaCandidaturas listaCandidaturas;
    private List<Avaliacao> listaAvaliacoes;
    private ListaAtribuicoes listaAtribuicoes;
    private Atribuicao atrib;

    private boolean b_User_Reg = false;
    private boolean b_User_Type = false;
    private boolean b_cand = false;

    private boolean b_Nome = false;
    private boolean b_Email = false;
    private boolean b_Username = false;
    private boolean b_Password = false;

    private boolean b_Descricao = false; //used in stand, expo, cand

    private boolean b_titulo = false;
    private boolean b_dataInicio = false;
    private boolean b_dataFim = false;
    private boolean b_subInicio = false;
    private boolean b_subFim = false;
    private boolean b_dataLimiteConflitos = false;
    private boolean b_local = false;

    private boolean b_aceite = false;
    private boolean b_areaPetendida = false;
    private boolean b_quantidadeConvites = false;
    
    private boolean b_texto = false;
    private boolean b_conhecimentoFAE = false;
    private boolean b_adequacaoExposicao = false;
    private boolean b_adequacaoDemonstracoes = false;
    private boolean b_adequacaoConvites = false;
    private boolean b_recomendacao = false;

    //users
    private String m_Nome;
    private String m_Email;
    private String m_Username;
    private String m_Password;

    private String m_Descricao; //used in stand, expo

    //Expo
    private String m_titulo;
    private Data d_dataInicio;
    private Data d_dataFim;
    private Data d_subInicio;
    private Data d_subFim;
    private Data d_dataLimiteConflitos;
    private String m_local;

    //Cand
    private boolean b_isAceite;
    private String m_Descricao_cand;
    private double d_areaPetendida;
    private int i_quantidadeConvites;
    
    //Avaliacao
    private String m_texto;
    private int i_conhecimentoFAE;
    private int i_adequacaoExposicao;
    private int i_adequacaoDemonstracoes;
    private int i_adequacaoConvites;
    private int i_recomendacao;

    
    
    public StAXParser(CentroExposicoes e, String filePath) {
        this.centroExposicoes = e;
        XMLReader(filePath);
    }

    public StAXParser() {
        this.centroExposicoes = new CentroExposicoes();
    }

    public CentroExposicoes XMLReader(String filePath) {

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(filePath));

            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();

                        if (qName.equalsIgnoreCase("centroExposicoes")) {
                            System.out.println("Start Element : centroExposicoes");
                            this.registoUtilizadores = centroExposicoes.getRegistoUtilizadores();
                            this.listaExposicoes = centroExposicoes.getListaExposicoes();
                        }

                        if (qName.equalsIgnoreCase("registoUtilizadoresConfirmados")) {
                            System.out.println("Start Element : registoUtilizadoresConfirmados");
                            b_User_Reg = true;
                            b_User_Type = true;
                        }

                        if (qName.equalsIgnoreCase("registoUtilizadoresNaoConfirmados")) {
                            System.out.println("Start Element : registoUtilizadoresNaoConfirmados");
                            b_User_Reg = true;
                            b_User_Type = false;
                        }

                        if (qName.equalsIgnoreCase("utilizador")) {
                            System.out.println("Start Element : utilizador");
                        }

                        if (qName.equalsIgnoreCase("nome")) {
                            b_Nome = true;
                        }

                        if (qName.equalsIgnoreCase("email")) {
                            b_Email = true;
                        }

                        if (qName.equalsIgnoreCase("username")) {
                            b_Username = true;
                        }

                        if (qName.equalsIgnoreCase("password")) {
                            b_Password = true;
                        }

                        if (qName.equalsIgnoreCase("stands")) {
                            System.out.println("Start Element : stands");
                        }

                        if (qName.equalsIgnoreCase("stand")) {
                            System.out.println("Start Element : stand");
                        }

                        if (qName.equalsIgnoreCase("descricao")) {
                            b_Descricao = true;
                        }

                        if (qName.equalsIgnoreCase("registoExposicoes")) {
                            System.out.println("Start Element : registoExposicoes");
                            b_User_Reg = false;
                        }

                        if (qName.equalsIgnoreCase("exposicao")) {
                            System.out.println("Start Element : exposicao");
                        }

                        if (qName.equalsIgnoreCase("titulo")) {
                            b_titulo = true;
                        }

                        if (qName.equalsIgnoreCase("dataInicio")) {
                            b_dataInicio = true;
                        }

                        if (qName.equalsIgnoreCase("dataFim")) {
                            b_dataFim = true;
                        }

                        if (qName.equalsIgnoreCase("subInicio")) {
                            b_subInicio = true;
                        }

                        if (qName.equalsIgnoreCase("subFim")) {
                            b_subFim = true;
                        }

                        if (qName.equalsIgnoreCase("dataLimiteConflitos")) {
                            b_dataLimiteConflitos = true;
                        }

                        if (qName.equalsIgnoreCase("local")) {
                            b_local = true;
                        }

                        if (qName.equalsIgnoreCase("registoOrganizadores")) {
                            System.out.println("Start Element : registoOrganizadores");
                            this.listaOrganizadores = new ListaOrganizadores();
                        }

                        if (qName.equalsIgnoreCase("organizador")) {
                            System.out.println("Start Element : organizador");
                        }

                        if (qName.equalsIgnoreCase("registoFAEs")) {
                            System.out.println("Start Element : registoFAEs");
                            this.listaFAE = new ListaFAE();
                        }

                        if (qName.equalsIgnoreCase("fae")) {
                            System.out.println("Start Element : fae");
                        }

                        if (qName.equalsIgnoreCase("registoCandidaturas")) {
                            System.out.println("Start Element : registoCandidaturas");
                            this.listaCandidaturas = new ListaCandidaturas();
                        }

                        if (qName.equalsIgnoreCase("candidatura")) {
                            System.out.println("Start Element : candidatura");
                            b_cand = true;
                        }
                        
                        if (qName.equalsIgnoreCase("aceite")) {
                            b_aceite = true;
                        }
                        
                        if (qName.equalsIgnoreCase("areaPretendida")) {
                            b_areaPetendida = true;
                        }
                        
                        if (qName.equalsIgnoreCase("quantidadeConvites")) {
                            b_quantidadeConvites = true;
                        }

                        if (qName.equalsIgnoreCase("avaliacoes")) {
                            System.out.println("Start Element : avaliacoes");
                            this.listaAvaliacoes = new ArrayList<>();
                        }

                        if (qName.equalsIgnoreCase("avaliacao")) {
                            System.out.println("Start Element : avaliacao");
                        }
                        
                        if (qName.equalsIgnoreCase("texto")) {
                            b_texto = true;
                        }
                        
                        if (qName.equalsIgnoreCase("conhecimentoFAE")) {
                            b_conhecimentoFAE = true;
                        }
                        
                        if (qName.equalsIgnoreCase("adequacaoExposicao")) {
                            b_adequacaoExposicao = true;
                        }
                        
                        if (qName.equalsIgnoreCase("adequacaoDemonstracoes")) {
                            b_adequacaoDemonstracoes = true;
                        }
                        
                        if (qName.equalsIgnoreCase("adequacaoConvites")) {
                            b_adequacaoConvites = true;
                        }
                        
                        if (qName.equalsIgnoreCase("recomendacao")) {
                            b_recomendacao = true;
                        }
                        
                        if (qName.equalsIgnoreCase("registoAtribuicoes")) {
                            System.out.println("Start Element : registoAtribuicoes");
                            this.listaAtribuicoes = new ListaAtribuicoes();
                        }

                        if (qName.equalsIgnoreCase("atribuicao")) {
                            System.out.println("Start Element : atribuicao");
                        }

                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();

                        if (b_Nome) {
                            System.out.println("\tnome: " + characters.getData());
                            m_Nome = characters.getData();
                            b_Nome = false;
                        }

                        if (b_Email) {
                            System.out.println("\temail: " + characters.getData());
                            m_Email = characters.getData();
                            b_Email = false;
                        }

                        if (b_Username) {
                            System.out.println("\tusername: " + characters.getData());
                            m_Username = characters.getData();
                            b_Username = false;
                        }

                        if (b_Password) {
                            System.out.println("\tpassword: " + characters.getData());
                            m_Password = characters.getData();
                            b_Password = false;
                        }

                        if (b_Descricao) {
                            System.out.println("\tdescricao: " + characters.getData());
                            if (b_cand) {
                                m_Descricao_cand = characters.getData();
                            } else {
                                m_Descricao = characters.getData();
                            }
                            b_Descricao = false;
                        }

                        if (b_titulo) {
                            System.out.println("\ttitulo: " + characters.getData());
                            m_titulo = characters.getData();
                            b_titulo = false;
                        }

                        if (b_dataInicio) {
                            System.out.println("\tdataInicio: " + characters.getData());
                            d_dataInicio = parseStringtoData(characters.getData());
                            b_dataInicio = false;
                        }

                        if (b_dataFim) {
                            System.out.println("\tdataFim: " + characters.getData());
                            d_dataFim = parseStringtoData(characters.getData());
                            b_dataFim = false;
                        }

                        if (b_subInicio) {
                            System.out.println("\tsubInicio: " + characters.getData());
                            d_subInicio = parseStringtoData(characters.getData());
                            b_subInicio = false;
                        }

                        if (b_subFim) {
                            System.out.println("\tsubFim: " + characters.getData());
                            d_subFim = parseStringtoData(characters.getData());
                            b_subFim = false;
                        }

                        if (b_dataLimiteConflitos) {
                            System.out.println("\tdataLimiteConflitos: " + characters.getData());
                            d_dataLimiteConflitos = parseStringtoData(characters.getData());
                            b_dataLimiteConflitos = false;
                        }

                        if (b_local) {
                            System.out.println("\tlocal: " + characters.getData());
                            m_local = characters.getData();
                            b_local = false;
                        }
                        
                        if (b_aceite) {
                            System.out.println("\taceite: " + characters.getData());
                            b_isAceite = "true".equalsIgnoreCase(characters.getData());
                            b_aceite = false;
                        }

                        if (b_areaPetendida) {
                            System.out.println("\tareaPetendida: " + characters.getData());
                            d_areaPetendida = Double.parseDouble(characters.getData());
                            b_areaPetendida = false;
                        }

                        if (b_quantidadeConvites) {
                            System.out.println("\tquantidadeConvites: " + characters.getData());
                            i_quantidadeConvites = Integer.parseInt(characters.getData());
                            b_quantidadeConvites = false;
                        }
                        
                        if (b_texto) {
                            System.out.println("\ttexto: " + characters.getData());
                            m_texto = characters.getData();
                            b_texto = false;
                        }
                        
                        if (b_conhecimentoFAE) {
                            System.out.println("\tconhecimentoFAE: " + characters.getData());
                            i_conhecimentoFAE = Integer.parseInt(characters.getData());
                            b_conhecimentoFAE = false;
                        }
                        
                        if (b_adequacaoExposicao) {
                            System.out.println("\tadequacaoExposicao: " + characters.getData());
                            i_adequacaoExposicao = Integer.parseInt(characters.getData());
                            b_adequacaoExposicao = false;
                        }
                        
                        if (b_adequacaoDemonstracoes) {
                            System.out.println("\tadequacaoDemonstracoes: " + characters.getData());
                            i_adequacaoDemonstracoes = Integer.parseInt(characters.getData());
                            b_adequacaoDemonstracoes = false;
                        }
                        
                        if (b_adequacaoConvites) {
                            System.out.println("\tadequacaoConvites: " + characters.getData());
                            i_adequacaoConvites = Integer.parseInt(characters.getData());
                            b_adequacaoConvites = false;
                        }
                        
                        if (b_recomendacao) {
                            System.out.println("\trecomendacao: " + characters.getData());
                            i_recomendacao = Integer.parseInt(characters.getData());
                            b_recomendacao = false;
                        }

                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        String endName = endElement.getName().getLocalPart();

                        if (endName.equalsIgnoreCase("atribuicao")) {
                            this.atrib = new Atribuicao(this.listaFAE.getFAE(this.user.getUsername()));
                            if (!b_cand) {
                                this.listaAtribuicoes.addAtribuicao(atrib);
                            }
                            System.out.println("End Element : atribuicao" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoAtribuicoes")) {
                            System.out.println("End Element : registoAtribuicoes" + "\n");
                        }

                        if (endName.equalsIgnoreCase("avaliacao")) {
                            Avaliacao aval = new Avaliacao(m_texto, i_conhecimentoFAE, i_adequacaoExposicao, i_adequacaoDemonstracoes, i_adequacaoConvites, i_recomendacao, atrib);
                            this.listaAvaliacoes.add(aval);
                            System.out.println("End Element : avaliacao");
                        }

                        if (endName.equalsIgnoreCase("avaliacoes")) {
                            System.out.println("End Element : avaliacoes");
                        }

                        if (endName.equalsIgnoreCase("candidatura")) {
                            Candidatura cand = new Candidatura(m_Descricao_cand, m_Descricao_cand, 911111111, d_areaPetendida, i_quantidadeConvites, new ArrayList<Keyword>());

                            for (Avaliacao aval : this.listaAvaliacoes) {
                                cand.addAvaliacao(aval);
                            }

                            cand.setEmAvaliacao();
                            cand.setAvaliada();
                            if (b_isAceite) {
                                cand.setAceite();
                            } else {
                                cand.setRejeitada();
                            }

                            listaCandidaturas.addCandidatura(cand);
                            b_cand = false;
                            
//                            System.out.println(cand.getInfo());
                            System.out.println("End Element : candidatura" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoCandidaturas")) {
                            System.out.println("End Element : registoCandidaturas" + "\n");
                        }

                        if (endName.equalsIgnoreCase("fae")) {
                            this.listaFAE.addFAE(new FAE(this.registoUtilizadores.checkUtilizadorByUsername(m_Username)));
                            System.out.println("End Element : fae" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoFAEs")) {
                            System.out.println("End Element : registoFAEs" + "\n");
                        }

                        if (endName.equalsIgnoreCase("organizador")) {
                            this.listaOrganizadores.addOrganizador(this.registoUtilizadores.checkUtilizadorByUsername(m_Username));
                            System.out.println("End Element : organizador" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoOrganizadores")) {
                            System.out.println("End Element : registoOrganizadores" + "\n");
                        }

                        if (endName.equalsIgnoreCase("exposicao")) {
                            Exposicao expo = new Exposicao(m_titulo, m_Descricao, d_dataInicio, d_dataFim, d_subInicio, d_subFim, d_dataLimiteConflitos, m_local);

                            for (Organizador org : this.listaOrganizadores.getLstOrganizadores()) {
                                expo.getListaOrganizadores().addOrganizador(org.getUtilizador());
                            }

                            for (FAE fae : this.listaFAE.getListaFAE()) {
                                expo.getListaFAE().addFAE(fae);
                            }
                            
                            for (Candidatura can : this.listaCandidaturas.getListaCandidaturas()) {
                                expo.addCandidatura(can);
                            }
                            
                            for (Atribuicao a : this.listaAtribuicoes.getListaAtribuicoes()) {
                                expo.getListaAtribuicoes().addAtribuicao(a);
                            }

//                            System.out.println(expo.getInfo());
                            this.listaExposicoes.addExposicao(expo);
                            System.out.println("End Element : exposicao" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoExposicoes")) {
                            System.out.println("End Element : registoExposicoes" + "\n");
                        }

                        if (endName.equalsIgnoreCase("stand")) {
                            this.centroExposicoes.addStand(new Stand(m_Descricao));
                            System.out.println("End Element : stand" + "\n");
                        }

                        if (endName.equalsIgnoreCase("stands")) {
                            System.out.println("End Element : stands" + "\n");
                        }

                        if (endName.equalsIgnoreCase("utilizador")) {
                            this.user = new Utilizador(m_Nome, m_Username, m_Password, m_Email);
                            if (b_User_Reg) {
                                this.registoUtilizadores.addUtilizadorNaoRegistado(this.user);
                                if (b_User_Type) {
                                    this.registoUtilizadores.registarUtilizador(this.user);
                                }
                            }
                            System.out.println("End Element : utilizador" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoUtilizadoresNaoConfirmados")) {
                            System.out.println("End Element : registoUtilizadoresNaoConfirmados" + "\n");
                        }

                        if (endName.equalsIgnoreCase("registoUtilizadoresConfirmados")) {
                            System.out.println("End Element : registoUtilizadoresConfirmados" + "\n");
                        }

                        if (endName.equalsIgnoreCase("centroExposicoes")) {
                            System.out.println("End Element : centroExposicoes" + "\n");
                        }

                        break;
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
        }
        return this.centroExposicoes;
    }

    private Data parseStringtoData(String s) {

        System.out.println(s);

        try {
            Calendar cl = Calendar.getInstance();
            cl.setTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(s));
            return new Data(cl.get(Calendar.YEAR), cl.get(Calendar.MONTH) + 1, cl.get(Calendar.DAY_OF_MONTH));

        } catch (ParseException ex) {
            Logger.getLogger(StAXParser.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

}
