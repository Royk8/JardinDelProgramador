package View;

import Controller.JardinController;
import Controller.ProfesorController;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
import Model.Logro;
import Persistencia.Almacenamiento;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * @author Royk
 */
public class ProfesorGUI extends javax.swing.JFrame {
    private ProfesorController profesorController;
    private Login login;
    
    /**
     * Creates new form ProfesoGUI
     */
    
    public ProfesorGUI(){
        initComponents();
    }
    
    public ProfesorGUI(Profesor profesor, Login login) {
        initComponents();
        profesorController = new ProfesorController(profesor);
        this.login = login;        
        llenarInformacion();
    }
    
    public void llenarInformacion(){
        llenarListado();
        llenarDetalles();
        llenarLogros();
    }
    
    public void llenarListado(){
        ArrayList<Ninno> ninnos = profesorController.getNinnos();
        DefaultTableModel table = (DefaultTableModel) ninnosTabla.getModel();
        for(Ninno ninno: ninnos){
            table.addRow(new Object[]{ninno.getNombre(),ninno.getApellido()});
        }
    }
    
    public void llenarLogros(){
        Ninno ninno = getSelectedNinno();
        
        DefaultTableModel tablaLogros = (DefaultTableModel) logrosTabla.getModel();
        tablaLogros.setRowCount(0);
        ArrayList<Logro> logros = ninno.getLogros();
        
        for(Logro logro: logros){
            tablaLogros.addRow(new Object[]{logro.getBimestreString(), logro.getTitulo(), logro.getEstado()});
        }
        
        
    }
    
    /**
     * Metodo que llena los campos de detalles con la informacion de los niños
     */
    public void llenarDetalles(){
        Ninno ninno = getSelectedNinno();
        if(ninno != null){
            nombreLabel.setText(ninno.getNombre());
            apellidoLabel.setText(ninno.getApellido());
            idTypeLabel.setText(ninno.getIdType());
            idLabel.setText(ninno.getId());
            acudienteLabel.setText(ninno.getAcudiente().getNombreCompleto());
            grupoLabel.setText(Integer.toString(ninno.getGrupo()));
            edadLabel.setText(Integer.toString(ninno.getEdad()));
            tallaLabel.setText(Float.toString(ninno.getTalla()) + "m");
            pesoLabel.setText(Float.toString(ninno.getPeso()));
            generoLabel.setText((ninno.getGenero() == 'M')? "Masculino" : "Femenino");
            nacimientoLabel.setText(ninno.getNacimiento().toString());
            horarioLabel.setText((ninno.getHorario() == 'M')? "Mañana" : "Tarde" );
            especialLabel.setText(ninno.getSituacionEspecial());
            nombreLabel.setText(ninno.getNombre());            
        }
    }
    
    public Logro getSelectedLogro(){
        Ninno ninno = getSelectedNinno();
        String logroTitulo = logrosTabla.getModel().getValueAt(logrosTabla.getSelectedRow(), 1).toString();
        
        return ninno.getLogro(logroTitulo);
    }
    
    public Ninno getSelectedNinno(){
        DefaultTableModel tablaNinnos = (DefaultTableModel) ninnosTabla.getModel();
        int selection = (ninnosTabla.getSelectedRow() >= 0)? ninnosTabla.getSelectedRow() : 0;        
        String ninnoNombre = tablaNinnos.getValueAt(selection, 0).toString();

        return JardinController.getNinno(ninnoNombre);
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
        jPanel4 = new javax.swing.JPanel();
        salirBoton = new javax.swing.JButton();
        cerrarSesionBoton = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        idTypeLabel = new javax.swing.JLabel();
        apellidoLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        acudienteLabel = new javax.swing.JLabel();
        grupoLabel = new javax.swing.JLabel();
        pesoLabel = new javax.swing.JLabel();
        NombreLabel4 = new javax.swing.JLabel();
        edadLabel = new javax.swing.JLabel();
        NombreLabel5 = new javax.swing.JLabel();
        NombreLabel6 = new javax.swing.JLabel();
        tallaLabel = new javax.swing.JLabel();
        NombreLabel7 = new javax.swing.JLabel();
        NombreLabel8 = new javax.swing.JLabel();
        especialLabel = new javax.swing.JLabel();
        nacimientoLabel = new javax.swing.JLabel();
        NombreLabel9 = new javax.swing.JLabel();
        generoLabel = new javax.swing.JLabel();
        NombreLabel10 = new javax.swing.JLabel();
        horarioLabel = new javax.swing.JLabel();
        NombreLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        logrosTabla = new javax.swing.JTable();
        EditarLogro = new javax.swing.JButton();
        agregarLogro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ninnosTabla = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Niños");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(getTitle());

        salirBoton.setText("Guardar y Salir");
        salirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirBotonActionPerformed(evt);
            }
        });

        cerrarSesionBoton.setText("Cerrar Sesión");
        cerrarSesionBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirBoton)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesionBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirBoton)
                    .addComponent(cerrarSesionBoton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSplitPane1.setDividerLocation(300);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Información Personal");

        nombreLabel.setText("Nombre");

        idTypeLabel.setText("Tipo de Documento");

        apellidoLabel.setText("Apellido");

        idLabel.setText("Documento");

        Label1.setText("Acudiente");

        Label2.setText("Grupo");

        acudienteLabel.setText("Acudiente");

        grupoLabel.setText("Grupo");

        pesoLabel.setText("Peso");

        NombreLabel4.setText("Edad");

        edadLabel.setText("Edad");

        NombreLabel5.setText("Talla");

        NombreLabel6.setText("Peso");

        tallaLabel.setText("Talla");

        NombreLabel7.setText("Situacion Especial");

        NombreLabel8.setText("Fecha Nacimiento");

        especialLabel.setText("Ninguna");

        nacimientoLabel.setText("Fecha de Nacimiento");

        NombreLabel9.setText("Genero");

        generoLabel.setText("Genero");

        horarioLabel.setText("Horario");

        NombreLabel11.setText("Horario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(idTypeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(apellidoLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Label2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(grupoLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pesoLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(edadLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(generoLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Label1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(acudienteLabel))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tallaLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nacimientoLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel10)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(horarioLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(NombreLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(especialLabel)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                        .addGap(5, 5, 5))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreLabel)
                    .addComponent(apellidoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTypeLabel)
                    .addComponent(idLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(acudienteLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(grupoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel4)
                    .addComponent(edadLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel5)
                    .addComponent(tallaLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel6)
                    .addComponent(pesoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel9)
                    .addComponent(generoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel8)
                    .addComponent(nacimientoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel11)
                    .addComponent(horarioLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel7)
                    .addComponent(especialLabel))
                .addGap(36, 36, 36)
                .addComponent(NombreLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Informacion Personal", jPanel2);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Logros");

        logrosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bimestre", "Logro", "Estado"
            }
        ));
        jScrollPane2.setViewportView(logrosTabla);

        EditarLogro.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        EditarLogro.setText("Editar Logro");
        EditarLogro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarLogroActionPerformed(evt);
            }
        });

        agregarLogro.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        agregarLogro.setText("Agregar Logro");
        agregarLogro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        agregarLogro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarLogroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(agregarLogro)
                .addGap(18, 18, 18)
                .addComponent(EditarLogro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarLogro)
                    .addComponent(EditarLogro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Logros", jPanel3);

        jSplitPane1.setRightComponent(jTabbedPane1);

        ninnosTabla.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        ninnosTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ninnosTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ninnosTabla.getTableHeader().setReorderingAllowed(false);
        ninnosTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ninnosTablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ninnosTabla);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Niños");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ninnosTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ninnosTablaMouseClicked
        llenarDetalles();
        llenarLogros();
    }//GEN-LAST:event_ninnosTablaMouseClicked

    private void agregarLogroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarLogroActionPerformed
        LogroEdit edit = new LogroEdit("Asignar Logro", this, getSelectedNinno());
        edit.setVisible(true);
    }//GEN-LAST:event_agregarLogroActionPerformed

    private void EditarLogroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarLogroActionPerformed
        Logro logro = getSelectedLogro();
        if(logro != null){
            LogroEdit edit = new LogroEdit("Asignar Logro", this, getSelectedNinno(), logro);
            edit.setVisible(true);
        }
    }//GEN-LAST:event_EditarLogroActionPerformed

    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        Almacenamiento.almacenarRegistros();
        System.exit(0);
    }//GEN-LAST:event_salirBotonActionPerformed

    private void cerrarSesionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBotonActionPerformed
        Almacenamiento.almacenarRegistros();        
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_cerrarSesionBotonActionPerformed

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
            java.util.logging.Logger.getLogger(ProfesorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfesorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfesorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfesorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfesorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EditarLogro;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel NombreLabel10;
    private javax.swing.JLabel NombreLabel11;
    private javax.swing.JLabel NombreLabel4;
    private javax.swing.JLabel NombreLabel5;
    private javax.swing.JLabel NombreLabel6;
    private javax.swing.JLabel NombreLabel7;
    private javax.swing.JLabel NombreLabel8;
    private javax.swing.JLabel NombreLabel9;
    private javax.swing.JLabel acudienteLabel;
    private javax.swing.JButton agregarLogro;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JButton cerrarSesionBoton;
    private javax.swing.JLabel edadLabel;
    private javax.swing.JLabel especialLabel;
    private javax.swing.JLabel generoLabel;
    private javax.swing.JLabel grupoLabel;
    private javax.swing.JLabel horarioLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idTypeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable logrosTabla;
    private javax.swing.JLabel nacimientoLabel;
    private javax.swing.JTable ninnosTabla;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel pesoLabel;
    private javax.swing.JButton salirBoton;
    private javax.swing.JLabel tallaLabel;
    // End of variables declaration//GEN-END:variables

}
