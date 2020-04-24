package Model.Actores;

public abstract class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private String idType;

    public Persona(String id, String nombre, String apellido, String idType) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
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
    
    public String getNombreCompleto(){
        return nombre + " " + apellido;
    }
    
    public boolean isNombreCompleto(String nombreCompleto){
        return nombreCompleto.equals(nombre + apellido);
    }
    
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}
