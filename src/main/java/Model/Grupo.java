package Model;

import Model.Actores.Ninno;
import Model.Actores.Profesor;

/**
 * Modelo de un grupo, contiene el id del grupo, el nivel, un horario y un objeto de la clase profesor
 * @author Royk
 */
public class Grupo {
    private String id;
    private int nivel;
    private char horario;
    private Profesor profesor;
    
    /**
     * Constructor vacio
     */
    public Grupo(){
        
    }
    
    /**
     * Constructor completo
     * @param id String de identificacion del grupo
     * @param nivel de los ninnos del grupo
     * @param horario a la que se dicta el grupo, tipo char M para mañana y T para tarde
     * @param profesor Objeto de la clase profesor que se asocia a este grupo
     */
    public Grupo(String id, int nivel, char horario, Profesor profesor){
        this.id = id;
        this.nivel = nivel;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    /**
     * Constructor completo
     * @param id Entero con la identificacion del grupo
     * @param nivel de los ninnos del grupo
     * @param horario a la que se dicta el grupo, tipo char M para mañana y T para tarde
     * @param profesor Objeto de la clase profesor que se asocia a este grupo
     */
    public Grupo(int id, int nivel, char horario, Profesor profesor){
        this(Integer.toString(id), nivel, horario, profesor);
    }
    
    /**
     * Setter completo, asigna un valor a cada atributo de la clase
     * @param id String con la identificacion del grupo
     * @param nivel de los ninnos del grupo
     * @param horario a la que se dicta el grupo, tipo char M para mañana y T para tarde
     * @param profesor Objeto de la clase profesor que se asocia a este grupo
     */
    public void setAll(String id, int nivel, char horario, Profesor profesor){
        this.id = id;
        this.nivel = nivel;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    /**
     * Getter del id del grupo
     * @return Entero con el id del grupo
     */
    public int getIdInt(){
        if(id.equals("Sin Grupo")) return 0;
        return Integer.valueOf(id);
    }
    
    /**
     * Setter del id del grupo
     * @param id Entero con el id del grupo
     */
    public void setIdInt(int id){
        this.id = Integer.toString(id);
    }

    /**
     * Getter del id del grupo
     * @return id String con el id del grupo
     */
    public String getId() {
        return id;
    }
    
    /**
     * Setter del id del grupo
     * @param id String con el id del grupo
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter del profesor
     * @return Objeto de la clase profesor asociado a la clase
     */
    public Profesor getProfesor() {
        return profesor;
    }

    /**
     * Setter del profesor
     * @param profesor Objeto de la clase Profesor asociado a esta clase
     */
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    /**
     * Getter del horario
     * @return char con el horario
     */
    public char getHorario() {
        return horario;
    }
    
    /**
     * Setter del horario
     * @param horario char con el horario a asociar al esta clase
     */
    public void setHorario(char horario) {
        this.horario = horario;
    }
    
    /**
     * Retorna un booleano de la comparacion de la edad del ninno y el nivel del grupo
     * @param ninno recibe un objeto de la clase ninno a comparar
     * @return Retorna True si la edad del ninno coincide con el nivel del grupo
     */
    public boolean isNivel(Ninno ninno){
        return ninno.getEdad() == nivel;
    }

    /**
     * Getter del nivel
     * @return Entero con el nivel del grupo
     */
    public int getNivel() {
        return nivel;
    }
    
    /**
     * Setter del nivel
     * @param nivel Entero con el nivel que se asociara al grupo
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
