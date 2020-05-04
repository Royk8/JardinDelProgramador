package Controller;

import Model.Actores.Ninno;
import Model.Actores.Profesor;
import java.util.ArrayList;

/**
 * Clase pensada para controlar la vista de profesor, contiene la informacion
 * del profesor y su lista de estudiantes.
 * @author Royk
 */
public class ProfesorController {
    private Profesor profesor;
    private ArrayList<Ninno> ninnos;
    //Pense que la usaria mas, debo replantear su existencia

    /**
     * Recibe un objeto profesor y crea un Arraylist con sus estudiantes
     * @param profesor Profesor a asociar a esta clase
     */
    public ProfesorController(Profesor profesor){
        this.profesor = profesor;
        ninnos = new ArrayList<>();
        ArrayList<Ninno> ninnosTodos = JardinController.getNinnos();
        for (Ninno ninno: ninnosTodos ) {
            String profesorNinno = ninno.getProfesor();
            if(profesorNinno != null && profesorNinno.equals(profesor.getId())){
                this.ninnos.add(ninno);
            }
        }
    }
    
    /**
     * Getter
     * @return Retornar el ArrayList de objetos de la clase Ninno asociados a esta clase
     */
    public ArrayList<Ninno> getNinnos(){
        return ninnos;
    }
    
    /**
     * Getter 
     * @return Retorna un objeto de la clase Profesor asociado a esta clase
     */
    public Profesor getProfesor(){
        return profesor;
    }
}
