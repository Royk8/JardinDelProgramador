package Model.Actores;

public class Pariente extends Persona {
    protected String telefono, celular;
    protected String calidad, direccion;
    
    public Pariente(){
        
    }

    public Pariente(String id, String nombre, String apellido, String idType,
            String telefono, String celular, String calidad, String direccion) {
        super(id, nombre, apellido, idType);
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
    
    public void setAll(String id, String nombre, String apellido, String idType,
            String telefono, String celular, String calidad, 
            String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.telefono = telefono;
        this.celular = celular;
        this.calidad = calidad;
        this.direccion = direccion;
    }
    

    
    
}
