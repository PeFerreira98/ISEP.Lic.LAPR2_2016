/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.fae;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.model.submissions.Atribuicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.users.FAE;
import lapr.project.model.users.Utilizador;
import lapr.project.ui.AlterarPerfiUtilizadorUI;
import lapr.project.ui.CandidaturaInfoUI;
import lapr.project.ui.LoginUI;

/**
 *
 * @author Marcos
 */
public class FaeUI extends javax.swing.JFrame {

    /**
     * Creates new form FaeUI
     */
    private FAE fae;
    private Utilizador utilizador;
    private CentroExposicoes centroExpo;
    private List<Atribuicao> listaAtribuicao;

    public FaeUI(Utilizador utilizador, CentroExposicoes centroExposicoes) {
        this.centroExpo = centroExposicoes;
        this.utilizador = utilizador;
        this.listaAtribuicao = new ArrayList<>();
        this.fae = new FAE(utilizador);

        super.setTitle("FAE Menu (" + utilizador.getUsername() + ")");

        initComponents();
        inicializarLista();

        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void inicializarLista() {
        final List<Candidatura> listaCandidaturas = getCandidaturasByFAE(this.utilizador);

        if (listaCandidaturas.isEmpty()) {
            this.jLstCandidaturas.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem candidaturas");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return listaCandidaturas.size();
            }

            @Override
            public Object getElementAt(int i) {
                return listaCandidaturas.get(i);
            }
        };

        this.jLstCandidaturas.setModel(listModel);
        this.jLstCandidaturas.setCellRenderer(new CellRenderer());
    }

    private class CellRenderer extends JLabel implements ListCellRenderer<Candidatura> {

        public CellRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Candidatura> list, Candidatura candidatura, int index, boolean isSelected, boolean cellHasFocus) {
            setText(candidatura.getNomeEmpresa());

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            return this;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jLstCandidaturas = new javax.swing.JList<Candidatura>();
        btnAvaliar = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        btnCandidaturaInfo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuSettings = new javax.swing.JMenuItem();
        jMenuLogout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jLstCandidaturas);

        btnAvaliar.setText("Avaliar");
        btnAvaliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvaliarActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista de candidaturas");

        btnCandidaturaInfo.setText("Ver info");
        btnCandidaturaInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandidaturaInfoActionPerformed(evt);
            }
        });

        jButton1.setText("Actualizar Conflitos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("My Account");

        jMenuSettings.setText("Settings");
        jMenuSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSettingsActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSettings);

        jMenuLogout.setText("Logout");
        jMenuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuLogout);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCandidaturaInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAvaliar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCandidaturaInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAvaliar)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public List<Candidatura> getCandidaturasByFAE(Utilizador user) {
        List<Candidatura> lstCandidaturas = new ArrayList<>();

        for (Exposicao expo : this.centroExpo.getListaExposicoes().getListaExposicoes()) {
            for (Atribuicao a : expo.getListaAtribuicoes().getListaAtribuicoes()) {
                if (a.getFae().getUtilizador().getUsername().equalsIgnoreCase(user.getUsername())) {
                    lstCandidaturas.add(a.getCandidatura());
                    this.listaAtribuicao.add(a);
                }
            }
        }
        return lstCandidaturas;
    }

    private void btnAvaliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvaliarActionPerformed
        Candidatura c = jLstCandidaturas.getSelectedValue();
        Atribuicao atr = new Atribuicao(fae);
        if (c == null) {
            JOptionPane.showMessageDialog(FaeUI.this,
                    "Nenhuma candidatura seleccionada", "Candidaturas", JOptionPane.ERROR_MESSAGE);
        } else {

            for (Atribuicao a : this.listaAtribuicao) {
                if (a.getCandidatura().equals(c)) {
                    atr = a;
                }
            }
            new AvaliarCandidaturaUI(c, atr);
        }
    }//GEN-LAST:event_btnAvaliarActionPerformed

    private void btnCandidaturaInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandidaturaInfoActionPerformed
        Candidatura c = jLstCandidaturas.getSelectedValue();
        if (c == null) {
            JOptionPane.showMessageDialog(FaeUI.this,
                    "Nenhuma candidatura seleccionada", "Candidaturas", JOptionPane.ERROR_MESSAGE);
        } else {
            new CandidaturaInfoUI(c);
        }
    }//GEN-LAST:event_btnCandidaturaInfoActionPerformed

    private void jMenuSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSettingsActionPerformed
        new AlterarPerfiUtilizadorUI(this.utilizador, this.centroExpo.getRegistoUtilizadores());
    }//GEN-LAST:event_jMenuSettingsActionPerformed

    private void jMenuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuLogoutActionPerformed
        new LoginUI(this.centroExpo);
        dispose();
    }//GEN-LAST:event_jMenuLogoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ActualizarConflitosUI(this.centroExpo, this.fae);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAvaliar;
    private javax.swing.JButton btnCandidaturaInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Candidatura> jLstCandidaturas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuLogout;
    private javax.swing.JMenuItem jMenuSettings;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
