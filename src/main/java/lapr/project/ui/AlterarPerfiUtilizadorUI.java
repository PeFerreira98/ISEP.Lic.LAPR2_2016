/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lapr.project.controller.AlterarPerfilUtilizadorController;
import lapr.project.model.lists.RegistoUtilizadores;
import lapr.project.model.users.Utilizador;
import lapr.project.utils.FileOp;

/**
 *
 * @author Marcos
 */
public class AlterarPerfiUtilizadorUI extends javax.swing.JFrame {

    /**
     * Creates new form AlterarPerfiUtilizadorUI
     */
    private AlterarPerfilUtilizadorController controller;
    private RegistoUtilizadores rUsers;
    private Utilizador user;

    public AlterarPerfiUtilizadorUI(Utilizador user, RegistoUtilizadores rUsers) {
        this.user = user;
        this.controller = new AlterarPerfilUtilizadorController(user, rUsers);
        this.rUsers = rUsers;

        super.setTitle("Settings");
        initComponents();
        jTxtName.setText(this.user.getNome());
        jTxtEmail.setText(this.user.getEmail());
        jLabel5.setText(this.user.getUsername());
        setLocationRelativeTo(null);
        super.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTxtNewpw = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jTxtName = new javax.swing.JTextField();
        jTxtOldpw = new javax.swing.JTextField();
        btnNome = new javax.swing.JToggleButton();
        btnEmail = new javax.swing.JToggleButton();
        btnPasswrod = new javax.swing.JToggleButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Name:");

        jLabel2.setText("email:");

        jLabel3.setText("Old password:");

        jLabel4.setText("New password:");

        jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmailActionPerformed(evt);
            }
        });

        jTxtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNameActionPerformed(evt);
            }
        });

        btnNome.setText("Alterar nome");
        btnNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNomeActionPerformed(evt);
            }
        });

        btnEmail.setText("Alterar email");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        btnPasswrod.setText("Alterar password");
        btnPasswrod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasswrodActionPerformed(evt);
            }
        });

        jToggleButton1.setText("ok");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("jLabel5");

        jLabel6.setText("user:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtNewpw, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPasswrod))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtOldpw, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(337, 337, 337)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtOldpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtNewpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPasswrod))
                .addGap(20, 20, 20)
                .addComponent(jToggleButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNameActionPerformed
        
    }//GEN-LAST:event_jTxtNameActionPerformed

    private void jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmailActionPerformed
        
    }//GEN-LAST:event_jTxtEmailActionPerformed

    private void btnNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNomeActionPerformed
        if(jTxtName.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Este campo nao pode estar vazio", "Settings", JOptionPane.ERROR_MESSAGE);
        }
        this.controller.setName(jTxtName.getText());
        JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Nome Alterado com sucesso", "Settings", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_btnNomeActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
        if(jTxtEmail.getText().equalsIgnoreCase("")){
             JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Este campo nao pode estar vazio!", "Settings", JOptionPane.ERROR_MESSAGE);
        }else if(this.controller.setEmail(jTxtEmail.getText())){
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Email alterado!", "Settings", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Email ja registado!", "Settings", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnPasswrodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasswrodActionPerformed
        if(jTxtOldpw.getText().equalsIgnoreCase("") || !jTxtOldpw.getText().equalsIgnoreCase(this.user.getPassword())){
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Password errada!", "Settings", JOptionPane.ERROR_MESSAGE);
        }else if (jTxtOldpw.getText().equalsIgnoreCase(this.user.getPassword()) && jTxtNewpw.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Insira uma nova password!", "Settings", JOptionPane.ERROR_MESSAGE);            
        }else if (this.controller.confirmPassword(jTxtOldpw.getText())){
            this.controller.setPassword(jTxtNewpw.getText());
            JOptionPane.showMessageDialog(AlterarPerfiUtilizadorUI.this,
                                    "Password Alterada com sucesso!", "Settings", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnPasswrodActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        PrintWriter writer;
        try {
            writer = new PrintWriter("newList.txt");
            writer.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Utilizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(Utilizador u : rUsers.getListaUtilizadoresNaoRegistados()){
            System.out.println("SAIR..." + u.getUsername());
            FileOp f = new FileOp();
            f.writeFile(u);
        }
        for(Utilizador u : rUsers.getListaUtilizadoresRegistados()){
            System.out.println("SAIR..." + u.getUsername());
            FileOp f = new FileOp();
            f.writeFile(u);
        }
        dispose();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEmail;
    private javax.swing.JToggleButton btnNome;
    private javax.swing.JToggleButton btnPasswrod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtName;
    private javax.swing.JTextField jTxtNewpw;
    private javax.swing.JTextField jTxtOldpw;
    // End of variables declaration//GEN-END:variables
}
