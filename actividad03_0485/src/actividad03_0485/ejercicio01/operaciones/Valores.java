/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.operaciones;
import actividad03_0485.ejercicio01.introduceDatos.Pregunta;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author carlo
 */
public class Valores {
    
    
    public static void muetraPi(){
      double numpi = Math.PI;
        System.out.println(numpi);
    }
    
    public static void muestraValorAleatorio() throws IOException{
        String texto = "dame un numero";
        int valor = Pregunta.pideEntero(texto);
        Random ram1 = new Random();
        int result = ram1.nextInt(valor);
        System.out.println("El valor aleatorio es: "+result);
    }
    
    
    
}
