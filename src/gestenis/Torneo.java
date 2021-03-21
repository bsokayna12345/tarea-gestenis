package gestenis;

import java.io.*;
import java.util.ArrayList;


public class Torneo  {
	
    
    private String nombreTorneoneo;
    private int puntuación;
    
    Torneo (String nombreTorneoneo,int puntuación){
        this.nombreTorneoneo=nombreTorneoneo;
        this.puntuación=puntuación;
    }

    /**
     * Devuelve el nombre del torneo
     * @return nombre
     */
    public String getnombreTorneoneo() {
        return nombreTorneoneo;
    }

    /**
     * Asignamos un nombre de torneo
     * @param nombreTorneoneo del torneo
     */
    public void setnombreTorneoneo(String nombreTorneoneo) {
        this.nombreTorneoneo = nombreTorneoneo;
    }

    /**
     * Devuelve la puntuaciónuación asignada al torneo
     * @return - puntuacion
     */
    public int getpuntuación() {
        return puntuación;
    }

    /**
     * Introducimos la puntuaciónuación asignada para el torneo
     * @param puntuacion
     */
    public void setpuntuación(int puntuación) {
        this.puntuación = puntuación;
    }
    /**
     * Carga los datos del fichero en el ArrayList lista
     * y devuelve true si todo ha ido bien o false si ha fallado algo
     * @param fichero
     * @return - boolear true o false
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static boolean  cargar( ArrayList<Torneo> lista,File fichero) throws IOException, ClassNotFoundException{
      lista = null;   
        try{
        	lista = new ArrayList<Torneo>();
            ObjectInputStream ficheroEntrada = null;
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            lista = (ArrayList<Torneo>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
               }
    }
    /**
     * Guarda los datos del ArrayList lista en el fichero fichero
     * Si todo ha ido bien devuelve true y en caso contrario false 
     * @param lista
     * @param fichero
     * @return boolean tru - falase 
     */
    public static boolean guardar(ArrayList<Torneo> lista,File fichero){
        try{
        	//Fichero de salida
            ObjectOutputStream sal = null; 
            sal = new ObjectOutputStream(new FileOutputStream (fichero));
            sal.writeObject(lista);
            sal.flush();
            sal.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
    
   
}