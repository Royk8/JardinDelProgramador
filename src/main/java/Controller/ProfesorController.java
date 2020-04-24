package Controller;

import Model.Actores.Ninno;
import Model.Actores.Profesor;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Royk
 */
public class ProfesorController {
    private Profesor profesor;
    private ArrayList<Ninno> ninnos;

    public ProfesorController(Profesor profesor){
        ninnos = new ArrayList<>();
        ArrayList<Ninno> ninnosTodos = JardinController.getNinnos();
        /*for (Ninno ninno: ninnosTodos ) {
            if(ninno.getProfesor().getId().equals(profesor.getId())){
                this.ninnos.add(ninno);
            }
        }*/
        ninnos = ninnosTodos.stream()
                .filter(c -> profesor.getId().equals(c.getProfesor().getId()))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    public ArrayList<Ninno> getNinnos(){
        return ninnos;
    }
    
    public Profesor getProfesor(){
        return profesor;
    }
}
