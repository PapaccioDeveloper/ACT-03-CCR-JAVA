/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.operaciones.algebraicas;

import actividad03_0485.ejercicio01.introduceDatos.Pregunta;
import java.io.IOException;

/**
 *
 * @author carlo
 */
public class Operaciones {

    public static double muestraRaizCuadrada() throws IOException {
        double valor = Pregunta.pidedouble("");
        double resultado = Math.sqrt(valor);
        return resultado;
    }
    
    
    public static void calculaPotencia(double val1, double val2){
        
        double elevado = Math.pow(val1, val2);
        System.out.println("El numero "+ val1 +" elevado al " + val2+ "  es  " + elevado);
    
    
    
    }
    
    

}
