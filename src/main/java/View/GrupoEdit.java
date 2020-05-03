/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.JardinController;
import Model.Actores.Profesor;
import Model.Grupo;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Royk
 */
public class GrupoEdit extends javax.swing.JFrame {
    private AdminGUI papa;
    private Grupo grupo;
    private int numeroGrupo;
    private String tarea;
    /**
     * Creates new form GrupoEdit
     */
    public GrupoEdit() {
        initComponents();
    }
    
    public GrupoEdit(String tarea, AdminGUI adminGUI){
        initComponents();
        papa =  adminGUI;
        tituloLabel.setText(tarea);
        this.tarea = tarea;
        this.grupo = new Grupo();
        numeroGrupo = JardinController.getGrupos().size();
        llenarCombos();
    }
    
    public GrupoEdit(Grupo grupo, String tarea, AdminGUI adminGUI){
        initComponents();
        papa =  adminGUI;
        tituloLabel.setText(tarea);
        this.tarea = tarea;
        this.grupo = grupo;
        numeroGrupo = grupo.getIdInt() -1;
        llenarCombos();
        
    }
    
    public void llenarCombos(){
        nivelCombo.setModel(new DefaultComboBoxModel<>(new String[] {"1","2","3"}));
        horarioCombo.setModel(new DefaultComboBoxModel<>(new String[] {"Mañana","Tarde"}));
        
        ArrayList<Profesor> profesoresList = JardinController.getProfesores();
        String[] profesoresInfo = new String[profesoresList.size()];
        for(int i = 0; i< profesoresInfo.length; i++){
            profesoresInfo[i] = profesoresList.get(i).getNombreCompleto()
                    + " / " + profesoresList.get(i).getEspecialidad();
        profesorCombo.setModel(new DefaultComboBoxModel<>(profesoresInfo));
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

        tituloLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nivelCombo = new javax.swing.JComboBox<>();
        horarioCombo = new javax.swing.JComboBox<>();
        profesorCombo = new javax.swing.JComboBox<>();
        volverBoton = new javax.swing.JButton();
        guardarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tituloLabel.setText("jLabel1");

        jLabel2.setText("Horario");

        jLabel3.setText("Profesor");

        jLabel4.setText("Nivel");

        nivelCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        horarioCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        profesorCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nivelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(horarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(profesorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivelCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(horarioCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(profesorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        volverBoton.setText("Volver");
        volverBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBotonActionPerformed(evt);
            }
        });

        guardarBoton.setText("Guardar");
        guardarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(guardarBoton)
                                .addGap(18, 18, 18)
                                .addComponent(volverBoton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardarBoton)
                    .addComponent(volverBoton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBotonActionPerformed
        dispose();
    }//GEN-LAST:event_volverBotonActionPerformed

    private void guardarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBotonActionPerformed
        
        String profesorString = profesorCombo.getSelectedItem().toString();
        profesorString = profesorString.substring(0, profesorString.indexOf('/') -1);
        
        grupo.setAll(Integer.toString(numeroGrupo),
                Integer.valueOf(nivelCombo.getSelectedItem().toString()), 
                horarioCombo.getSelectedItem().toString().charAt(0),
                JardinController.getProfesorNombreCompleto(profesorString));
        
        if(tarea.equals("Crear Grupo"))
            JardinController.getGrupos().add(grupo);
        try{
            papa.grLlenarGruposList();
        }catch(NullPointerException ne){
            System.out.println("Exception caugh");
            papa.grLlenarGruposList();
        }
        dispose();
    }//GEN-LAST:event_guardarBotonActionPerformed

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
            java.util.logging.Logger.getLogger(GrupoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupoEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrupoEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton guardarBoton;
    private javax.swing.JComboBox<String> horarioCombo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> nivelCombo;
    private javax.swing.JComboBox<String> profesorCombo;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JButton volverBoton;
    // End of variables declaration//GEN-END:variables
}
