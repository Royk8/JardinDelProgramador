package Model.Actores;

public class Acudiente extends Pariente {
    private String horario, permiso;

    public Acudiente(){
        
    }    

    public Acudiente(String id, String nombre, String apellido, String idType, 
            String password, String telefono, String celular, String calidad, 
            String direccion, String horario, 
            String permiso) {        
        super(id, nombre, apellido, idType, password, telefono, celular, calidad, direccion);
        this.horario = horario;
        this.permiso = permiso;
    }
    
    public Acudiente(String id, String nombre, String apellido, String idType, 
            String password, String telefono, String celular, String calidad, 
            String direccion, String horario){        
        super(id, nombre, apellido, idType, password, telefono, celular, calidad, direccion);
        this.horario = horario;
        this.permiso = "";
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
    
    public boolean isEmpty(){
        return id == null;
    }
    
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
}
