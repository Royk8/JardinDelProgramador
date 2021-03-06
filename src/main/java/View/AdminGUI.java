/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GrupoController;
import Controller.JardinController;
import Controller.ProfesorController;
import Model.Actores.Admin;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
import Model.Grupo;
import Persistencia.Almacenamiento;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * JFrame para el rol de administrador, Contiene el CRUD de todo el programa
 * @author Royk
 */
public class AdminGUI extends javax.swing.JFrame {
    private Login login;
    /**
     * Creates new form AdminGUI
     */
    public AdminGUI() {
        initComponents();
    }
    
    /**
     * Crea la ventana admin con la informacion del perfin de admin que logueo
     * @param admin Perfil de admin del cual se extraera informacion
     * @login ventana login padre de esta
     */
    public AdminGUI(Admin admin, Login login) {
        initComponents();
        this.login = login;
        llenarTodasLasListas();
    }
    
    /**
     * Llena todas las listas de informacion
     */
    public void llenarTodasLasListas(){
        grLlenarGruposList();
        grLlenarDetalles();
        prLlenarProfesoresList();
        prLlenarDetalles();
        niLlenarNinnosList();
        niLlenarDetalles();
    }
    
    /**
     * De la pesaña Grupos, llena la lista de grupos
     */
    public void grLlenarGruposList(){
        DefaultListModel<String> listaGrupos = new DefaultListModel<String>();
        ArrayList<Grupo> grupos = JardinController.getGrupos();
        for(Grupo grupo: grupos){
            listaGrupos.addElement(grupo.getId());
        }
        grGruposList.setModel(listaGrupos);
    }
    
    /**
     * De la pestaña Grupos, llena las etiquetas con los detalles del grupo
     */
    public void grLlenarDetalles(){
        grGruposList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String identificador = grGruposList.getSelectedValue();
                Grupo grupo = JardinController.getGrupo(identificador);
                if(grupo != null){
                    grGrupoLabel.setText("Grupo " + grupo.getId());
                    grHorarioLabel.setText((grupo.getHorario() == 'M')? "Mañana" : "Tarde");
                    grNivelLabel.setText(Integer.toString(grupo.getNivel()));
                    
                    try{
                    Profesor profesor = grupo.getProfesor();
                    grProfesorLabel.setText(profesor.getNombreCompleto());
                    }catch(NullPointerException nu){
                        grProfesorLabel.setText("Sin Profesor");
                    }
                    
                    grLlenarNinnos(grupo);
                }
            }
        });
    }
    
    /**
     * De la pestaña grupos, llena la lista de ninnos de cada grupo
     * @param grupo del que se recuperaran los ninnos
     */
    public void grLlenarNinnos(Grupo grupo){
        GrupoController grController = new GrupoController(grupo);
        ArrayList<Ninno> ninnos = grController.getNinnos();
        DefaultListModel<String> ninnosList = new DefaultListModel<String>();
        for(Ninno ninno: ninnos){
            ninnosList.addElement(ninno.getNombreCompleto());
        }
        grNinnosList.setModel(ninnosList);
    }
    
    /**
     * Clase que llena la lista de profesores en la pestana profesores.
     * Instanciamos un modelo de Lista para ponerla en el JList
     * Obtenemos el arrayList de la clase JardinController
     */
    public void prLlenarProfesoresList(){
        DefaultListModel<String> listaProfesores = new DefaultListModel<>();
        ArrayList<Profesor> profesores = JardinController.getProfesores();
        for(Profesor profesor: profesores){
            listaProfesores.addElement(profesor.getNombreCompleto());
        }
        prProfesoresList.setModel(listaProfesores);
    }
    
    /**
     * De la pestaña profesores, llena las etiquetas de detalles 
     */
    public void prLlenarDetalles(){
        prProfesoresList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String nombreCompleto = prProfesoresList.getSelectedValue();
                Profesor profesor = JardinController.getProfesorNombreCompleto(nombreCompleto);
                if(profesor != null){
                    prNombreLabel.setText(profesor.getNombre());
                    prApellidoLabel.setText(profesor.getApellido());
                    prIdTypeLabel.setText(profesor.getIdType());
                    prIdLabel.setText(profesor.getId());
                    prEspecialLabel.setText(profesor.getEspecialidad());
                    prTelefonoLabel.setText(profesor.getTelefono());
                    ProfesorController prController = new ProfesorController(profesor);
                    prController.getNinnos().size();
                    prNumeroLabel.setText(Integer.toString(prController.getNinnos().size()));
                }
            }
        });
    }

    /**
     * De la pestaña ninnos, llena la lista de ninnos
     */
    public void niLlenarNinnosList(){
        DefaultListModel<String> listaNinnos = new DefaultListModel<>();
        ArrayList<Ninno> ninnos = JardinController.getNinnos();
        for(Ninno ninno : ninnos){
            listaNinnos.addElement(ninno.getNombreCompleto());
        }
        niNinnosList.setModel(listaNinnos);
    }
    
    /**
     * De la pestaña ninnos, llena los detalles del niño seleccionado en la lista
     */
    public void niLlenarDetalles(){
        niNinnosList.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String nombreCompleto = niNinnosList.getSelectedValue();
                Ninno ninno = JardinController.getNinnoCompleto(nombreCompleto);
                if(ninno != null){
                    niNombreLabel.setText(ninno.getNombre());
                    niApellidoLabel.setText(ninno.getApellido());
                    niIdTypeLabel.setText(ninno.getIdType());
                    niIdLabel.setText(ninno.getId());
                    niAcudienteLabel.setText(ninno.getAcudiente().getNombreCompleto());
                    niGrupoLabel.setText(Integer.toString(ninno.getGrupo()));
                    niEdadLabel.setText(Integer.toString(ninno.getEdad()));
                    niTallaLabel.setText(Float.toString(ninno.getTalla()) + "m");
                    niPesoLabel.setText(Float.toString(ninno.getPeso()));
                    niGeneroLabel.setText((ninno.getGenero() == 'M')? "Masculino" : "Femenino");
                    niNacimientoLabel.setText(ninno.getNacimiento().toString());
                    niHorarioLabel.setText((ninno.getHorario() == 'M')? "Mañana" : "Tarde" );
                    niEspecialLabel.setText(ninno.getSituacionEspecial());
                    if(!ninno.getParientes().isEmpty() && ninno.getParientes().get(0)!=null){
                        niPariente1Label.setText(ninno.getParientes().get(0).getParentesco());
                        niParienteInfo1Label.setText(ninno.getParientes().get(0).getNombreCompleto());
                        if(ninno.getParientes().size() > 1){
                            niPariente2Label.setText(ninno.getParientes().get(1).getParentesco());
                            niParienteInfo2Label.setText(ninno.getParientes().get(1).getNombreCompleto());
                        }else{
                            niPariente2Label.setText(" ");
                            niParienteInfo2Label.setText(" ");
                        }
                    }else{
                        niPariente1Label.setText(" ");
                        niParienteInfo1Label.setText(" ");
                        niPariente2Label.setText(" ");
                        niParienteInfo2Label.setText(" ");
                    }
                }
            }            
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        grGruposList = new javax.swing.JList<>();
        jPanel7 = new javax.swing.JPanel();
        grCrearGrupoBoton = new javax.swing.JButton();
        grBorrarGrupoBoton = new javax.swing.JButton();
        grEditarGrupoBoton = new javax.swing.JButton();
        grGrupoLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        grProfesorLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        grHorarioLabel = new javax.swing.JLabel();
        grNinnoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        grNinnosList = new javax.swing.JList<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        grNivelLabel = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        prProfesoresList = new javax.swing.JList<>();
        jPanel9 = new javax.swing.JPanel();
        prRegistrarProfesorBoton = new javax.swing.JButton();
        prBorrarProfesorBoton = new javax.swing.JButton();
        prEditarProfesorBoton = new javax.swing.JButton();
        prNombreLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        prApellidoLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        prTelefonoLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        prIdTypeLabel = new javax.swing.JLabel();
        prIdLabel = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        prEspecialLabel = new javax.swing.JLabel();
        prNumeroLabel = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        niNinnosList = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        niRegistrarNinnoBoton = new javax.swing.JButton();
        niBorrarNinnoBoton = new javax.swing.JButton();
        niEditarNinnoBoton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        niAsignarGrupoBoton = new javax.swing.JButton();
        niEliminarNinnoBoton2 = new javax.swing.JButton();
        Label1 = new javax.swing.JLabel();
        NombreLabel8 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        niEspecialLabel = new javax.swing.JLabel();
        niAcudienteLabel = new javax.swing.JLabel();
        niNacimientoLabel = new javax.swing.JLabel();
        niGrupoLabel = new javax.swing.JLabel();
        NombreLabel9 = new javax.swing.JLabel();
        niPesoLabel = new javax.swing.JLabel();
        niGeneroLabel = new javax.swing.JLabel();
        NombreLabel4 = new javax.swing.JLabel();
        niEdadLabel = new javax.swing.JLabel();
        niHorarioLabel = new javax.swing.JLabel();
        NombreLabel5 = new javax.swing.JLabel();
        NombreLabel11 = new javax.swing.JLabel();
        NombreLabel6 = new javax.swing.JLabel();
        niNombreLabel = new javax.swing.JLabel();
        niIdTypeLabel = new javax.swing.JLabel();
        niApellidoLabel = new javax.swing.JLabel();
        niTallaLabel = new javax.swing.JLabel();
        niIdLabel = new javax.swing.JLabel();
        NombreLabel7 = new javax.swing.JLabel();
        niPariente2Label = new javax.swing.JLabel();
        niPariente1Label = new javax.swing.JLabel();
        niParienteInfo1Label = new javax.swing.JLabel();
        niParienteInfo2Label = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jSplitPane4 = new javax.swing.JSplitPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        adAdminList = new javax.swing.JList<>();
        jPanel13 = new javax.swing.JPanel();
        adRegistrarBoton = new javax.swing.JButton();
        adBorrarBoton = new javax.swing.JButton();
        adEditarBoton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        adNombreLabel = new javax.swing.JLabel();
        adApellidoLabel = new javax.swing.JLabel();
        adIdTypeLabel = new javax.swing.JLabel();
        adIdLabel = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        salirBoton = new javax.swing.JButton();
        cerrarSesionBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 650));

        jSplitPane1.setDividerLocation(150);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(50, 50));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 139));

        grGruposList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(grGruposList);

        jSplitPane1.setLeftComponent(jScrollPane1);

        grCrearGrupoBoton.setText("Crear Grupo");
        grCrearGrupoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grCrearGrupoBotonActionPerformed(evt);
            }
        });

        grBorrarGrupoBoton.setText("Borrar Grupo");
        grBorrarGrupoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grBorrarGrupoBotonActionPerformed(evt);
            }
        });

        grEditarGrupoBoton.setText("Editar Grupo");
        grEditarGrupoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grEditarGrupoBotonActionPerformed(evt);
            }
        });

        grGrupoLabel.setText("Grupo");

        jLabel2.setText("Profesor");

        grProfesorLabel.setText("Profesor");

        jLabel3.setText("Horario");

        grHorarioLabel.setText("Horario");

        grNinnoLabel.setText("Niños");

        grNinnosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(grNinnosList);

        jLabel4.setText("Nivel");

        grNivelLabel.setText("Nivel");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grProfesorLabel))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grHorarioLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 293, Short.MAX_VALUE)
                        .addComponent(grCrearGrupoBoton)
                        .addGap(18, 18, 18)
                        .addComponent(grEditarGrupoBoton)
                        .addGap(18, 18, 18)
                        .addComponent(grBorrarGrupoBoton))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grGrupoLabel)
                            .addComponent(grNinnoLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grNivelLabel)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(grGrupoLabel)
                .addGap(34, 34, 34)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(grProfesorLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(grHorarioLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(grNivelLabel))
                .addGap(19, 19, 19)
                .addComponent(grNinnoLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(grCrearGrupoBoton)
                    .addComponent(grBorrarGrupoBoton)
                    .addComponent(grEditarGrupoBoton))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Grupos", jPanel3);

        jSplitPane2.setDividerLocation(150);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(50, 50));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 139));

        prProfesoresList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(prProfesoresList);

        jSplitPane2.setLeftComponent(jScrollPane3);

        prRegistrarProfesorBoton.setText("Registrar Profesor");
        prRegistrarProfesorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prRegistrarProfesorBotonActionPerformed(evt);
            }
        });

        prBorrarProfesorBoton.setText("Eliminar Registro");

        prEditarProfesorBoton.setText("Editar Informacion");
        prEditarProfesorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prEditarProfesorBotonActionPerformed(evt);
            }
        });

        prNombreLabel.setText("Nombre");

        jLabel5.setText("Profesor");

        prApellidoLabel.setText("Apellido");

        jLabel6.setText("Telefono");

        prTelefonoLabel.setText("Telefono");

        prIdTypeLabel.setText("Tipo de documento");

        prIdLabel.setText("Documento");

        jLabel15.setText("Numero de Estudiantes");

        jLabel16.setText("Especialidad");

        prEspecialLabel.setText("Especilaidad");

        prNumeroLabel.setText("Numero de Estudiantes");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(prNombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prApellidoLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(prIdTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prIdLabel))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prEspecialLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(0, 223, Short.MAX_VALUE)
                        .addComponent(prRegistrarProfesorBoton)
                        .addGap(18, 18, 18)
                        .addComponent(prEditarProfesorBoton)
                        .addGap(18, 18, 18)
                        .addComponent(prBorrarProfesorBoton))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prTelefonoLabel))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prNumeroLabel)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prNombreLabel)
                    .addComponent(prApellidoLabel))
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prIdLabel)
                    .addComponent(prIdTypeLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(prEspecialLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(prTelefonoLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(prRegistrarProfesorBoton)
                            .addComponent(prBorrarProfesorBoton)
                            .addComponent(prEditarProfesorBoton)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(prNumeroLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(jPanel9);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Profesores", jPanel8);

        jSplitPane3.setDividerLocation(150);

        jScrollPane5.setMinimumSize(new java.awt.Dimension(50, 50));
        jScrollPane5.setPreferredSize(new java.awt.Dimension(200, 139));

        niNinnosList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(niNinnosList);

        jSplitPane3.setLeftComponent(jScrollPane5);

        niRegistrarNinnoBoton.setText("Registrar Niño");
        niRegistrarNinnoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niRegistrarNinnoBotonActionPerformed(evt);
            }
        });

        niBorrarNinnoBoton.setText("Borrar Registro");
        niBorrarNinnoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niBorrarNinnoBotonActionPerformed(evt);
            }
        });

        niEditarNinnoBoton.setText("Editar Información");
        niEditarNinnoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niEditarNinnoBotonActionPerformed(evt);
            }
        });

        niAsignarGrupoBoton.setText("Asignar Grupo");
        niAsignarGrupoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                niAsignarGrupoBotonActionPerformed(evt);
            }
        });

        niEliminarNinnoBoton2.setText("Ver Informacion de Padres");

        Label1.setText("Acudiente");

        NombreLabel8.setText("Fecha Nacimiento");

        Label2.setText("Grupo");

        niEspecialLabel.setText("Ninguna");

        niAcudienteLabel.setText("Acudiente");

        niNacimientoLabel.setText("Fecha de Nacimiento");

        niGrupoLabel.setText("Grupo");

        NombreLabel9.setText("Genero");

        niPesoLabel.setText("Peso");

        niGeneroLabel.setText("Genero");

        NombreLabel4.setText("Edad");

        niEdadLabel.setText("Edad");

        niHorarioLabel.setText("Horario");

        NombreLabel5.setText("Talla");

        NombreLabel11.setText("Horario");

        NombreLabel6.setText("Peso");

        niNombreLabel.setText("Nombre");

        niIdTypeLabel.setText("Tipo de Documento");

        niApellidoLabel.setText("Apellido");

        niTallaLabel.setText("Talla");

        niIdLabel.setText("Documento");

        NombreLabel7.setText("Situacion Especial");

        niPariente2Label.setText("Madre");

        niPariente1Label.setText("Padre");

        niParienteInfo1Label.setText("Acudiente");

        niParienteInfo2Label.setText("Acudiente");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(0, 249, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(niRegistrarNinnoBoton)
                                .addGap(18, 18, 18)
                                .addComponent(niEditarNinnoBoton)
                                .addGap(18, 18, 18)
                                .addComponent(niBorrarNinnoBoton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(niAsignarGrupoBoton)
                                .addGap(18, 18, 18)
                                .addComponent(niEliminarNinnoBoton2))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(niIdTypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niIdLabel))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(niNombreLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niApellidoLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(Label2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niGrupoLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niPesoLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niEdadLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niGeneroLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(Label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niAcudienteLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niTallaLabel))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niNacimientoLabel))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niHorarioLabel))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(NombreLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(niEspecialLabel))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(niPariente1Label)
                            .addComponent(niPariente2Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(niParienteInfo1Label, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(niParienteInfo2Label, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niNombreLabel)
                    .addComponent(niApellidoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niIdTypeLabel)
                    .addComponent(niIdLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(niAcudienteLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niParienteInfo1Label)
                    .addComponent(niPariente1Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niPariente2Label)
                    .addComponent(niParienteInfo2Label))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label2)
                    .addComponent(niGrupoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel4)
                    .addComponent(niEdadLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel5)
                    .addComponent(niTallaLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel6)
                    .addComponent(niPesoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel9)
                    .addComponent(niGeneroLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel8)
                    .addComponent(niNacimientoLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel11)
                    .addComponent(niHorarioLabel))
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NombreLabel7)
                    .addComponent(niEspecialLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niAsignarGrupoBoton)
                    .addComponent(niEliminarNinnoBoton2))
                .addGap(28, 28, 28)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(niRegistrarNinnoBoton)
                    .addComponent(niBorrarNinnoBoton)
                    .addComponent(niEditarNinnoBoton))
                .addContainerGap())
        );

        jSplitPane3.setRightComponent(jPanel11);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Niños", jPanel10);

        jSplitPane4.setDividerLocation(150);

        jScrollPane7.setMinimumSize(new java.awt.Dimension(50, 50));
        jScrollPane7.setPreferredSize(new java.awt.Dimension(200, 139));

        adAdminList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(adAdminList);

        jSplitPane4.setLeftComponent(jScrollPane7);

        adRegistrarBoton.setText("Registrar Administrador");
        adRegistrarBoton.setMaximumSize(new java.awt.Dimension(100, 25));

        adBorrarBoton.setText("Borrar Administrador");

        adEditarBoton.setText("Editar Administrados");
        adEditarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adEditarBotonActionPerformed(evt);
            }
        });

        jLabel10.setText("Cuenta de Administrador");

        adNombreLabel.setText("Nombre");

        adApellidoLabel.setText("Apellido");

        adIdTypeLabel.setText("Documento");

        adIdLabel.setText("Numero");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setText("Disponible en futura actualizacion");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adNombreLabel)
                            .addComponent(adIdTypeLabel)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adApellidoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adIdLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(adBorrarBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adRegistrarBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adEditarBoton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(34, 34, 34)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adNombreLabel)
                    .addComponent(adApellidoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adIdTypeLabel)
                    .addComponent(adIdLabel))
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(adEditarBoton)
                .addGap(18, 18, 18)
                .addComponent(adRegistrarBoton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(adBorrarBoton)
                .addContainerGap())
        );

        jSplitPane4.setRightComponent(jPanel13);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Administradores", jPanel12);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(salirBoton)
                .addGap(18, 18, 18)
                .addComponent(cerrarSesionBoton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirBoton)
                    .addComponent(cerrarSesionBoton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prEditarProfesorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prEditarProfesorBotonActionPerformed
        if(!prProfesoresList.isSelectionEmpty()){
            Profesor profesor = JardinController.getProfesorNombreCompleto(prProfesoresList.getSelectedValue());
            if(profesor != null){
                ProfesorEdit edit = new ProfesorEdit("Editar Profesor", this, profesor);
                edit.setVisible(true);
            }
        }   
    }//GEN-LAST:event_prEditarProfesorBotonActionPerformed

    /**
     * De la pestaña grupos, abre la ventana de edicion de los grupos
     * @param evt 
     */
    private void grEditarGrupoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grEditarGrupoBotonActionPerformed
        if(!grGruposList.isSelectionEmpty()){
            String idGrupo = grGruposList.getSelectedValue();
            Grupo grupo = JardinController.getGrupo(idGrupo);
            if(grupo != null){
                GrupoEdit edit = new GrupoEdit(grupo,"Editar Grupo",this);
                edit.setVisible(true);
            }
        }        
    }//GEN-LAST:event_grEditarGrupoBotonActionPerformed
    /**
     * De la pestaña ninnos, abre la ventana de edicion de ninnos
     * @param evt 
     */
    private void niEditarNinnoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_niEditarNinnoBotonActionPerformed
        if(!niNinnosList.isSelectionEmpty()){
            String nombreCompleto = niNinnosList.getSelectedValue();
            Ninno ninno = JardinController.getNinnoCompleto(nombreCompleto);
            if(ninno != null){
                NinnoEdit editNinno = new NinnoEdit(ninno, "Editar Niño", this);
                editNinno.setVisible(true);
            }
        }
    }//GEN-LAST:event_niEditarNinnoBotonActionPerformed

    private void adEditarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adEditarBotonActionPerformed
        // TODO add your handling code here: 
        //Coming Soon
    }//GEN-LAST:event_adEditarBotonActionPerformed

    /**
     * De la ventana ninnos abre la ventana de registro de nuevo ninno
     * @param evt 
     */
    private void niRegistrarNinnoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_niRegistrarNinnoBotonActionPerformed
        NinnoEdit editNinno = new NinnoEdit("Registrar Niño",this);
        editNinno.setVisible(true);        
    }//GEN-LAST:event_niRegistrarNinnoBotonActionPerformed

    /**
     * De la ventana ninnos, borra el registro de un ninno
     * @param evt 
     */
    private void niBorrarNinnoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_niBorrarNinnoBotonActionPerformed
        if(!niNinnosList.isSelectionEmpty()){
            Ninno ninno = JardinController.getNinnoCompleto(niNinnosList.getSelectedValue());
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Desea eliminar a " + ninno.getNombreCompleto() + " de los registros?",
                    "Borrar registro",JOptionPane.YES_NO_OPTION);
            if(confirmacion == 1){
                JardinController.getNinnos().remove(ninno);
            }    
        }
    }//GEN-LAST:event_niBorrarNinnoBotonActionPerformed

    /**
     * De la ventana ninnos, abre la ventana donde se elige un grupo para el ninno seleccionado
     * @param evt 
     */
    private void niAsignarGrupoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_niAsignarGrupoBotonActionPerformed
        if(!niNinnosList.isSelectionEmpty()){
            Ninno ninno = JardinController.getNinnoCompleto(niNinnosList.getSelectedValue());
            String[] grupos = JardinController.getGrupos().stream()
                    .map(grupo -> Integer.toString(grupo.getIdInt()))
                    .toArray(String[]::new);
            Object seleccion = (JOptionPane.showInputDialog(this, "Seleciona un grupo", "Asignar Grupo", JOptionPane.DEFAULT_OPTION,
                    null, grupos, grupos[0]));
            if(seleccion != null){                
                Grupo grupo = JardinController.getGrupo(Integer.valueOf(seleccion.toString()));
                GrupoController.addNinno(ninno, grupo); 
                ninno.setProfesor(grupo.getProfesor().getId());
                niLlenarDetalles();
            }
            
        }
    }//GEN-LAST:event_niAsignarGrupoBotonActionPerformed

    /**
     * De la ventana Grupos, abre la ventana de creacion de grupos
     * @param evt 
     */
    private void grCrearGrupoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grCrearGrupoBotonActionPerformed
        GrupoEdit edit = new GrupoEdit("Crear Grupo",this);
        edit.setVisible(true);
    }//GEN-LAST:event_grCrearGrupoBotonActionPerformed

    /**
     * De la ventana grupos, borra la informacion de un grupo y transfiere los ninnos al grupo cero
     * @param evt 
     */
    private void grBorrarGrupoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grBorrarGrupoBotonActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this,
            "¿Desea eliminar este grupo de los registros?",
            "Borrar registro",JOptionPane.YES_NO_OPTION);
        if(confirmacion == 0){
            String idGrupo = grGruposList.getSelectedValue();
            GrupoController grControl = new GrupoController(JardinController.getGrupo(idGrupo));
            grControl.eliminarNinnosGrupo();
            JardinController.getGrupos().remove(JardinController.getGrupo(idGrupo));
            grLlenarGruposList();
        }
        
    }//GEN-LAST:event_grBorrarGrupoBotonActionPerformed

    /**
     * Almacena la informacion y cierra el programa
     * @param evt 
     */
    private void salirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirBotonActionPerformed
        Almacenamiento.almacenarRegistros();
        System.exit(0);      
    }//GEN-LAST:event_salirBotonActionPerformed

    /**
     * Almacena la informacion y cierra la sesion, volviendo a login
     * @param evt 
     */
    private void cerrarSesionBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBotonActionPerformed
        Almacenamiento.almacenarRegistros();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_cerrarSesionBotonActionPerformed

    /**
     * De la pestaña profesores, abre la ventana de creacion de profesores
     * @param evt 
     */
    private void prRegistrarProfesorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prRegistrarProfesorBotonActionPerformed
        ProfesorEdit edit = new ProfesorEdit("Registrar Profesor", this);
        edit.setVisible(true);
    }//GEN-LAST:event_prRegistrarProfesorBotonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel NombreLabel11;
    private javax.swing.JLabel NombreLabel4;
    private javax.swing.JLabel NombreLabel5;
    private javax.swing.JLabel NombreLabel6;
    private javax.swing.JLabel NombreLabel7;
    private javax.swing.JLabel NombreLabel8;
    private javax.swing.JLabel NombreLabel9;
    private javax.swing.JList<String> adAdminList;
    private javax.swing.JLabel adApellidoLabel;
    private javax.swing.JButton adBorrarBoton;
    private javax.swing.JButton adEditarBoton;
    private javax.swing.JLabel adIdLabel;
    private javax.swing.JLabel adIdTypeLabel;
    private javax.swing.JLabel adNombreLabel;
    private javax.swing.JButton adRegistrarBoton;
    private javax.swing.JButton cerrarSesionBoton;
    private javax.swing.JButton grBorrarGrupoBoton;
    private javax.swing.JButton grCrearGrupoBoton;
    private javax.swing.JButton grEditarGrupoBoton;
    private javax.swing.JLabel grGrupoLabel;
    private javax.swing.JList<String> grGruposList;
    private javax.swing.JLabel grHorarioLabel;
    private javax.swing.JLabel grNinnoLabel;
    private javax.swing.JList<String> grNinnosList;
    private javax.swing.JLabel grNivelLabel;
    private javax.swing.JLabel grProfesorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel niAcudienteLabel;
    private javax.swing.JLabel niApellidoLabel;
    private javax.swing.JButton niAsignarGrupoBoton;
    private javax.swing.JButton niBorrarNinnoBoton;
    private javax.swing.JLabel niEdadLabel;
    private javax.swing.JButton niEditarNinnoBoton;
    private javax.swing.JButton niEliminarNinnoBoton2;
    private javax.swing.JLabel niEspecialLabel;
    private javax.swing.JLabel niGeneroLabel;
    private javax.swing.JLabel niGrupoLabel;
    private javax.swing.JLabel niHorarioLabel;
    private javax.swing.JLabel niIdLabel;
    private javax.swing.JLabel niIdTypeLabel;
    private javax.swing.JLabel niNacimientoLabel;
    private javax.swing.JList<String> niNinnosList;
    private javax.swing.JLabel niNombreLabel;
    private javax.swing.JLabel niPariente1Label;
    private javax.swing.JLabel niPariente2Label;
    private javax.swing.JLabel niParienteInfo1Label;
    private javax.swing.JLabel niParienteInfo2Label;
    private javax.swing.JLabel niPesoLabel;
    private javax.swing.JButton niRegistrarNinnoBoton;
    private javax.swing.JLabel niTallaLabel;
    private javax.swing.JLabel prApellidoLabel;
    private javax.swing.JButton prBorrarProfesorBoton;
    private javax.swing.JButton prEditarProfesorBoton;
    private javax.swing.JLabel prEspecialLabel;
    private javax.swing.JLabel prIdLabel;
    private javax.swing.JLabel prIdTypeLabel;
    private javax.swing.JLabel prNombreLabel;
    private javax.swing.JLabel prNumeroLabel;
    private javax.swing.JList<String> prProfesoresList;
    private javax.swing.JButton prRegistrarProfesorBoton;
    private javax.swing.JLabel prTelefonoLabel;
    private javax.swing.JButton salirBoton;
    // End of variables declaration//GEN-END:variables
}
