package Persistencia;

import Controller.JardinController;
import Model.Actores.Acudiente;
import Model.Actores.Ninno;
import Model.Actores.Pariente;
import Model.Actores.Profesor;
import Model.Grupo;
import Model.Logro;
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
    
    /**
     * Metodo estatico que intenta cargar todos los registros almacenados en archivos .json
     */
    public static void cargarRegistros(){
        JardinController.setNinnos(cargarNinnos(cargarInformacion("Ninnos")));
        JardinController.setProfesores(cargarProfesores(cargarInformacion("Profesores")));
        JardinController.setGrupos(cargarGrupos(cargarInformacion("Grupos")));
    }
    
    /**
     * Metodo estatico que almacena los ninnos, profesores y grupos en archivos .json
     */
    public static void almacenarRegistros(){
        almacenarNinnos(JardinController.getNinnos());
        almacenarProfesores(JardinController.getProfesores());
        almacenarGrupos(JardinController.getGrupos());
    }
    
    /**
     * Metodo estatico para almacenar los ninnos en un archivo .json
     * @param ninnos ArrayList de objetos de la clase Ninno a almacenar
     */
    public static void almacenarNinnos(ArrayList<Ninno> ninnos){
        //Se crea un objeto de la clase JSonArray de la libreria json.simple
        JSONArray jsonNinnos = new JSONArray();
        //Se crean objetos JSONObject para almacenar en el JSONArray, este objeto recibe todos los atributos del ninno
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
            campos.put("Logros", cifrarLogros(ninno.getLogros()));
            String profesorid;
            //A veces hay problemas con la obtencion del profesor, como cuando no tiene ninguno asociado
            try{
                profesorid = ninno.getProfesor();
            }catch(NullPointerException nu){
                System.out.println("Problema con profesor");
                profesorid = " ";
            }
            campos.put("profesorId", profesorid);
            
            //Todos los campos son puestos en el jsonArray
            jsonNinnos.add(campos);
        }
        //Se llama al metodo encargado de poner la informacion en archivos .json
        almacenarInformacion("Ninnos", jsonNinnos);
    }
    
    /**
     * Metodo estatico que almacena todos los profesores en un archivo json
     * @param profesores Arraylist con objetos de la clase profesor
     */
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
     * Metodo estatico que almacena todos los grupos en un archivo .json
     * @param grupos Arraylist de grupos
     */
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
    
    /**
     * Metodo estatico que convierte los campos de un acudiente en un JSONObjet
     * @param acudiente Objeto de la clase acudiente
     * @return Objeto de la clase JSONObject con la informacion del acudiente
     */
    public static JSONObject cifrarAcudiente(Acudiente acudiente){
        JSONObject campos = new JSONObject();
        campos.put("id", acudiente.getId());
        campos.put("nombre", acudiente.getNombre());
        campos.put("apellido", acudiente.getApellido());
        campos.put("idType", acudiente.getIdType());
        campos.put("password", acudiente.getPassword());
        campos.put("telefono", acudiente.getTelefono());
        campos.put("celular", acudiente.getCelular());
        campos.put("calidad", acudiente.getParentesco());
        campos.put("direccion", acudiente.getDireccion());
        campos.put("horario", acudiente.getHorario());
        campos.put("permiso", acudiente.getPermiso());
        return campos;
    }
    
    /**
     * Convierte todos los campos de un array de parientes en un JsonArray
     * @param parientes Arraylist de parientes
     * @return Objeto de la clase JSONArray con todos los parientes almacenados
     */
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
            campos.put("calidad", pariente.getParentesco());
            campos.put("direccion", pariente.getDireccion());

            jsonParientes.add(campos);
        }
        return jsonParientes;
    }
    
    /**
     * Metodo estatico que convierte una lista de logros en un JSONArray
     * @param logros Arraylist de logros
     * @return Objeto de la clase JSONArray con los logros almacenados
     */
    public static JSONArray cifrarLogros(ArrayList<Logro> logros){
        JSONArray jsonLogros = new JSONArray();
        for(Logro logro: logros){
            JSONObject campos = new JSONObject();
            campos.put("titulo", logro.getTitulo());
            campos.put("descripcion", logro.getDescripcion());
            campos.put("estado", logro.getEstado());
            campos.put("year", Integer.toString(logro.getBimestre().getYear()));
            campos.put("bimestre",Integer.toString(logro.getBimestre().getNumBimestre()));
            
            jsonLogros.add(campos);
        }
        return jsonLogros;
    }
    
    /**
     * Metodo estatico que extrae un acudiente de on JSONObject
     * @param jsonAcudiente Objeto JSONObject con la informacion del acudiente
     * @return Objeto de la clase acudiente creado con la inforamcion recibida
     */
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
    
    /**
     * Metodo estatico que extrae la informacion de un JSONArray y devuelve un Arraylist de parientes
     * @param jsonParientes JSONArray con la informacion de los parientes
     * @return ArrayList con los parientes creados apartir de la informacion extraida
     */
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
    
    /**
     * Metodo estatico que extrae una lista de logros de un JSONArray
     * @param jsonLogros JSONArray con la informacion de una lista de logros
     * @return Arraylist de logros creado aparitr de la informacion extraida
     */
    public static ArrayList<Logro> descifrarLogros(JSONArray jsonLogros){
        ArrayList<Logro> logros = new ArrayList<>();
        if(jsonLogros != null){
            for(Object registro: jsonLogros){
                JSONObject jsonRegistro = (JSONObject) registro;
                Logro logro = new Logro();
                logro.setAll(jsonRegistro.get("titulo").toString(),
                        Integer.valueOf(jsonRegistro.get("bimestre").toString()),
                        Integer.valueOf(jsonRegistro.get("year").toString()), 
                        jsonRegistro.get("estado").toString(),
                        jsonRegistro.get("descripcion").toString());
                logros.add(logro);
            }
        }
        return logros;
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
    
    /**
     * Metodo estatico que extrae la informacion de un JSONArray a un array de ninnos
     * @param jsonNinnos JSONArray con la informacion de los ninnos
     * @return Arraylist creado con objetos de la clase ninno creados con la informacion del JSONArray
     */
    public static ArrayList<Ninno> cargarNinnos(JSONArray jsonNinnos){
        ArrayList<Ninno> ninnos = new ArrayList<>();
        
        if(jsonNinnos!=null){        
            for(Object registro: jsonNinnos){
                //Extraemos todos los objetos dentro del JSONArray
                JSONObject jsonRegistro = (JSONObject) registro;
                
                //Para luego extraer la informacion de cada uno de esos objetos y ponerlas en un ninno nuevo
                //problemas con situacion especial, a veces no esta definido
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
                    jsonRegistro.get("profesorId").toString(),
                    descifrarLogros((JSONArray) jsonRegistro.get("Logros")));
                // Finalmente agregando el nuevo ninno al array que sera retornado
                ninnos.add(ninno);
            }
        }
        return ninnos;
    }
    
    /**
     * Metodo estatico que carga la informacion de los profesores de un JSONArray
     * @param jsonProfesores JSONArray con la informaciond e los profesores
     * @return Arraylist con objetos de la clase profesor creados apartir de la informacion extraida
     */
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
    
    /**
     * Metodo estatico que extrae la informacion de los grupos de un JSONArray
     * @param jsonGrupos JSONArray con la informacion de los grupos
     * @return Arraylist de grupos creados con la informacion extraida
     */
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
