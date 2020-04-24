package Persistencia;

import Controller.JardinController;
import Model.Actores.Ninno;
import Model.Actores.Profesor;
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
            campos.put("genero", ninno.getGenero());
            campos.put("horario", ninno.getHorario());
            campos.put("year", ninno.getNacimiento().getYear());
            campos.put("month", ninno.getNacimiento().getMonth());
            campos.put("day", ninno.getNacimiento().getDayOfMonth());
            
            JSONObject jsonNinno = new JSONObject();
            jsonNinno.put("Ninno", campos);
            jsonNinnos.add(jsonNinno);
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
        
        for(Object registro: jsonNinnos){
            JSONObject jsonRegistro = (JSONObject) registro;
            Ninno ninno = new Ninno(jsonRegistro.get(id), nombre, apellido, 
                    idType, 0, 0, 0, 0, situacionEspecial, 0, 0, 0, 0, 0);
        }
        
        return ninnos;
    }
    
    /**
     * Metodo que carga un archivo json y devuelve su informacion como un JSONArray
     * @param nombreArchivo: nombre del archivo a recuperar
     * @return JSONArray con varios objetos de una clase. Null, y hay algun problema con el archivo
     */
    public static JSONArray cargarInformacion(String nombreArchivo){
        //Parser para convertir la informacion en el json en un objeto de java
        JSONParser jSONParser = new JSONParser();
        //Se intenta leer un archivo
        try(FileReader reader = new FileReader(nombreArchivo + ",json")){
            //lee todo el array como un solo objeto
            Object obj = jSONParser.parse(reader);
            //Convierte dicho objeto en un JsonArray el cual devuelve.
            JSONArray registro = (JSONArray) obj;
            return registro;
        }catch(FileNotFoundException fe){
            System.out.println("Registro de " + nombreArchivo + " no existe");
        }catch(IOException io){
            System.out.println("Registro de " + nombreArchivo + " no se pudo cargar");
        }catch(ParseException pe){
            System.out.println("Registro de " + nombreArchivo + " fallo al recuperarse");
        }
        
        return null;
    }
}
