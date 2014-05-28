/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package copiaPeliculas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import copiaPeliculas.Equipos;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import sun.security.krb5.SCDynamicStoreConfig;

/**
 *
 * @author FREDDY
 */
public class ArchivoClase {

    String SnombFichNuev = System.getProperty("user.dir") + "/src/respaldo/respaldo1.doc";
    final public static String SnombFichNuevstatic = "";
    RandomAccessFile archivo;
    String arreglo[] = null;
    final public static List<Equipos> paises = new ArrayList<Equipos>();
    public List<Equipos> p = new ArrayList<Equipos>();

    public ArchivoClase(List<Equipos> listaPaises) {
        p = listaPaises;
    }

    public RandomAccessFile getArchivo() {
        return archivo;
    }

    public void setArchivo(RandomAccessFile archivo) {
        this.archivo = archivo;
    }

    public String[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(String[] arreglo) {
        this.arreglo = arreglo;
    }

    public List<Equipos> getP() {
        return p;
    }

    public void setP(List<Equipos> p) {
        this.p = p;
    }

    public ArchivoClase() {
        try {
            archivo = new RandomAccessFile(SnombFichNuev, "rw");
            // archivo = new RandomAccessFile("C:\\Users\\Freddy\\Desktop\\respaldo.doc", "rw");
        } catch (Exception e) {
        }
    }

    public void GuardarDatos(String nombre, String ranking, String grupo, String valorg, String numCopas, String partido1, String partido2, String partido3) throws IOException {
        Equipos pa = new Equipos();
        try {
            pa.setNombre(nombre);
            pa.setRanking(ranking);
            pa.setGrupo(grupo);
            pa.setValorg(valorg);
            pa.setNumCopas(numCopas);
            pa.setPartido1(partido1);
            pa.setPartido1(partido2);
            pa.setPartido1(partido3);
            try {
                archivo.seek(archivo.length());
                archivo.writeBytes(pa.getNombre() + "," + pa.getRanking() + "," + pa.getGrupo() + "," + pa.getValorg() + "," + pa.getNumCopas() + "," + pa.getPartido1() + "," + pa.getPartido2() + "," + pa.getPartido3() + "\n");
                JOptionPane.showMessageDialog(null, "Ha sido registrado con exito");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "El archivo no se puede escribir");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos al Uso del Sistema");
        }
    }

    public void leerdatos() throws FileNotFoundException {
        Equipos pa = null;
        String nombre = "";
        String ranking = "";
        String g = "";
        String grupo = "";
        String valorg = "";
        String numCopas = "";
        String partido1 = "";
        String partido2 = "";
        String partido3 = "";
        //File direccion = new File(System.getProperty("user.dir") + "/src/respaldo/respaldo.doc");
        File direccion = new File(SnombFichNuev);
        if (direccion.exists()) {
            BufferedReader archivoEntrad;
            archivoEntrad = new BufferedReader(new FileReader(direccion));
            try {
                arreglo = new String[7];
                String linea;
                while (((linea = archivoEntrad.readLine()) != null)) {
                    System.out.println(linea);
                    pa = new Equipos();
                    arreglo = linea.split(",");
                    nombre = arreglo[0].toString();
                    ranking = arreglo[1].toString();
                    grupo = arreglo[2].toString();
                    valorg = arreglo[3].toString();
                    numCopas = arreglo[4].toString();
                    partido1 = arreglo[5];
                    partido2 = arreglo[6].toString();
                    partido3 = arreglo[7].toString();
                    pa.setNombre(nombre);
                    pa.setRanking(ranking);
                    pa.setGrupo(grupo);
                    pa.setValorg(valorg);
                    pa.setNumCopas(numCopas);
                    pa.setPartido1(partido1);
                    pa.setPartido2(partido2);
                    pa.setPartido3(partido3);
                    ArchivoClase.paises.add(pa);
                }
                archivoEntrad.close();
            } catch (IOException ee) {
                System.out.println("Error al leer el archivo " + archivo + ":" + ee.toString());
                System.exit(1);
            }
        }
    }
    public Equipos buscar(String datoBuscar) throws FileNotFoundException {
        this.leerdatos();
        List<Equipos> listaP = ArchivoClase.paises;
        Equipos pais = new Equipos();
        for (Equipos pa : listaP) {
            if (pa.getNombre().trim().equals(datoBuscar.trim())) {
                pais = pa;
            }
        }
        return pais;
    }

    public List<Equipos> buscartodos() throws FileNotFoundException {
        this.leerdatos();
        List<Equipos> listaP = ArchivoClase.paises;
        List<Equipos> pa = new ArrayList<Equipos>();
        for (Equipos l3 : listaP) {
            pa.add(l3);
        }
        return pa;
    }

    public static void EcribirFichero(File Ffichero, String SCadena) {
        try {
            //Si no Existe el fichero lo crea  
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8.  
             *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)", 
             *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia*/
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función.  
             *el string "\r\n" significa salto de linea*/
            Fescribe.write(SCadena + "\r\n");
            //Cierra el flujo de escritura  
            Fescribe.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla   
            System.out.println(ex.getMessage());
        }
    }

    public static void BorrarFichero(File Ffichero) {
        try {
            /*Si existe el fichero*/
            if (Ffichero.exists()) {
                /*Borra el fichero*/
                Ffichero.delete();
                System.out.println("Fichero Borrado con Exito");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

    /**
     * *********************************************************
     * Modificar un fichero de texto, consiste en leer un archivo y escribir su
     * con tenido en uno nuevo llamado X, excepto la linea a modificar que se
     * remplaza con la linea nueva.Luego se borra el fichero inicial y se
     * renombra el nuevo fichero con el nombre del archivo inicial
     * ********************************************************** PARÁMETROS:
     * FficheroAntiguo:Objeto File del fichero a modificar Satigualinea:Linea
     * que se busca para modificar Snuevalinea:Linea con la que se va a
     * remplazar la vieja
     * *********************************************************
     */
    public void ModificarFichero(File FficheroAntiguo, String Satigualinea, String Snuevalinea) {
        /*Obtengo un numero aleatorio*/
        Random numaleatorio = new Random(3816L);
        /*Creo un nombre para el nuevo fichero apartir del 
         *numero aleatorio*/
        //String SnombFichNuev = System.getProperty("user.dir") + "/src/respaldo/respaldo1.doc";
        SnombFichNuev = FficheroAntiguo.getParent() + "/auxiliar" + String.valueOf(Math.abs(numaleatorio.nextInt())) + ".doc";
       // ArchivoClase.SnombFichNuevstatic = SnombFichNuev;
        // SnombFichNuevstatic = SnombFichNuev;
        /*Crea un objeto File para el fichero nuevo*/
        File FficheroNuevo = new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if (FficheroAntiguo.exists()) {
                /*Abro un flujo de lectura*/
                BufferedReader Flee = new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while ((Slinea = Flee.readLine()) != null) {
                    /*Si la lia obtenida es igual al la bucada 
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                        /*Escribo la nueva linea en vez de la que tenia*/
                        EcribirFichero(FficheroNuevo, Snuevalinea);
                    } else {
                        /*Escribo la linea antigua*/
                        EcribirFichero(FficheroNuevo, Slinea);
                    }
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo = FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del  
                 *fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println(ex.getMessage());
        }
    }

//    public static void main(String[] args) {
//        ArchivosEditar a = new ArchivosEditar();
//        File Ffichero = new File(System.getProperty("user.dir") + "/src/respaldo/respaldo1.doc");
//        a.ModificarFichero(Ffichero, "Honduras,30,E,0,0,-1,0,1", "Honduras,30,E,0,0,0,0,0");
//        System.out.print(SnombFichNuevstatic);
//        JOptionPane.showMessageDialog(null, SnombFichNuevstatic);
//    }
//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            ArchivoClase ac = new ArchivoClase();
//            //ac.leerdatos();
//            JOptionPane.showMessageDialog(null, ac.buscartodos());
//        } catch (Exception e) {
//        }
//
//    }
    //este solo es para hacer la busqueda y saber si existe ya una cedula en el txt para q no se repitan las cedulas
}
