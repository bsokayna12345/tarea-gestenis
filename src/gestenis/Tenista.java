package gestenis;

import java.io.*;
import java.util.ArrayList;


public class Tenista  {
    private String nombre;
    private int edad;
    private ArrayList<Torneo> palmares;
    
    Tenista(String nombre,int edad){
        this.nombre=nombre;
        this.edad=edad;
        //lista de torneos
        palmares=new ArrayList<Torneo>();
    }

    /**
     * Obtenemos el nombre del tenista
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asignamos el nombre del tenista
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Nos devuelve la edad del tenista
     * @return la edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Asigna la edad del tenista
     * @param edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * Devuelve el palmar�s con los nombres de los torneos ganados
     * @return
     */
    public String[] getPalmares(){
        String[] p = new String[palmares.size()];
        for(int i=0;i<p.length;i++){
            p[i] = palmares.get(i).getnombreTorneoneo();
        }
        return p;
    }
    /**
     * A�ade el torneo ganado al palmar�s
     * @param torneo
     */
    public void aniadirPalmares(Torneo torneo){
        palmares.add(torneo);
    }
    
    /**
     * 
     * @return - p puntuacion
     */
    
    public int getPuntuacionATP(){
    	int p = 1;
        p = 0;
        for(Torneo t:palmares){
            p += t.getpuntuaci�n();
        }
        return p;
    }
    /**
     * Carga en fichero el archivo seleccionado e introduce
     * sus datos en el ArrayList Tenista y devuelve lista
     * @param fichero
     * @return  boolean false o true
     */
     static  boolean cargar(ArrayList<Tenista>lista ,File fichero){
        ArrayList<Tenista> l = null;
        ObjectInputStream ficheroEntrada = null;
        try{
            ficheroEntrada = new ObjectInputStream(new FileInputStream(fichero));
            l = (ArrayList<Tenista>) ficheroEntrada.readObject();
            ficheroEntrada.close();
            return true;
        }catch(ClassNotFoundException onfe){
            return false;
        }catch(FileNotFoundException fnfe){
            return false ;
        }catch(IOException ioe){
            return false;
        }
    }
    /**
     * Graba en fichero los datos del ArrayList lista
     * devolviendo true si ha sido todo correcto o false en caso contrario
     * @param lista
     * @param fichero
     * @return boolean false o true
     */
    public static boolean guardar(ArrayList<Tenista> lista, File fichero){
        try{
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(new FileOutputStream(fichero));
            ficheroSalida.writeObject(lista);
            ficheroSalida.flush();
            ficheroSalida.close();
            return true;
        }catch(FileNotFoundException fnfe){
            return false;
        }catch(IOException ioe){
            return false;
        }
    }
}