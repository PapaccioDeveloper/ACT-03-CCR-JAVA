/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad03_0485.ejercicio01.operaciones.geometricas;

/**
 *
 * @author carlo
 */
public class operaciones {

    public static void muestraSeno(Double seno) {
        double b = Math.toRadians(seno);
        System.out.println("Seno de " + seno + " es: " + Math.sin(b));
    }

    public static void muestraCoSeno(Double coSeno) {
        double b = Math.toRadians(coSeno);
        System.out.println("Coseno de " + coSeno + " es: " + Math.cos(b));
    }

}
