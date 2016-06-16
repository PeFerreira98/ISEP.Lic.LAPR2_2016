/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import lapr.project.ui.fae.FaeUI;
import lapr.project.ui.gestor.GestorExposicoesUI;
import lapr.project.ui.organizador.OrganizadorUI;
import lapr.project.ui.representante.RepresentanteUI;
import javax.swing.JOptionPane;
import lapr.project.controller.LoginController;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.FileOp;

/**
 *
 * @author Marcos
 */
public class LoginUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginUI
     */
    private LoginController controller;
    private CentroExposicoes centroExposicoes;
    private Utilizador loginUser;

    public LoginUI(CentroExposicoes centroExposicoes) {
        this.centroExposicoes = centroExposicoes;
        this.controller = new LoginController(centroExposicoes.getRegistoUtilizadores());

        super.setTitle("Login Window");
        initComponents();
        setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private boolean loginVerifications() {
        final String username, password;

        username = jTextField1.getText();
        password = jTextField2.getText();

        Utilizador utilizador = this.controller.getUtilizador(username);

        if (utilizador != null) {
            if (utilizador.validatePassword(password)) {
                if (utilizador.isRegistado()) {

                    this.loginUser = utilizador;
                    return true;

                } else {
                    JOptionPane.showMessageDialog(LoginUI.this,
                            "Este Utilizador ainda nao foi aceite pelo o Gestor", "Login", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(LoginUI.this,
                        "Password Errada!", "Login", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(LoginUI.this,
                    "Utilizador Inexistente!", "Login", JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButtonLogRep = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSignUp = new javax.swing.JButton();
        jButtonLogOrg = new javax.swing.JButton();
        jButtonLogFAE = new javax.swing.JButton();
        jButtonLogGest = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemExportXML = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonLogRep.setText("Login as Representante");
        jButtonLogRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogRepActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jSignUp.setText("Sign up");
        jSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignUpActionPerformed(evt);
            }
        });

        jButtonLogOrg.setText("Login as Organizador");
        jButtonLogOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogOrgActionPerformed(evt);
            }
        });

        jButtonLogFAE.setText("Login as FAE");
        jButtonLogFAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogFAEActionPerformed(evt);
            }
        });

        jButtonLogGest.setText("Login as Gestor");
        jButtonLogGest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogGestActionPerformed(evt);
            }
        });

        jMenu3.setText("File");

        jMenuItemExportXML.setText("Export to XML");
        jMenuItemExportXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportXMLActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemExportXML);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addComponent(jButtonLogFAE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogGest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogOrg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogRep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jButtonLogFAE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogGest)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogOrg)
                .addGap(18, 18, 18)
                .addComponent(jButtonLogRep)
                .addGap(18, 18, 18)
                .addComponent(jSignUp)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogRepActionPerformed
        if (loginVerifications()) {
            new RepresentanteUI(this.loginUser, this.centroExposicoes);
            dispose();
            //TODO: Add Representante UI
            JOptionPane.showMessageDialog(LoginUI.this,
                    "RepresentanteUI não implementado!", "Login", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLogRepActionPerformed

    private void jSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignUpActionPerformed
        new CriacaoUtilizadorUI(this.centroExposicoes.getRegistoUtilizadores());
    }//GEN-LAST:event_jSignUpActionPerformed

    private void jButtonLogOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogOrgActionPerformed
        if (loginVerifications()) {
            new OrganizadorUI(loginUser, centroExposicoes);
            dispose();
        }
    }//GEN-LAST:event_jButtonLogOrgActionPerformed

    private void jButtonLogFAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogFAEActionPerformed
        if (loginVerifications()) {
            new FaeUI(loginUser, centroExposicoes);
            dispose();
        }
    }//GEN-LAST:event_jButtonLogFAEActionPerformed

    private void jButtonLogGestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogGestActionPerformed
        if (loginVerifications()) {
            new GestorExposicoesUI(loginUser, centroExposicoes);
            dispose();
        }
    }//GEN-LAST:event_jButtonLogGestActionPerformed

    private void jMenuItemExportXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportXMLActionPerformed
        // TODO filechooser
        new FileOp().writeXMLFile(centroExposicoes);
    }//GEN-LAST:event_jMenuItemExportXMLActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogFAE;
    private javax.swing.JButton jButtonLogGest;
    private javax.swing.JButton jButtonLogOrg;
    private javax.swing.JButton jButtonLogRep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemExportXML;
    private javax.swing.JButton jSignUp;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
