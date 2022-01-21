package actividad03_0485.ejercicio02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        int valortecladoanadido = 1;
        crearCarpeta();
        //INICIO MENU DE OPERACIONES
        do {
            System.out.println("Introduzca el numero de operacion a realizar");
            System.out.println("1 - Nuevo Archivo");
            System.out.println("2 - Listar Archivo ");
            System.out.println("3 - Muestra un Archivo");
            System.out.println("4 - Borrar un Archivo:");
            System.out.println("5 - Renombrar un Archivo:");
            System.out.println("6 - Reemplazar caracteres de un Archivo:");
            System.out.println("0- Salir ");

            try {

                //PRIMERA ENTRADA DE TEXTO
                Scanner br = new Scanner(System.in); //Se crea el lector          
                valortecladoanadido = br.nextInt();

                if (valortecladoanadido >= 0 && valortecladoanadido <= 6) {

                    switch (valortecladoanadido) {

                        case 1:
                            nuevoArchivo();
                            break;

                        case 2:
                            ListarArchivos();
                            // comprobar que devuelve el array
                            /*   for (int i = 0; i < ListarArchivos().length; i++) {
                            System.out.println(ListarArchivos()[i]);
                         }*/
                            break;

                        case 3:
                            MuestraunArchivo();
                            break;

                        case 4:
                            borrarArchivo();
                            break;

                        case 5:
                            renombrarArchivo();
                            break;

                        case 6:
                            reCaracArchiv();
                            break;

                        case 0:

                            System.out.println("-- PROGRAMA FINALIZADO  --");
                            break;

                        //end switch                    
                    }
                } else {
                    System.out.println(" ");
                    System.out.println("El valor introducido no es correcto");
                    System.out.println("  ");

                }

            } catch (NumberFormatException e) {

                System.out.println("valor no valido");
            } catch (InputMismatchException e) {

                System.out.println("valor no valido");
            }

        } while (valortecladoanadido != 0);

        //end main
    }

    public static void crearCarpeta() {
        /* si no existe una carpeta de nombre “archivos” ubicada en la carpeta del proyecto,
            se cree de manera que quedará en la misma carpeta que las carpetas src  y bin: */
        String basePath = new File("").getAbsolutePath();

        File directorio = new File(basePath + "/archivos");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        } else {
            System.out.println("/archivos ya existe");
        }
    }

    public static void nuevoArchivo() throws IOException {
        //Pedir por teclado
        System.out.println("Introduce Nombre del Archivo");
        Scanner br = new Scanner(System.in); //Se crea el lector          
        String nombreArchivo = br.nextLine();
        //creamos fichero
        String basePath = new File("").getAbsolutePath();
        File directorio = new File(basePath + "/archivos" + "/" + nombreArchivo + ".txt");
        try {

            // A partir del objeto File creamos el fichero físicamente
            if (directorio.createNewFile()) {
                System.out.println("El fichero se ha creado correctamente");

            } else {
                System.out.println("No ha podido ser creado el fichero");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try {
            //Pedir por teclado
            System.out.println("Introduce el texto para el archivo");
            Scanner sc = new Scanner(System.in); //Se crea el lector          
            String textoArchivo = sc.nextLine();
            //Rellenamos el fichero
            FileWriter fw = new FileWriter(directorio);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write(textoArchivo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Fin nuevoArchivo()

    public static String[] ListarArchivos() throws IOException {

        String basePath = new File("").getAbsolutePath();
        File directorio = new File(basePath + "/archivos" + "/");
        String[] listado = directorio.list();
        String[] listadoDirectorios = new String[listado.length];
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
        } else {
            for (int i = 0; i < listado.length; i++) {
                System.out.println(i + "- " + listado[i]);
                File f = new File(listado[i]);
                // System.out.println("Ruta: " + f.getAbsolutePath());
                listadoDirectorios[i] = f.getPath();

            }
        }

        return listadoDirectorios;
    }
    //fin KistarArchivos

    public static void MuestraunArchivo() throws IOException {
        String[] listado = ListarArchivos();
        File archivo = null;
        for (int i = 0; i < listado.length; i++) {
            System.out.println("Numero: " + i + " " + listado[i]);
        }
        System.out.println("Selecciona el numero del archivo que quieres ver.");
        //Pedimos el numero del fichero
        Scanner sc = new Scanner(System.in); //Se crea el lector          
        int NumeroArchivo = sc.nextInt();

        for (int i = 0; i < listado.length; i++) {
            if (NumeroArchivo == i) {

                archivo = new File("archivos/" + listado[i]);
                System.out.println(archivo);

                String cadena;

                try {
                    FileReader f = new FileReader(archivo);
                    BufferedReader b = new BufferedReader(f);
                    while ((cadena = b.readLine()) != null) {
                        System.out.println(cadena);
                    }

                    b.close();

                } catch (FileNotFoundException e) {
                    System.out.println(e.getMessage());
                } catch (IOException e) {
                    System.out.println(e.getMessage());

                }

            }

        }

    }
    //finMuestra Archivo

    public static void borrarArchivo() {
        File fichero = null;
        String basePath = new File("").getAbsolutePath();
        File directorio = new File(basePath + "/archivos" + "/");
        String[] listado = directorio.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
        } else {
            //Listar
            for (int i = 0; i < listado.length; i++) {
                System.out.println(i + "- " + listado[i]);
            }
            System.out.println("Introduce numero para borrar");
            Scanner sc = new Scanner(System.in); //Se crea el lector          
            int NumeroArchivo = sc.nextInt();
            //el fichero a borrar
            for (int i = 0; i < listado.length; i++) {
                if (NumeroArchivo == i) {
                    fichero = new File("archivos/" + listado[i]);
                    if (!fichero.exists()) {
                        System.out.println("El archivo  no existe.");
                    } else {
                        fichero.delete();
                        System.out.println("El archivo fue eliminado.");
                    }

                }

            }

        }

    }
    //FIN Borrar Archivos

    public static void renombrarArchivo() {
        int comprobador = 0;
        do {
            comprobador = 0;
            int error = 0;

            String basePath = new File("").getAbsolutePath();
            File directorio = new File(basePath + "/archivos/");
            String[] listado = directorio.list();
            if (listado == null || listado.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
            } else {
                //Listar
                for (int i = 0; i < listado.length; i++) {
                    System.out.println(i + "- " + listado[i]);
                }
                System.out.println("Introduce numero para renombrar un archivo");
                Scanner sc = new Scanner(System.in); //Se crea el lector          
                int NumeroArchivo = sc.nextInt();
                System.out.println("Nuevo nombre del archivo");

                Scanner lc = new Scanner(System.in); //Se crea el lector          
                String NombreArchivo = lc.next();

                //Comprobar    
                char[] charSearch = {'/', '\n', '\r', '\t', '\0', '\f', '`', '?', '*', '\\', '<', '>', '|', '\"', ':'};
                for (int i = 0; i < NombreArchivo.length(); i++) {
                    char chr = NombreArchivo.charAt(i);
                    for (int j = 0; j < charSearch.length; j++) {
                        if (charSearch[j] == chr) {
                            System.out.println("Error " + charSearch[j] + " No puede contener esos caracteres " + NombreArchivo);
                            error = 1;

                        }
                    }
                }

                //SI SE INTRODUJO UN CARACTER MAL POR AQUI NO ENTRA
                if (error == 0) {

                    for (int i = 0; i < listado.length; i++) {
                        System.out.println(i + "- " + listado[i]);
                        if (NumeroArchivo == i) {
                            File oldfile = new File(basePath + "/archivos/" + listado[i]);
                            System.out.println(listado[i]);
                            File newfile = new File(basePath + "/archivos/" + NombreArchivo + ".txt");
                            System.out.println(basePath + "/archivos/" + NombreArchivo + ".txt");
                            oldfile.renameTo(newfile);

                            if (oldfile != newfile) {
                                System.out.println("Nombre cambiado");
                                comprobador = 2;
                            } else {
                                System.out.println("El nombre no se cambió");
                            }

                        }

                    }

                }

            }

        } while (comprobador == 0);

    }
    //FIN RENOMBRAR ARCHIVOS

    public static void reCaracArchiv() throws IOException {

        int contador = 1;
        do {
            String basePath = new File("").getAbsolutePath();
            File directorio = new File(basePath + "/archivos/");
            String[] listado = ListarArchivos();
            System.out.println("Seleccione el numero del fichero");
            Scanner lc = new Scanner(System.in); //Se crea el lector          
            int numeroArchivo = lc.nextInt();

            for (int i = 0; i < listado.length; i++) {
                if (numeroArchivo == i) {

                    char caracter;
                    System.out.println("Introduce La letra para cambiar ");
                    Scanner sc = new Scanner(System.in); //Se crea el lector 
                    caracter = sc.next().charAt(0);

                    RandomAccessFile archivo = null;

                    try {
                        archivo = new RandomAccessFile(directorio + "/" + listado[i], "rw");
                        System.out.println(directorio + listado[i] + "esta es la ruta");
                        System.out.println("El tamaño es: " + archivo.length());
                        System.out.println("Numero de caracter a cambiar de 0 a:" + archivo.length());
                        Scanner posicion = new Scanner(System.in); //Se crea el lector 
                        int num = posicion.nextInt();
                        archivo.seek(num);
                        archivo.writeChar(caracter);
                    } catch (FileNotFoundException fe) {
                        System.out.println("No se encontro el archivo");
                        contador = 0;
                        System.out.println("paso por aqui");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        contador = 0;
                        System.out.println("paso por aqui");
                    } finally {
                        archivo.close();
                    }

                }
            }
        } while (contador == 0);

    }// end function

}//end class

