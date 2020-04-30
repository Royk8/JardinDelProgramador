package Model.Actores;

/**
 * Clase modelo del acudiente, hereda de pariente
 * Implementa atributos String de horario, permiso y password
 * @author Royk
 */
public class Acudiente extends Pariente {
    private String horario, permiso, password;

    /**
     * Constructor Vacio
     */
    public Acudiente(){
        
    }    

    /**
     * Constructor Completo
     * @param id
     * @param nombre
     * @param apellido
     * @param idType
     * @param password
     * @param telefono
     * @param celular
     * @param calidad
     * @param direccion
     * @param horario
     * @param permiso 
     */
    public Acudiente(String id, String nombre, String apellido, String idType, 
            String password, String telefono, String celular, String calidad, 
            String direccion, String horario, 
            String permiso) {        
        super(id, nombre, apellido, idType, telefono, celular, calidad, direccion);
        this.horario = horario;
        this.permiso = permiso;
        this.password = password;
    }
    
    /**
     * Constructor que no requiere del campo de permiso
     * Permiso no es necesario si el acudiente es tambien parte del nucleo familiar
     * @param id
     * @param nombre
     * @param apellido
     * @param idType
     * @param password
     * @param telefono
     * @param celular
     * @param calidad
     * @param direccion
     * @param horario 
     */
    public Acudiente(String id, String nombre, String apellido, String idType, 
            String password, String telefono, String celular, String calidad, 
            String direccion, String horario){        
        super(id, nombre, apellido, idType, telefono, celular, calidad, direccion);
        this.password = password;
        this.horario = horario;
        this.permiso = "";
    }

    /**
     * Setter que asigna valor a todas los atributos de la clase
     * @param id
     * @param nombre
     * @param apellido
     * @param idType
     * @param password
     * @param telefono
     * @param celular
     * @param calidad
     * @param direccion
     * @param horario
     * @param permiso 
     */
    public void setAllAcudiente(String id, String nombre, String apellido, String idType, 
            String password, String telefono, String celular, String calidad, 
            String direccion, String horario, String permiso){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.password = password;
        this.telefono = telefono;
        this.celular = celular;
        this.calidad = calidad;
        this.direccion = direccion;
        this.horario = horario;
        this.permiso = permiso;
    }
    
    /**
     * Comprueba si el password enviado como parametro coincide con el almacenado en el perfil
     * @param password Array de caracteres
     * @return Retorna True si coinciden.
     */
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }
        
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }
    

        
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
