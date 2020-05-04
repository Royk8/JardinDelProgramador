package Model.Actores;

/**
 * Modelo de los profesores del jardin
 * Hereda de persona y añade los atributos String de telefono, especialidad y password
 * @author Royk
 */
public class Profesor extends Persona {
    private String telefono;
    private String especialidad;
    private String password;
    
    /**
     * Constructor
     */
    public Profesor(){
        
    }

    /**
     * Constructor completo
     * @param id String con la identificacion
     * @param nombre String con el nombre
     * @param apellido String con el apellido
     * @param idType String con el tipo de identificacion
     * @param password String con el password
     * @param telefono String con el numero de telefono
     * @param especialidad String con la especialidad del profesor
     */
    public Profesor(String id, String nombre, String apellido, String idType, String password, String telefono, String especialidad) {
        super(id, nombre, apellido, idType);
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.password = password;
    }
    
    /**
     * Setter completo
     * @param id String con la identificacion
     * @param nombre String con el nombre
     * @param apellido String con el apellido
     * @param idType String con el tipo de identificacion
     * @param password String con el password
     * @param telefono String con el numero de telefono
     * @param especialidad String con la especialidad del profesor
     */
    public void setAll(String id, String nombre, String apellido, String idType, 
            String telefono, String especialidad, String password){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.telefono = telefono;
        this.especialidad = especialidad;
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Compara un password enviado como parametro con el asociado al objeto
     * @param password Array de char con el password
     * @return True si coinciden
     */
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }
}
