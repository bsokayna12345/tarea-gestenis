package gestenis;

import java.io.*;
import java.util.ArrayList;


public class Torneo  {
	
    
    private String nombreTorneoneo;
    private int puntuaci�n;
    
    Torneo (String nombreTorneoneo,int puntuaci�n){
        this.nombreTorneoneo=nombreTorneoneo;
        this.puntuaci�n=puntuaci�n;
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
     * Devuelve la puntuaci�nuaci�n asignada al torneo
     * @return - puntuacion
     */
    public int getpuntuaci�n() {
        return puntuaci�n;
    }

    /**
     * Introducimos la puntuaci�nuaci�n asignada para el torneo
     * @param puntuacion
     */
    public void setpuntuaci�n(int puntuaci�n) {
        this.puntuaci�n = puntuaci�n;
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