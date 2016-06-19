/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.ui.fae;

import java.awt.Component;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import lapr.project.controller.fae.ActualizarConflitosController;
import lapr.project.model.Demonstracao;
import lapr.project.model.exhibitions.CentroExposicoes;
import lapr.project.model.exhibitions.Exposicao;
import lapr.project.model.submissions.Candidatura;
import lapr.project.model.users.FAE;

/**
 *
 * @author zero_
 */
public class ActualizarConflitosUI extends javax.swing.JFrame {

    private ActualizarConflitosController controller;

    /**
     * Creates new form ActualizarConflitosUI
     */
    public ActualizarConflitosUI(CentroExposicoes centroExposicoes, FAE fae) {
        this.controller = new ActualizarConflitosController(centroExposicoes, fae);

        super.setTitle("Actualizar Conflitos");

        initComponents();
        inicializarListaExpo();
        inicializarListaDemo();

        super.setLocationRelativeTo(null);
        super.setVisible(true);
    }

    private void inicializarListaExpo() {
        final List<Exposicao> listaExposicoes = this.controller.getListaExposicoes();

        if (listaExposicoes.isEmpty()) {
            this.jListExpo.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem Exposicoes com conflitos");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return listaExposicoes.size();
            }

            @Override
            public Object getElementAt(int i) {
                return listaExposicoes.get(i);
            }
        };

        this.jListExpo.setModel(listModel);
        this.jListExpo.setCellRenderer(new CellRendererExpo());
    }

    private class CellRendererExpo extends JLabel implements ListCellRenderer<Exposicao> {

        public CellRendererExpo() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Exposicao> list, Exposicao exposicao, int index, boolean isSelected, boolean cellHasFocus) {
            setText(exposicao.getTitle());

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

    private void inicializarListaDemo() {
        final List<Demonstracao> listaDemonstracoes = this.controller.getListaDemonstracoes();

        if (listaDemonstracoes.isEmpty()) {
            this.jListDemo.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem Demonstracoes com conflitos");
        }

        DefaultListModel listModel = new DefaultListModel() {
            @Override
            public int getSize() {
                return listaDemonstracoes.size();
            }

            @Override
            public Object getElementAt(int i) {
                return listaDemonstracoes.get(i);
            }
        };

        this.jListDemo.setModel(listModel);
        this.jListDemo.setCellRenderer(new CellRendererDemo());
    }

    private class CellRendererDemo extends JLabel implements ListCellRenderer<Demonstracao> {

        public CellRendererDemo() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Demonstracao> list, Demonstracao demonstracao, int index, boolean isSelected, boolean cellHasFocus) {
            setText(demonstracao.getDesignacao());

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

    private void inicializarListaCand() {
        final List<Candidatura> listaCandidaturas = this.controller.getListaCandidaturas();

        if (listaCandidaturas.isEmpty()) {
            this.jListExpo.setModel(new DefaultListModel<>());
            JOptionPane.showMessageDialog(this, "Não existem Candidaturas");
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

        this.jListCand.setModel(listModel);
        this.jListCand.setCellRenderer(new CellRendererCand());
    }

    private class CellRendererCand extends JLabel implements ListCellRenderer<Candidatura> {

        public CellRendererCand() {
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
        jListExpo = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListCand = new javax.swing.JList<>();
        jButtonMostCand = new javax.swing.JButton();
        jButtonAddRemoConf = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListDemo = new javax.swing.JList<>();
        jButtonCandDemo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(jListExpo);

        jScrollPane2.setViewportView(jListCand);

        jButtonMostCand.setText("Mostar Candidaturas >> >>");
        jButtonMostCand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostCandActionPerformed(evt);
            }
        });

        jButtonAddRemoConf.setText("Add ou Remove Conflitos");
        jButtonAddRemoConf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRemoConfActionPerformed(evt);
            }
        });

        jLabel1.setText("Lista Exposicoes");

        jLabel2.setText("Lista Candidaturas");

        jScrollPane3.setViewportView(jListDemo);

        jButtonCandDemo.setText("Mostrar Candidaturas >>");
        jButtonCandDemo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCandDemoActionPerformed(evt);
            }
        });

        jLabel3.setText("Lista Demonstracoes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonMostCand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jButtonCandDemo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddRemoConf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostCand)
                    .addComponent(jButtonCandDemo)
                    .addComponent(jButtonAddRemoConf))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddRemoConfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRemoConfActionPerformed
        if (this.jListCand.getSelectedIndex() != -1) {
            this.controller.selectCandidatura(this.jListCand.getSelectedValue());
            new AddRemoveConflitosUI(this.controller);
        } else {
            JOptionPane.showMessageDialog(ActualizarConflitosUI.this,
                    "Select uma Candidatura", "Actualizar Conflitos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddRemoConfActionPerformed

    private void jButtonMostCandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostCandActionPerformed
        if (this.jListExpo.getSelectedIndex() != -1) {
            this.controller.selectExposicao(this.jListExpo.getSelectedValue());
            inicializarListaCand();
        } else {
            JOptionPane.showMessageDialog(ActualizarConflitosUI.this,
                    "Select uma Exposicao", "Actualizar Conflitos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonMostCandActionPerformed

    private void jButtonCandDemoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCandDemoActionPerformed
        if (this.jListDemo.getSelectedIndex() != -1) {
            this.controller.selectDemonstracao(this.jListDemo.getSelectedValue());
            inicializarListaCand();
        } else {
            JOptionPane.showMessageDialog(ActualizarConflitosUI.this,
                    "Select uma Demonstracao", "Actualizar Conflitos", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCandDemoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddRemoConf;
    private javax.swing.JButton jButtonCandDemo;
    private javax.swing.JButton jButtonMostCand;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<Candidatura> jListCand;
    private javax.swing.JList<Demonstracao> jListDemo;
    private javax.swing.JList<Exposicao> jListExpo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
