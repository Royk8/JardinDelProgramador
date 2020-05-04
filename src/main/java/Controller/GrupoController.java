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

    /**
     * Constructor de la clase, llena el arrayList con los niños del grupo dado
     * @param grupo Grupo del cual se creara el controlador.
     */
    public GrupoController(Grupo grupo) {
        this.grupo = grupo;
        //Son las funciones lambda mas eficientes que los ciclos for?
        this.ninnos = JardinController.getNinnos().stream()
                .filter(ninno -> grupo.getIdInt() == ninno.getGrupo())
                .collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
     * Elimina los ninnos del grupo asociado a esta clase y los pone en el grupo cero
     */
    public void eliminarNinnosGrupo(){
        for(Ninno ninno: ninnos){
            ninno.setGrupo(0);
        }
    }

    /**
     * Get Grupo
     * @return Objeto de la clase Grupo asociado a esta clase
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * Set Grupo
     * @param grupo Objeto de la clase grupo el cual sera asociado a esta clase
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * Get Ninnos
     * @return Arraylist de objetos de la clase ninno
     */
    public ArrayList<Ninno> getNinnos() {
        return ninnos;
    }

    /**
     * Set Ninnos
     * @param ninnos ArrayList de objetos de la clase ninno que reemplaza al asociado a esta clase
     */
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
    
    /**
     * Asocia un ninno y un grupo, asignando el horario y grupoId al ninno
     * @param ninno Objeto de la clase Ninno que sera asociado al grupo
     * @param grupo Objeto de la clase Grupo que sera asociado al ninno
     */
    public static void addNinno(Ninno ninno, Grupo grupo){
        if(grupo.isNivel(ninno)){
            ninno.setGrupo(grupo.getIdInt());
            ninno.setHorario(grupo.getHorario());
        }
    }
    
}
