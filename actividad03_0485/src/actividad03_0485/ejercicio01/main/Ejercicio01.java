/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.main;

import actividad03_0485.ejercicio01.introduceDatos.Pregunta;
import actividad03_0485.ejercicio01.operaciones.Valores;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import actividad03_0485.ejercicio01.operaciones.algebraicas.Operaciones;
import actividad03_0485.ejercicio01.operaciones.geometricas.operaciones;

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

        //INICIO MENU DE OPERACIONES
        do {
            System.out.println("Introduzca el numero de operacion a realizar");
            System.out.println("1 - Muestra PI ");
            System.out.println("2 - Muestra valor aleatorio. ");
            System.out.println("3 - Muestra raiz cuadrada. ");
            System.out.println("4 - Muestra calculo potencia.");
            System.out.println("5 - Muestra seno.");
            System.out.println("6 - Muestra COseno.");
            System.out.println("0- Salir ");
            //AÑADIMOS UN ARRAY CON LOS PARAMETROS PARA PASARLO A LA FUNCION PIDEENTERO DEL PAQUETE PREGUNTA
            String consultas[] = {"0- Salir ", "1 - Muestra PI ", "2 - Muestra valor aleatorio. ", "3 - Muestra raiz cuadrada. ", "4 - Muestra calculo potencia.", "5 - Muestra seno.", "6 - Muestra COseno."};
            //PRIMERA ENTRADA DE TEXTO
        /*    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String valorteclado = br.readLine();

            int valortecladoint = Integer.parseInt(valorteclado);
            for (int i = 0; i < consultas.length; i++) {

                if (i == valortecladoint) {
                    valortecladoanadido = Pregunta.pideEntero(consultas[i]);

                }
            }
*/          
        valortecladoanadido = Pregunta.pideEntero("");
        
            if (valortecladoanadido >= 0 && valortecladoanadido <= 6) {

                switch (valortecladoanadido) {

                    case 1:
                        Valores.muetraPi();
                        break;

                    case 2:
                        Valores.muestraValorAleatorio();
                        break;

                    case 3:
                        System.out.println(Operaciones.muestraRaizCuadrada());                   
                        break;

                    case 4:
                        double num1 = Pregunta.pidedouble("Muestra calculo potencia.");
                        double num2 = Pregunta.pidedouble("Muestra calculo potencia.");
                        Operaciones.calculaPotencia(num1, num2);
                        break;

                    case 5:
                        double pidedou = Pregunta.pidedouble("Muestra seno.");
                        operaciones.muestraSeno(pidedou);
                        break;

                    case 6:
                        Double pidedo = Pregunta.pidedouble("Muestra Coseno.");
                        operaciones.muestraCoSeno(pidedo);
                        
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

        } while (valortecladoanadido != 0);

        //end main
    }

}
