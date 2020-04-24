package Model.Actores;

public class Profesor extends Persona {
    private String telefono;
    private String especialidad;
    private String password;

    public Profesor(String id, String nombre, String apellido, String idType, String password, String telefono, String especialidad) {
        super(id, nombre, apellido, idType);
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
        
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }
}
