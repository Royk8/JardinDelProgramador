package Model.Actores;

/**
 * Clase abstracta que agrupa todas las clases relacionadas con personas
 * Tiene cuatro atributos String nombre, apellido, tipo de documento y numero de documento
 * @author Royk
 */
public abstract class Persona {
    protected String id;
    protected String nombre;
    protected String apellido;
    protected String idType;

    /**
     * Constructor Vacio
     */
    public Persona(){
        
    }
    
    /**
     * Constructor completo
     * @param id
     * @param nombre
     * @param apellido
     * @param idType 
     */
    public Persona(String id, String nombre, String apellido, String idType) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
    }

    /**
     * A 
     * @param nombreCompleto
     * @return 
     */
    public boolean isNombreCompleto(String nombreCompleto){
        return nombreCompleto.equals(nombre + apellido);
    }
    
    /**
     * Getter que retorna nombre y apellido concatenados
     * @return String 
     */
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
    
    /**
     * Retorna null si es un objeto vacio de esta clase
     * @return 
     */
    public boolean isEmpty(){
        return id == null;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
        
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}
