package Persistencia;

import Controller.JardinController;
import Model.Actores.Acudiente;
import Model.Actores.Ninno;
import Model.Actores.Pariente;
import Model.Actores.Profesor;
import Model.Grupo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Aqui se gestiona el almacenamiento de los archivos en ROM
 * @author Royk
 */
public class Almacenamiento {
    
      
    public static void cargarRegistros(){
        JardinController.setNinnos(cargarNinnos(cargarInformacion("Ninnos")));
        JardinController.setProfesores(cargarProfesores(cargarInformacion("Profesores")));
        JardinController.setGrupos(cargarGrupos(cargarInformacion("Grupos")));
    }
    
    public static void almacenarRegistros(){
        almacenarNinnos(JardinController.getNinnos());
        almacenarProfesores(JardinController.getProfesores());
        almacenarGrupos(JardinController.getGrupos());
    }
    
    public static void almacenarNinnos(ArrayList<Ninno> ninnos){
        JSONArray jsonNinnos = new JSONArray();
        for(Ninno ninno: ninnos){
            JSONObject campos = new JSONObject();
            campos.put("id", ninno.getId());
            campos.put("nombre", ninno.getNombre());
            campos.put("apellido", ninno.getApellido());
            campos.put("idType", ninno.getIdType());
            campos.put("edad", String.valueOf(ninno.getEdad()));
            campos.put("grupo", String.valueOf(ninno.getGrupo()));
            campos.put("talla", String.valueOf(ninno.getTalla()));
            campos.put("peso", String.valueOf(ninno.getPeso()));
            campos.put("situacionEspecial", ninno.getSituacionEspecial());
            campos.put("genero", String.valueOf(ninno.getGenero()));
            campos.put("horario", String.valueOf(ninno.getHorario()));
            campos.put("year", String.valueOf(ninno.getNacimiento().getYear()));
            campos.put("month", String.valueOf(ninno.getNacimiento().getMonthValue()));
            campos.put("day", String.valueOf(ninno.getNacimiento().getDayOfMonth()));
            campos.put("Acudiente", cifrarAcudiente(ninno.getAcudiente()));
            campos.put("Parientes", cifrarParientes(ninno.getParientes()));
            String profesorid;
            try{
                profesorid = ninno.getProfesor();
            }catch(NullPointerException nu){
                profesorid = " ";
            }
            campos.put("profesorId", profesorid);
            
            jsonNinnos.add(campos);
        }
        almacenarInformacion("Ninnos", jsonNinnos);
    }
    
    public static void almacenarProfesores(ArrayList<Profesor> profesores){
        JSONArray jsonProfesores = new JSONArray();
        for(Profesor profesor: profesores){
            JSONObject campos = new JSONObject();
            campos.put("id", profesor.getId());
            campos.put("nombre", profesor.getNombre());
            campos.put("apellido", profesor.getApellido());
            campos.put("idType", profesor.getIdType());
            campos.put("password", profesor.getPassword());
            campos.put("especialidad", profesor.getEspecialidad());
            campos.put("telefono", profesor.getTelefono());
            
            JSONObject jsonProfesor = new JSONObject();
            jsonProfesor.put("Profesor", campos);
            jsonProfesores.add(jsonProfesor);
        }
        almacenarInformacion("Profesores", jsonProfesores);
    }
        
    public static void almacenarGrupos(ArrayList<Grupo> grupos){
        JSONArray jsonGrupos = new JSONArray();
        for(Grupo grupo : grupos){
            JSONObject campos = new JSONObject();
            campos.put("id", grupo.getId());
            campos.put("nivel", Integer.toString(grupo.getNivel()));
            campos.put("horario", Character.toString(grupo.getHorario()));
            
            campos.put("profesorId", (grupo.getProfesor()!=null)? grupo.getProfesor().getId():"");
            
            jsonGrupos.add(campos);
        }
        almacenarInformacion("Grupos", jsonGrupos);
    }
    
    public static JSONArray cifrarParientes(ArrayList<Pariente> parientes){
        JSONArray jsonParientes = new JSONArray();
        for(Pariente pariente : parientes){
            JSONObject campos = new JSONObject();
            campos.put("id", pariente.getId());
            campos.put("nombre", pariente.getNombre());
            campos.put("apellido", pariente.getApellido());
            campos.put("idType", pariente.getIdType());
            campos.put("telefono", pariente.getTelefono());
            campos.put("celular", pariente.getCelular());
            campos.put("calidad", pariente.getCalidad());
            campos.put("direccion", pariente.getDireccion());
            JSONObject jsonPariente = new JSONObject();
            jsonParientes.add(campos);
        }
        return jsonParientes;
    }
    
    public static JSONObject cifrarAcudiente(Acudiente acudiente){
        JSONObject campos = new JSONObject();
        campos.put("id", acudiente.getId());
        campos.put("nombre", acudiente.getNombre());
        campos.put("apellido", acudiente.getApellido());
        campos.put("idType", acudiente.getIdType());
        campos.put("password", acudiente.getPassword());
        campos.put("telefono", acudiente.getTelefono());
        campos.put("celular", acudiente.getCelular());
        campos.put("calidad", acudiente.getCalidad());
        campos.put("direccion", acudiente.getDireccion());
        campos.put("horario", acudiente.getHorario());
        campos.put("permiso", acudiente.getPermiso());
        return campos;
    }
    
    public static Acudiente descifrarAcudiente(JSONObject jsonAcudiente){
        if(jsonAcudiente !=null){
            Acudiente acudiente = new Acudiente(jsonAcudiente.get("id").toString(),
                jsonAcudiente.get("nombre").toString(), 
                jsonAcudiente.get("apellido").toString(),
                jsonAcudiente.get("idType").toString(),
                jsonAcudiente.get("password").toString(),
                jsonAcudiente.get("telefono").toString(),
                jsonAcudiente.get("celular").toString(),
                jsonAcudiente.get("calidad").toString(),
                jsonAcudiente.get("direccion").toString(),
                jsonAcudiente.get("horario").toString(),
                jsonAcudiente.get("permiso").toString());
            return acudiente;
        }
        return null;
    }
    
    public static ArrayList<Pariente> descifrarParientes(JSONArray jsonParientes){
        ArrayList<Pariente> parientes = new ArrayList<>();
        if(jsonParientes != null){
            for(Object registro : jsonParientes){
                JSONObject jsonRegistro = (JSONObject) registro;
                Pariente pariente = new Pariente(jsonRegistro.get("id").toString(),
                    jsonRegistro.get("nombre").toString(), 
                    jsonRegistro.get("apellido").toString(),
                    jsonRegistro.get("idType").toString(),
                    jsonRegistro.get("telefono").toString(),
                    jsonRegistro.get("celular").toString(),
                    jsonRegistro.get("calidad").toString(),
                    jsonRegistro.get("direccion").toString());
                parientes.add(pariente);
            }
        }
        return parientes;
    }
    
    public static void guardarCampo(String etiqueta, String dato){
        
    }
    

    
    /**
     * Metodo que toma un JSONArray y lo guarda en un archivo tipo JSON
     * @param nombreArchivo: Nombre del archivo en el que guardara la informacion
     * @param informacion : Informacion en forma de JSONArray que sera almacenada
     */
    public static void almacenarInformacion(String nombreArchivo, JSONArray informacion){
        try(FileWriter file = new FileWriter(nombreArchivo + ".json")){
            file.write(informacion.toJSONString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("Informacion Almacenada");
    }
    
    public static ArrayList<Ninno> cargarNinnos(JSONArray jsonNinnos){
        ArrayList<Ninno> ninnos = new ArrayList<>();
        
        if(jsonNinnos!=null){        
            for(Object registro: jsonNinnos){

                JSONObject jsonRegistro = (JSONObject) registro;
                
                //problemas con situacion especial
                String situacionEspecial;
                try{
                    situacionEspecial = jsonRegistro.get("situacionEspecial").toString();
                }catch(NullPointerException nu){
                    situacionEspecial = "Ninguna";
                }        
                
                Ninno ninno = new Ninno(jsonRegistro.get("id").toString(), 
                    jsonRegistro.get("nombre").toString(), 
                    jsonRegistro.get("apellido").toString(), 
                    jsonRegistro.get("idType").toString(),
                    Integer.parseInt(jsonRegistro.get("edad").toString()),
                    Integer.parseInt(jsonRegistro.get("grupo").toString()),
                    Float.parseFloat(jsonRegistro.get("talla").toString()),
                    Float.parseFloat(jsonRegistro.get("peso").toString()),
                    situacionEspecial,
                    jsonRegistro.get("genero").toString().charAt(0),
                    jsonRegistro.get("horario").toString().charAt(0),
                    Integer.parseInt(jsonRegistro.get("year").toString()),
                    Integer.parseInt(jsonRegistro.get("month").toString()),
                    Integer.parseInt(jsonRegistro.get("day").toString()),
                    descifrarAcudiente((JSONObject) jsonRegistro.get("Acudiente")),
                    descifrarParientes((JSONArray) jsonRegistro.get("Parientes")),
                    jsonRegistro.get("profesorId").toString());
                ninnos.add(ninno);
            }
        }
        return ninnos;
    }
    
    public static ArrayList<Profesor> cargarProfesores(JSONArray jsonProfesores){
        ArrayList<Profesor> profesores = new ArrayList<>();
        
        if(jsonProfesores != null){
            for(Object registro: jsonProfesores){
                
                JSONObject jsonRegistro = (JSONObject) registro;
                jsonRegistro = (JSONObject) jsonRegistro.get("Profesor");
                Profesor profesor = new Profesor(jsonRegistro.get("id").toString(),
                    jsonRegistro.get("nombre").toString(),
                    jsonRegistro.get("apellido").toString(),
                    jsonRegistro.get("idType").toString(),
                    jsonRegistro.get("password").toString(),
                    jsonRegistro.get("telefono").toString(), 
                    jsonRegistro.get("especialidad").toString());
                profesores.add(profesor);
            }
        }        
        return profesores;        
    }
    
    public static ArrayList<Grupo> cargarGrupos(JSONArray jsonGrupos){
        ArrayList<Grupo> grupos = new ArrayList<>();
        
        if(jsonGrupos != null){
            for(Object registro : jsonGrupos){
                
                JSONObject jsonRegistro = (JSONObject) registro;
                
                //problemas con profesor
                Profesor profesor;
                try{
                    profesor = JardinController.getProfesor(jsonRegistro.get("profesorId").toString());
                }catch(NullPointerException ne){
                    profesor = null;
                }
                
                Grupo grupo = new Grupo(jsonRegistro.get("id").toString(),
                        Integer.valueOf(jsonRegistro.get("nivel").toString()),
                        jsonRegistro.get("horario").toString().charAt(0),
                        profesor);
                grupos.add(grupo);
            }
        }
        return grupos;
    }
    
    /**
     * Metodo que carga un archivo json y devuelve su informacion como un JSONArray
     * @param nombreArchivo: nombre del archivo a recuperar
     * @return JSONArray con varios objetos de una clase. Null, y hay algun problema con el archivo
     */
    public static JSONArray cargarInformacion(String nombreArchivo){
        //Parser para convertir la informacion en el json en un objeto de java
        JSONParser parser = new JSONParser();
        JSONArray registro = null;
        //Se intenta leer un archivo
        try(FileReader reader = new FileReader(nombreArchivo + ".json")){
            //lee todo el array como un solo objeto
            Object obj = parser.parse(reader);
            //Convierte dicho objeto en un JsonArray el cual devuelve.
            registro = (JSONArray) obj;
        }catch(FileNotFoundException fe){
            System.out.println("Registro de " + nombreArchivo + " no existe");
        }catch(IOException io){
            System.out.println("Registro de " + nombreArchivo + " no se pudo cargar");
        }catch(ParseException pe){
            System.out.println("Registro de " + nombreArchivo + " falló al recuperarse");
        }
        
        System.out.println(nombreArchivo + " cargados.");        
        return registro;
    }
}
