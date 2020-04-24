package Model.Actores;

/**
 *
 * @author Royk
 */
public class Admin extends Persona{
    private String password;

    public Admin(String id, String nombre, String apellido, String idType) {
        super(id, nombre, apellido, idType);
        password = "123456";
    }

    public Admin(){
        super("123456", "admin", "admin", "Cedula");
        password = "admin";
    }
    
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }
}
