package Model.Actores;

/**
 * Clase modelo para los perfiles de administrador
 * Hereda de persona y agrega el atributo password
 * @author Royk
 */
public class Admin extends Persona{
    private String password;

    /**
     * Constructor basico que recibe todos los tributos 
     * @param id String con el id del administrador
     * @param nombre String con el nombre del administrador
     * @param apellido String con el apellido del administrador
     * @param idType String con el tipo de identificacion del administrador
     */
    public Admin(String id, String nombre, String apellido, String idType, String password) {
        super(id, nombre, apellido, idType);
        this.password = password;
    }

    /**
     * Constructor prestablecido para el primer administrados
     * Crea un admin con nombre y apellido admin, 
     * Identificacion 123456
     * Y contraseña admin
     */
    public Admin(){
        super("123456", "admin", "admin", "Cedula");
        password = "admin";
    }
    
    /**
     * Comprueba si el password recibido coincide con el enviado como parametro
     * @param password recibido como parametro en forma de array de caracteres
     * @return True si los password coinciden
     */
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }
}
