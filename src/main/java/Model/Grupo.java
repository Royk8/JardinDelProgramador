package Model;

import Model.Actores.Profesor;

/**
 *
 * @author Royk
 */
public class Grupo {
    private String id;
    private char horario;
    private Profesor profesor;
    
    public Grupo(String id, char horario, Profesor profesor){
        this.id = id;
        this.horario = horario;
        this.profesor = profesor;
    }
    
    public Grupo(int id, char horario, Profesor profesor){
        this(Integer.toString(id), horario, profesor);
    }
    
    public int getIdInt(){
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
    
    
    
    
    
}
