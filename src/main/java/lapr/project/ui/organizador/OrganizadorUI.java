/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.organizador;

import javax.swing.JOptionPane;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.Organizador;
import lapr.project.model.users.Utilizador;
import lapr.project.ui.AlterarPerfiUtilizadorUI;
import lapr.project.ui.LoginUI;

/**
 *
 * @author Marcos
 */
public class OrganizadorUI extends javax.swing.JFrame {

    /**
     * Creates new form OrganizadorUI
     */
    private Utilizador user;
    private CentroExposicoes centroExpo;

    public OrganizadorUI(Utilizador u, CentroExposicoes centroExpo) {
        this.user = u;
        this.centroExpo = centroExpo;
        
        super.setTitle("Organizador menu (" + this.user.getUsername() + ")");

        initComponents();
        for (Exposicao expo : this.centroExpo.getListaExposicoes().getListaExposicoes()) {

            Organizador o = new Organizador(user);
            if (expo.isOrganizador(o)) {
                jLstExpo1.add(expo.getTitle());
            }

        }

        super.setLocationRelativeTo(null);
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

        btnDefinirFAE = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLstExpo1 = new java.awt.List();
        btnDemoCreate = new javax.swing.JToggleButton();
        btnAtribCandid = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDefinirFAE.setText("Definir FAE");
        btnDefinirFAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDefinirFAEActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista de exposições");

        jLstExpo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLstExpo1ActionPerformed(evt);
            }
        });

        btnDemoCreate.setText("Criar demonstração");
        btnDemoCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDemoCreateActionPerformed(evt);
            }
        });

        btnAtribCandid.setText("Atribuir Candidaturas");
        btnAtribCandid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtribCandidActionPerformed(evt);
            }
        });

        jMenu1.setText("My account");

        jMenuItem1.setText("Settings");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Logout");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLstExpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDefinirFAE)
                            .addComponent(btnDemoCreate)
                            .addComponent(btnAtribCandid)))
                    .addComponent(jLabel1))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLstExpo1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDefinirFAE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDemoCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAtribCandid)))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDefinirFAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDefinirFAEActionPerformed
        String expo = jLstExpo1.getSelectedItem();
        if (expo == null) {
            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "Nenhuma exposiçao seleccionada", "Exposições", JOptionPane.ERROR_MESSAGE);
        } else if (this.centroExpo.getListaExposicoes().getExpoByName(expo) == null) {

            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "BOOOOOM", "Exposições", JOptionPane.ERROR_MESSAGE);

        } else {
            new DefinirFAEUI(this.centroExpo.getRegistoUtilizadores(), this.centroExpo.getListaExposicoes().getExpoByName(expo));
        }

    }//GEN-LAST:event_btnDefinirFAEActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AlterarPerfiUtilizadorUI(user, centroExpo.getRegistoUtilizadores());
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new LoginUI(centroExpo);
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jLstExpo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLstExpo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLstExpo1ActionPerformed

    private void btnDemoCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDemoCreateActionPerformed
        String expo = jLstExpo1.getSelectedItem();
        if (expo == null) {
            JOptionPane.showMessageDialog(OrganizadorUI.this,
                    "Nenhuma exposiçao seleccionada", "Exposições", JOptionPane.ERROR_MESSAGE);
        } else {
            new CriarDemonstracaoUI(centroExpo, this.centroExpo.getListaExposicoes().getExpoByName(expo));
        }
    }//GEN-LAST:event_btnDemoCreateActionPerformed

    private void btnAtribCandidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtribCandidActionPerformed
        new AtribuirCandidaturaUI(centroExpo);
    }//GEN-LAST:event_btnAtribCandidActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAtribCandid;
    private javax.swing.JToggleButton btnDefinirFAE;
    private javax.swing.JToggleButton btnDemoCreate;
    private javax.swing.JLabel jLabel1;
    private java.awt.List jLstExpo1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
