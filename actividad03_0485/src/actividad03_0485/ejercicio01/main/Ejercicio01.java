/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author carlo
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     * 
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

            //PRIMERA ENTRADA DE TEXTO
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String valorteclado = br.readLine();
            //PARSEO Y ASIGNACION PARA LA OP DE RETORNO DE MENU
            valortecladoanadido = Integer.parseInt(valorteclado);

            if (valortecladoanadido >= 0 && valortecladoanadido <= 6) {

                switch (valortecladoanadido) {

                    case 1:
                        

                        break;

                    case 2:

                        
                        break;

                    case 3:

                     
                        break;

                    case 4:

                        
                        break;
                        
                        
                          case 5:

                        
                        break;
                        
                          case 6:

                        
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
