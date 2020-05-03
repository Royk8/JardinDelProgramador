/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Actores.Ninno;
import Model.Logro;
import Model.Bimestre;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Royk
 */
public class LogroEdit extends javax.swing.JFrame {
    private Logro logro;
    private Ninno ninno;
    private ProfesorGUI papa;
    private boolean esNuevo;
    /**
     * Creates new form LogroEdit
     */
    public LogroEdit() {
        initComponents();
    }
    
    public LogroEdit(String titulo, ProfesorGUI papa, Ninno ninno) {        
        initComponents();
        titleLabel.setText(titulo);
        esNuevo = true;
        this.papa = papa;
        this.logro = new Logro();
        this.ninno = ninno;
        llenarInformacion();
    }
        
    public LogroEdit(String titulo, ProfesorGUI papa, Ninno ninno, Logro logro) {
        initComponents();
        titleLabel.setText(titulo);
        esNuevo = false;
        this.papa = papa;
        this.logro = logro;
        this.ninno = ninno;
        llenarInformacion();
    }
    
    public void llenarInformacion(){
        llenarCombos();
        if(esNuevo){
            nombreField.setText("");
            descripcionField.setText("");
            avanceCombo.setSelectedIndex(0);
            yearCombo.setSelectedIndex(0);
            bimestreCombo.setSelectedIndex(0);
        }else{
            nombreField.setText(logro.getTitulo());
            descripcionField.setText(logro.getDescripcion());
            avanceCombo.setSelectedIndex(0);
            yearCombo.setSelectedItem(logro.getBimestre().getYear());
            bimestreCombo.setSelectedIndex(logro.getBimestre().getNumBimestre() -1);
        }
    }
    
    public void llenarCombos(){
        String[] estados = {"Logrado", "Gran avance", "Poco Avance", "No logrado"}; 
        avanceCombo.setModel(new DefaultComboBoxModel<>(estados));
        
        String[] years = Arrays.stream(IntStream.range(LocalDate.now().getYear() -1, LocalDate.now().getYear() +20).toArray())
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
        yearCombo.setModel(new DefaultComboBoxModel(years));
        
        String[] bimestres = {"Enero-Febrero", "Marzo-Abril", "Mayo-Junio",
            "Julio-Agosto", "Septiembre-Octubre", "Noviembre-Diciembre"};
        bimestreCombo.setModel(new DefaultComboBoxModel<>(bimestres));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionField = new javax.swing.JTextArea();
        nombre1 = new javax.swing.JLabel();
        avanceCombo = new javax.swing.JComboBox<>();
        Estado = new javax.swing.JLabel();
        Estado1 = new javax.swing.JLabel();
        yearCombo = new javax.swing.JComboBox<>();
        bimestreCombo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        guardarBoton = new javax.swing.JButton();
        restablecerBoton = new javax.swing.JButton();
        volverBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nombre.setText("Nombre del Logro");

        descripcionField.setColumns(20);
        descripcionField.setRows(5);
        jScrollPane1.setViewportView(descripcionField);

        nombre1.setText("Descripcion (Opcional)");

        avanceCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        Estado.setText("Avance");

        Estado1.setText("Año ");

        yearCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bimestreCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Bimestre");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Estado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avanceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Estado1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(yearCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bimestreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))))))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(Estado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(avanceCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(nombre1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Estado1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(yearCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bimestreCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        titleLabel.setText("Logro");

        guardarBoton.setText("Guardar");
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });

        restablecerBoton.setText("Restablecer");
        restablecerBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restablecerBotonActionPerformed(evt);
            }
        });

        volverBoton.setText("Volver");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarBoton)
                        .addGap(18, 18, 18)
                        .addComponent(restablecerBoton)
                        .addGap(18, 18, 18)
                        .addComponent(volverBoton)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(volverBoton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardarBoton)
                        .addComponent(restablecerBoton)))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        logro.setAll(nombreField.getText(),
                bimestreCombo.getSelectedIndex() + 1,
                Integer.valueOf(yearCombo.getSelectedItem().toString()),
                avanceCombo.getSelectedItem().toString(),
                descripcionField.getText());
        
        if(esNuevo)
            ninno.getLogros().add(logro);
        papa.llenarLogros();
        dispose();
    }//GEN-LAST:event_guardarBotonActionPerformed

    private void restablecerBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restablecerBotonActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Desea restablecer todos los cambios","Restablecer",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
            llenarInformacion();
        }
    }//GEN-LAST:event_restablecerBotonActionPerformed

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        dispose();
    }//GEN-LAST:event_volverBotonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogroEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogroEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogroEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogroEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogroEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Estado;
    private javax.swing.JLabel Estado1;
    private javax.swing.JComboBox<String> avanceCombo;
    private javax.swing.JComboBox<String> bimestreCombo;
    private javax.swing.JTextArea descripcionField;
    private javax.swing.JButton guardarBoton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel nombre1;
    private javax.swing.JTextField nombreField;
    private javax.swing.JButton restablecerBoton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton volverBoton;
    private javax.swing.JComboBox<String> yearCombo;
    // End of variables declaration//GEN-END:variables
}
