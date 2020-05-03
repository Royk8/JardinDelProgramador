package Controller;

import Model.Actores.Admin;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
import Model.Grupo;
import Persistencia.Almacenamiento;
import View.Login;
import java.util.ArrayList;

/**
 * Clase encargada de iniciar y controlar el flujo del programa
 * Contiene arrays estaticos que contienen la informacion necesaria durante la ejecucion
 * Contiene metodos estaticos de utilidad para las diferentes partes del programa
 * @author Royk
 */
public class JardinController {
    private static ArrayList<Ninno> ninnos;
    private static ArrayList<Profesor> profesores;
    private static ArrayList<Admin> admins;
    private static ArrayList<Grupo> grupos;
    private static Admin superAdmin;


    /**
     * Constructor de la clase, arranca el programa y llama los metodos que cargan la informacion
     */
    public JardinController(){
        //Inicializa la lista de ninnos.
        Almacenamiento.cargarRegistros();
        admins = new ArrayList<>();
        superAdmin = new Admin();
        admins.add(superAdmin);
        grupoCero();
        
        //cargarGrupos();

        
        /*Acudiente manuel = new Acudiente("5415", "Manuel", "Yarce", "Cedula", 
                "4545", "3104548", "315181", "Tio", "Cada de manuel", "Miercoles en la ma;ana");
        Acudiente gabriela = new Acudiente("546", "Gabriela", "Cordoba", "Cedula", 
                "4455", "32484", "468767", "Mama", "Casa de Gabi", "Miercoles en la ma;ana");
        
        Ninno jhoniercito = new Ninno("1452145","Jhoniercito","Cordoba","Registro Civil",
            2,1,1.1f,20f,"Brutico",'M','T',2000,7,3);
        Ninno alejito = new Ninno("1455236","Alejandro","Yarce","Registro Civil",
            3,1,1.2f,25f,"Brutico",'M','M',1998,12,30);*/
        /*Profesor diana = new Profesor("123456","Diana","Lopez","Cedula","1234","31487965214",
            "Programacion");
        Ninno jhoniercito = getNinno("Jhoniercito");
        Ninno alejito = getNinno("Alejandro");
        /*alejito.setAcudiente(manuel);
        jhoniercito.setAcudiente(gabriela);
        jhoniercito.setProfesor(diana);
        alejito.setProfesor(diana);*/
        
        /*ninnos.add(alejito);
        ninnos.add(jhoniercito);*/
        //profesores.add(diana);
    }
    
    public static Admin getAdmin(String adminId) {
        for(Admin admin: admins){
            if(admin.getId().equals(adminId)){
                return admin;
            }
        }
        return null;
    }
    
    public static void grupoCero(){
        if(grupos.isEmpty()){
            Grupo cero = new Grupo("0",1,'M',null);
            grupos.add(cero);
        }
    }
    
    /**
     * Getter para acceder a la lista general de Ninnos
     * @return ArrayList con Ninnos
     */
    public static ArrayList<Ninno> getNinnos(){
        return ninnos;
    }
    
    /**
     * Retorna un profesor especifico indicado por su Id
     * @param profesorId Id enviada
     * @return Objeto de la clase profesor con el ID buscado
     */
    public static Profesor getProfesor(String profesorId){
        for(Profesor profesor: profesores){
            if(profesor.getId().equals(profesorId)){
                return profesor;
            }
        }
        return null;
    }
    
    /**
     * Retorna un profesor especifico indicado por su nombre completo
     * @param nombreCompleto nombre completo del profesor
     * @return Objeto de la clase profesor con el nombre buscado buscado
     */
    public static Profesor getProfesorCompleto(String nombreCompleto){
        for(Profesor profesor: profesores){
            if(profesor.getNombreCompleto().equals(nombreCompleto)){
                return profesor;
            }
        }
        return null;
    }
    
    /**
     * Retorna un Ninno de la lista general de ninnos especifico indicado por su nombre
     * @param ninnoNombre Nombre del ninno solicitado
     * @return Objeto de la clase Ninno con el nombre buscado o nul si no se encuentra
     */
    public static Ninno getNinno(String ninnoNombre){
        for(Ninno ninno: ninnos){
            if(ninno.getNombre().equals(ninnoNombre)){
                return ninno;
            }
        }
        return null;
    }
    
    /**
     * Retorna un Ninno de la lista general de ninnos especifico indicado por su nombre completo
     * @param nombreCompleto Nombre completo del ninno solicitado
     * @return Objeto de la clase Ninno con el nombre buscado o null si no se encuentra
     */
    public static Ninno getNinnoCompleto(String nombreCompleto){
        for(Ninno ninno: ninnos){
            if(ninno.getNombreCompleto().equals(nombreCompleto)){
                return ninno;
            }
        }
        return null;
    }
    
    /**
     * Para borrar
     */
    /*public void cargarGrupos(){
        grupos = new ArrayList<>();
        for(Ninno ninno: ninnos){
            //Lambda expresion, pregunta si existe algun grupo con este identificador asociado a un ninno
            if(!grupos.stream().anyMatch(grupo -> ninno.getGrupo() == grupo.getIdInt())){
                Grupo grupo = new Grupo(ninno.getGrupo(), 
                        ninno.getEdad(), 
                        ninno.getHorario(), 
                        ninno.getProfesor());
                grupos.add(grupo);
            }
        }
    }*/
    
    /**
     * Retorna un grupo de la lista de grupos, especificado por su id
     * @param grupo Entero con el identificador del grupo
     * @return Objeto de la clase Grupo solicitado o null si no se encuentra
     */
    public static Grupo getGrupo(int grupo){
        for(Grupo gr : grupos){
            if(grupo == gr.getIdInt())
                return gr;
        }
        return null;
    }
    
    /**
     * Retorna un grupo de la lista de grupos, especificado por su id
     * @param grupo String con el identificador del grupo
     * @return Objeto de la clase Grupo solicitado o null si no se encuentra
     */
    public static Grupo getGrupo(String grupo){
        for(Grupo gr : grupos){
            if(grupo.equals(gr.getId()))
                return gr;
        }
        return null;
    }
    
    /**
     * Reemplaza la lista general de ninnos por otra lista enviada
     * @param ninnos Lista de ninnos envidad
     */
    public static void setNinnos(ArrayList<Ninno> ninnos) {
        JardinController.ninnos = ninnos;
    }
    
    /**
     * Retorna la lista general de profesores 
     * @return ArrayList con los profesores registrados
     */
    public static ArrayList<Profesor> getProfesores(){
        return profesores;
    }
    
    /**
     * Retorna un profesor de la lista, especificado por su nombre completo
     * @param nombreCompleto nombre del profesor a buscar
     * @return Retorna profesor solicitado o null si no hay coincidencias
     */
    public static Profesor getProfesorNombreCompleto(String nombreCompleto){
        for(Profesor profesor: profesores){
            if(profesor.getNombreCompleto().equals(nombreCompleto))
                return profesor;
        }
        return null;
    }

    /**
     * Reemplaza la lista general de profesores por una lista enviada
     * @param profesores Lista de profesores enviada
     */
    public static void setProfesores(ArrayList<Profesor> profesores) {
        JardinController.profesores = profesores;
    }

    /**
     * Reemplaza la lista general de administradores por una lista enviada
     * @param admins Lista de administradores enviada
     */
    public static void setAdmins(ArrayList<Admin> admins) {
        JardinController.admins = admins;
    }

    /**
     * Reemplaza la lista general de grupos por una lista enviada
     * @param grupos Lista de grupos enviada
     */
    public static void setGrupos(ArrayList<Grupo> grupos) {
        JardinController.grupos = grupos;
    }
    
    /**
     * Retorna la lista general de grupos
     * @return ArrayList con los grupos registrados
     */
    public static ArrayList<Grupo> getGrupos(){
        return grupos;
    }
    
    /**
     * Metodo main que aranca el programa al instancias un objeto de esta clase
     * Instancia un objeto de la ventana de Login
     * @param args 
     */
    public static void main(String[] args) {
        JardinController jardinController = new JardinController();
        Login login = new Login();
        login.setVisible(true);
    }
}