/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevador;

import java.util.Scanner;

/**
 *
 * @author Lotso <merengues.org>
 */
public class Funcionalidad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leer = new Scanner(System.in);
        Reloj watch = new Reloj();
        
        Edificio objEdificio;
        //Si el piso es mayor a 6, se genera un ciclo que tiene como intervalo 0-6
        do {
            objEdificio = new Edificio();
            if (objEdificio.getPisoActual() > 6) {
                System.out.println("El edificio no tiene esos pisos, escoje otro");
            }
        } while (objEdificio.getPisoActual() > 6 || objEdificio.getPisoActual() < 0);

        Elevador objElevador = new Elevador();
    }

}
