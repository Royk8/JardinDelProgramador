package Model.Actores;

import Model.Logro;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ninno extends Persona{
    private int edad, grupo;
    private float talla, peso;
    private String situacionEspecial;
    private char genero, horario;
    private LocalDate fechaDeNacimiento;
    private ArrayList<Logro> logros;
    private Acudiente acudiente;
    private ArrayList<Pariente> parientes;
    private Profesor profesor;
    
    public Ninno(){
        logros = new ArrayList<>();
        parientes = new ArrayList<>();
    }

    public Ninno(String id, String nombre, String apellido, String idType, int edad, int grupo, float talla,
                 float peso, String situacionEspecial, char genero, char horario, int year, int month, int day) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = grupo;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.horario = horario;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        logros = new ArrayList<Logro>();
        parientes = new ArrayList<Pariente>();
    }
    
    public Ninno(String id, String nombre, String apellido, String idType, 
                int edad, int grupo, float talla, float peso, String situacionEspecial,
                char genero, char horario, int year, int month, int day, 
                Acudiente acudiente) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = grupo;
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
    
    public Ninno(String id, String nombre, String apellido, String idType, 
                int edad, int grupo, float talla, float peso, String situacionEspecial,
                char genero, char horario, int year, int month, int day, 
                Acudiente acudiente, ArrayList<Pariente> parientes) {
        super(id, nombre, apellido, idType);
        this.edad = edad;
        this.grupo = grupo;
        this.talla = talla;
        this.peso = peso;
        this.situacionEspecial = situacionEspecial;
        this.genero = genero;
        this.horario = horario;
        this.fechaDeNacimiento = LocalDate.of(year,month,day);
        logros = new ArrayList<Logro>();
        this.parientes = parientes;
        this.acudiente = acudiente;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
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
    
    public boolean isEmpty(){
        return id == null;
    }
    
    
    
}
