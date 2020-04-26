package Controller;

import Model.Actores.Ninno;
import Model.Grupo;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Clase para controlar los grupos en la vista
 */
public class GrupoController {
    private Grupo grupo;
    private ArrayList<Ninno> ninnos;

    public GrupoController(Grupo grupo) {
        this.grupo = grupo;
        //Son las funciones lambda mas eficientes que los ciclos for?
        this.ninnos = JardinController.getNinnos().stream()
                .filter(ninno -> grupo.getIdInt() == ninno.getGrupo())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public ArrayList<Ninno> getNinnos() {
        return ninnos;
    }

    public void setNinnos(ArrayList<Ninno> ninnos) {
        this.ninnos = ninnos;
    }
    
    public boolean addNinno(Ninno ninno){
        if(grupo.isNivel(ninno)){
            ninnos.add(ninno);
            ninno.setGrupo(grupo.getIdInt());
            ninno.setHorario(grupo.getHorario());
            return true;
        }
        return false;
    }
    
    public static void addNinno(Ninno ninno, Grupo grupo){
        if(grupo.isNivel(ninno)){
            ninno.setGrupo(grupo.getIdInt());
            ninno.setHorario(grupo.getHorario());
        }
    }
    
}
