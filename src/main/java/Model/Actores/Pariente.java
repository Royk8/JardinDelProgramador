package Model.Actores;

public class Pariente extends Persona {
    protected String telefono, celular;
    protected String calidad, direccion;
    protected String password;
    
    public Pariente(){
        
    }

    public Pariente(String id, String nombre, String apellido, String idType,
            String password, String telefono, String celular, String calidad, 
            String direccion) {
        super(id, nombre, apellido, idType);
        this.password = password;
        this.telefono = telefono;
        this.celular = celular;
        this.calidad = calidad;
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

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public boolean isPassword(char[] password){
        return this.password.equals(new String(password));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
