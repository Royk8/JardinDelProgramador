package Model.Actores;

/**
 * Modelo de los parientes
 Hereda de persona y añade los atriburos String de telefono, celular, parentesco y direccion
 * @author Royk
 */
public class Pariente extends Persona {
    protected String telefono, celular;
    protected String parentesco, direccion;
    
    /**
     * Constructor vacio
     */
    public Pariente(){
        
    }

    /**
     * Constructor completo
     * @param id String con la identificacion
     * @param nombre String con el nombre
     * @param apellido String con el apellido
     * @param idType String con el tipo de identificacion
     * @param telefono String con el numero de telefono
     * @param celular String con el numero de celular
     * @param parentesco String con el parentesco al ninno
     * @param direccion String con el nombre del ninno
     */
    public Pariente(String id, String nombre, String apellido, String idType,
            String telefono, String celular, String parentesco, String direccion) {
        super(id, nombre, apellido, idType);
        this.telefono = telefono;
        this.celular = celular;
        this.parentesco = parentesco;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    /**
     * Setter completo
     * @param id String con la identificacion
     * @param nombre String con el nombre
     * @param apellido String con el apellido
     * @param idType String con el tipo de identificacion
     * @param telefono String con el numero de telefono
     * @param celular String con el numero de celular
     * @param parentesco String con el parentesco al ninno
     * @param direccion String con el nombre del ninno
     */
    public void setAll(String id, String nombre, String apellido, String idType,
            String telefono, String celular, String parentesco, 
            String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.telefono = telefono;
        this.celular = celular;
        this.parentesco = parentesco;
        this.direccion = direccion;
    }
    

    
    
}
