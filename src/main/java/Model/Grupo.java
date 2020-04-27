package Model;

import Model.Actores.Ninno;
import Model.Actores.Profesor;

/**
 *
 * @author Royk
 */
public class Grupo {
    private String id;
    private int nivel;
    private char horario;
    private Profesor profesor;
    
    public Grupo(){
        
    }
    
    public Grupo(String id, int nivel, char horario, Profesor profesor){
        this.id = id;
        this.nivel = nivel;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    public Grupo(int id, int nivel, char horario, Profesor profesor){
        this(Integer.toString(id), nivel, horario, profesor);
    }
    
    public void setAll(String id, int nivel, char horario, Profesor profesor){
        this.id = id;
        this.nivel = nivel;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    public int getIdInt(){
        if(id.equals("Sin Grupo")) return 0;
        return Integer.valueOf(id);
    }
    
    public void setIdInt(int id){
        this.id = Integer.toString(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public char getHorario() {
        return horario;
    }

    public void setHorario(char horario) {
        this.horario = horario;
    }
    
    public boolean isNivel(Ninno ninno){
        return ninno.getEdad() == nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
    
}
