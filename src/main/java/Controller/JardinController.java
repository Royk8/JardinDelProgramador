package Controller;

import Model.Actores.Acudiente;
import Model.Actores.Admin;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
import Persistencia.Almacenamiento;
import View.Login;
import java.util.ArrayList;

/**
 * @author Royk
 */
public class JardinController {
    private static ArrayList<Ninno> ninnos;
    private static ArrayList<Profesor> profesores;
    private static ArrayList<Admin> admins;
    private static Admin superAdmin;

    public static Admin getAdmin(String adminId) {
        for(Admin admin: admins){
            if(admin.getId().equals(adminId)){
                return admin;
            }
        }
        return null;
    }
    
    public JardinController(){
        Almacenamiento.cargarRegistros();
        profesores = new ArrayList<>();
        admins = new ArrayList<>();
        superAdmin = new Admin();
        admins.add(superAdmin);
        /*Acudiente manuel = new Acudiente("5415", "Manuel", "Yarce", "Cedula", 
                "4545", "3104548", "315181", "Tio", "Cada de manuel", "Miercoles en la ma;ana");
        Acudiente gabriela = new Acudiente("546", "Gabriela", "Cordoba", "Cedula", 
                "4455", "32484", "468767", "Mama", "Casa de Gabi", "Miercoles en la ma;ana");*/
        
        /*Ninno jhoniercito = new Ninno("1452145","Jhoniercito","Cordoba","Registro Civil",
            2,1,1.1f,20f,"Brutico",'M','T',2000,7,3);
        Ninno alejito = new Ninno("1455236","Alejandro","Yarce","Registro Civil",
            3,1,1.2f,25f,"Brutico",'M','M',1998,12,30);*/
        Profesor diana = new Profesor("123456","Diana","Lopez","Cedula","1234","31487965214",
            "Programacion");
        //Ninno jhoniercito = getNinno("Jhoniercito");
        //Ninno alejito = getNinno("Alejandro");
        /*alejito.setAcudiente(manuel);
        jhoniercito.setAcudiente(gabriela);
        jhoniercito.setProfesor(diana);
        alejito.setProfesor(diana);
        
        ninnos.add(alejito);
        ninnos.add(jhoniercito);*/
        profesores.add(diana);
    }
    
    public static ArrayList<Ninno> getNinnos(){
        return ninnos;
    }
    
    public static Profesor getProfesor(String profesorId){
        for(Profesor profesor: profesores){
            if(profesor.getId().equals(profesorId)){
                return profesor;
            }
        }
        return null;
    }
    
    public static Ninno getNinno(String ninnoNombre){
        for(Ninno ninno: ninnos){
            if(ninno.getNombre().equals(ninnoNombre)){
                return ninno;
            }
        }
        return null;
    }
    
    public static Ninno getNinnoCompleto(String nombreCompleto){
        for(Ninno ninno: ninnos){
            if(ninno.getNombreCompleto().equals(nombreCompleto)){
                return ninno;
            }
        }
        return null;
    }
    
    

    public static void setNinnos(ArrayList<Ninno> ninnos) {
        JardinController.ninnos = ninnos;
    }

    public static void setProfesores(ArrayList<Profesor> profesores) {
        JardinController.profesores = profesores;
    }

    public static void setAdmins(ArrayList<Admin> admins) {
        JardinController.admins = admins;
    }
    
    public static void main(String[] args) {
        JardinController jardinController = new JardinController();
        Login login = new Login();
        login.setVisible(true);
    }
}