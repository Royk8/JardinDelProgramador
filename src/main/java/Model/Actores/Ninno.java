package Model.Actores;

import Model.Logro;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Hereda de Persona, modelo central del programa
 * Implementa los atributos de edad, grupo, talla, pero, situacion especial,genero, horario
 * fecha de nacimiento, acudiente, profesor, y arrays de logros y parientes
 * @author Royk
 */
public class Ninno extends Persona{
    private int edad, grupo;
    private float talla, peso;
    private String situacionEspecial;
    private char genero, horario;
    private LocalDate fechaDeNacimiento;
    private ArrayList<Logro> logros;
    private Acudiente acudiente;
    private ArrayList<Pariente> parientes;
    private String profesor;
    
    /**
     * Constructor casi vacio, inicializa los arrayLists.
     */
    public Ninno(){
        logros = new ArrayList<>();
        parientes = new ArrayList<>();
    }

    /**
     * Constructor que recibe casi todos los parametros
     * @param id String con nueva identificacion
     * @param nombre String con nuevo nombre
     * @param apellido String con nuevo apellido
     * @param idType String con nuevo tipo de documento
     * @param edad Styring con nueva edad
     * @param talla String con nueva talla
     * @param peso String con nuevo peso
     * @param situacionEspecial String con nueva situacion especial
     * @param genero char con nuevo genero
     * @param horario char con el horario del ninno
     * @param year entero con nuevo año de nacimiento
     * @param month Entero con nuevo mes de nacimiento
     * @param day entero con nuevo dia de nacimiento
     */
    public Ninno(String id, String nombre, String apellido, String idType, int edad, float talla,
                 float peso, String situacionEspecial, char genero, char horario, int year, int month, int day) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = 0;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.horario = horario;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        logros = new ArrayList<Logro>();
        parientes = new ArrayList<Pariente>();
    }
    
     /**
     * Constructor que recibe casi todos los parametros
     * @param id String con nueva identificacion
     * @param nombre String con nuevo nombre
     * @param apellido String con nuevo apellido
     * @param idType String con nuevo tipo de documento
     * @param edad Styring con nueva edad
     * @param talla String con nueva talla
     * @param peso String con nuevo peso
     * @param situacionEspecial String con nueva situacion especial
     * @param genero char con nuevo genero
     * @param horario char con el horario del ninno
     * @param year entero con nuevo año de nacimiento
     * @param month Entero con nuevo mes de nacimiento
     * @param day entero con nuevo dia de nacimiento
     * @param acudiente Objeto de la clase acudiente 
     */
    public Ninno(String id, String nombre, String apellido, String idType, 
                int edad, float talla, float peso, String situacionEspecial,
                char genero, char horario, int year, int month, int day, 
                Acudiente acudiente) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = 0;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.horario = horario;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        logros = new ArrayList<Logro>();
        parientes = new ArrayList<Pariente>();
        this.acudiente = acudiente;
        //this.profesor = profesor;
    }
    
     /**
     * Constructor completo que recibe todos los parametros
     * @param id String con nueva identificacion
     * @param nombre String con nuevo nombre
     * @param apellido String con nuevo apellido
     * @param idType String con nuevo tipo de documento
     * @param grupo
     * @param edad Styring con nueva edad
     * @param talla String con nueva talla
     * @param peso String con nuevo peso
     * @param situacionEspecial String con nueva situacion especial
     * @param genero char con nuevo genero
     * @param horario char con el horario del ninno
     * @param year entero con nuevo año de nacimiento
     * @param month Entero con nuevo mes de nacimiento
     * @param day entero con nuevo dia de nacimiento
     * @param acudiente Objeto de la clase acudiente
     * @param parientes Arraylist con los parientes del ninno
     * @param profesor String con la identificacion del profesor
     * @param logros Arraylist con los logros
     * 
     */
    public Ninno(String id, String nombre, String apellido, String idType, 
                int edad, int grupo, float talla, float peso, String situacionEspecial,
                char genero, char horario, int year, int month, int day, 
                Acudiente acudiente, ArrayList<Pariente> parientes, String profesor, 
                ArrayList<Logro> logros) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = grupo;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.horario = horario;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        this.logros = logros;
        this.parientes = parientes;
        this.acudiente = acudiente;
        this.profesor = profesor;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public float getTalla() {
        return talla;
    }

    public void setTalla(float talla) {
        this.talla = talla;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getSituacionEspecial() {
        return situacionEspecial;
    }

    public void setSituacionEspecial(String situacionEspecial) {
        this.situacionEspecial = situacionEspecial;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public char getHorario() {
        return horario;
    }

    public void setHorario(char horario) {
        this.horario = horario;
    }

    public Acudiente getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(Acudiente acudiente) {
        this.acudiente = acudiente;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    
    public LocalDate getNacimiento(){
        return fechaDeNacimiento;
    }

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public ArrayList<Logro> getLogros() {
        return logros;
    }

    public void setLogros(ArrayList<Logro> logros) {
        this.logros = logros;
    }

    public void agregarLogro(Logro logro){
        logros.add(logro);
    }

    public ArrayList<Pariente> getParientes() {
        return parientes;
    }
    
    public void agregarPariente(Pariente pariente){
        parientes.add(pariente);
    }

    public void setParientes(ArrayList<Pariente> parientes) {
        this.parientes = parientes;
    }
    
    /**
     * Setter completo que asigna un valor a la mayoria de atributos
     * @param id String con nueva identificacion
     * @param nombre String con nuevo nombre
     * @param apellido String con nuevo apellido
     * @param idType String con nuevo tipo de documento
     * @param edad Styring con nueva edad
     * @param talla String con nueva talla
     * @param peso String con nuevo peso
     * @param situacionEspecial String con nueva situacion especial
     * @param genero char con nuevo genero
     * @param year entero con nuevo año de nacimiento
     * @param month Entero con nuevo mes de nacimiento
     * @param day entero con nuevo dia de nacimiento
     * @param acudiente Objeto de la clase acudiente
     */
    public void setAll(String id, String nombre, String apellido, String idType, 
                int edad, float talla, float peso, String situacionEspecial,
                char genero, int year, int month, int day, 
                Acudiente acudiente){        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idType = idType;
        this.edad = edad;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        this.acudiente = acudiente;
    }
    
    /**
     * Compara este objeto a null
     * @return True si el ninno es null
     */
    public boolean isEmpty(){
        return id == null;
    }
    
    /**
     * Busca en la lista de logros y retorna uno que coincida con el titulo enviado como parametro
     * @param titulo String con el titulo a buscar
     * @return Objeto de la clase logro a retornar, retorna null si no hay coincidencias
     */
    public Logro getLogro(String titulo){
        for(Logro logro: logros){
            if(logro.getTitulo().equals(titulo))
                return logro;
        }
        return null;
    }
    
    /**
     * Metodo que cuenta cuantos logros de la lista de logros estan completados
     * @return String con el mensaje de X logros completados
     */
    public String logrosCompletos(){
        int completados = 0;
        for(Logro logro: logros){
            if(logro.isCompletado()) completados++;
        }
        return completados + " logro"+((logros.size() == 1)? " ":"s ")+"completado" + ((completados == 1)? " ":"s ");
    }
    
}
