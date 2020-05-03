package Controller;

import Model.Actores.Ninno;
import Model.Actores.Profesor;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Clase pensada para controlar la vista de profesor, contiene la informacion
 * del profesor y su lista de estudiantes.
 * @author Royk
 */
public class ProfesorController {
    private Profesor profesor;
    private ArrayList<Ninno> ninnos;

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
        /*ninnos = ninnosTodos.stream()
                .filter(c -> profesor.getId().equals(c.getProfesor().getId()))
                .collect(Collectors.toCollection(ArrayList::new));*/
    }
    
    public ArrayList<Ninno> getNinnos(){
        return ninnos;
    }
    
    public Profesor getProfesor(){
        return profesor;
    }
}
