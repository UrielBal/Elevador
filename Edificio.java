/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevador;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author los armandos
 */
public class Edificio {

    private static int cantidadPisos;
    private static int cantidadDepas;
    private static int cantidadPeople;
    Random ran;
    Scanner leer;

    //Asignarle el cero al piso inicial y asignar el ingresado por el ususario
    public Edificio() {
        leer = new Scanner(System.in);
        int pisoActual = 0;
        System.out.println("Dime el piso actual");
        pisoActual = leer.nextInt();
        PisoActual(pisoActual);
    }

    //Generas aleatoriamente la cantidad de personas que van en el elevador
    public int cantidadPersonas() {
        ran = new Random();
        cantidadPeople = ran.nextInt(4) + 1;
        return cantidadPeople;
    }

    //Retornas el piso en el que estás
    public int getPisoActual() {
        return cantidadPisos;
    }

    //Asignas el valor del piso en el que estás
    public void PisoActual(int piso) {
        cantidadPisos = piso;
    }

    //Cantidad de departamentos
    public int cantDepas() {
        cantidadDepas = 4;
        return cantidadDepas;
    }

}
