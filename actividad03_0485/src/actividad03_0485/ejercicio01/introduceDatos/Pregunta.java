/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.introduceDatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author carlo
 */
public class Pregunta {

    //quitar comentarios para probar las op
    /* 
     public static void main(String[] args) throws IOException {     
         System.out.println(pideEntero("jamaica existe?"));
         System.out.println(pidedouble("jamaica existe?"));
    }
     */
    public static int pideEntero(String pregunta) throws IOException {

        System.out.println("La pregunta es: " + pregunta);

        boolean x = true;
        int lectura = 0;
        while (x) {
            System.out.println("Introduce un número");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            try {
                lectura = Integer.parseInt(br.readLine());
                x = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Solamente puedes escribir números");
            }
        }

        return lectura;

    }

    public static double pidedouble(String pregunta) throws IOException {

        System.out.println("La pregunta es: " + pregunta);

        boolean x = true;
        double lectura = 0.0;
        while (x) {
            System.out.println("Introduce un número");
            Scanner read = new Scanner(System.in); //Se crea el lector

            try {
                lectura = read.nextDouble();
                x = false;
            } catch (InputMismatchException nfe) {
                System.out.println("Solamente puedes escribir números");
            }
        }

        return lectura;

    }

}
