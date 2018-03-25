/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevador;

import java.util.Scanner;

/**
 *
 * @author los Armandos
 */
public class Elevador {

    private static int cantPersonas;
    private static String direccion;
    private static String status;
    private static String solicitud;
    private String resp;
    Scanner leer;

    public Elevador() {
        leer = new Scanner(System.in);
        int opcion = 0;
        boolean salir = false;
        int personas = 0;
        do {
            System.out.println("=====ELEVATOR=====\n"
                    + "0.- Salir(Por las escaleras)\n"
                    + "1.- Subir persona(s)\n"
                    + "2.- Bajar persona(s)\n"
                    + "3.- Ver cuantos van\n"
                    + "Dime cual elegiste:");
            opcion = leer.nextInt();

            String respuesta = "";
            //Se cambia la variable respuesta según el número elegido
            switch (opcion) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    respuesta = "subir";
                    break;
                case 2:
                    respuesta = "bajar";
                    break;
                case 3:
                    respuesta = "ver";
                    break;
                default:
                    System.out.println("Esa opcion no existe (no juegues con el elevador)");
                    break;
            }
            //Según la variable respuesta se va al método setRespuesta
            setResp(respuesta);
            //Validar la respuesta seleccionada
            if (getResp().equals("subir")) {
                System.out.println("Dime la cantidad de personas a subir");
                int numSubir = leer.nextInt();
                //Asignar las personas a subir
                setPersonas(numSubir);
                //Validar la cantidad de personas a subir
                String estadoElevador = validarSubir(numSubir);
                if (estadoElevador.equals("libre")) {
                    System.out.println("Puede subir, somos " + getPersonas() + " personas");
                } else {
                    System.out.println("Está lleno, no cabe, somos " + getPersonas() + " personas");
                }
                //Si la respuesta no es "subir"
            } else {
                //Si la respuesta es bajar
                if (getResp().equals("bajar")) {
                    System.out.println("Dime la cantidad de personas a bajar");
                    int numBajar = leer.nextInt();
                    //Asignas el número de personas a bajar
                    setPersonas(numBajar);
                    //Validas el estado del elevador
                    String estadoElevador = validarBajar(numBajar);
                    if (estadoElevador.equals("libre")) {
                        System.out.println("Puede bajar, hay " + getPersonas() + " personas");
                    } else {
                        System.out.println("NO puede bajar, porque hay " + getPersonas() + " personas");
                    }
                    //Si la respuesta no es subir y no es bajar
                } else {
                    //Verificar si la respuesta es ver
                    if (getResp().equals("ver")) {
                        System.out.println("Van como salchicha " + getPersonas() + " personas");
                    }
                }
            }
        } while (opcion != 0);
    }

    //Retorna la respuesta
    public String getResp() {
        return resp;
    }

    //Retorna la variable con la respuesta según se eligió
    public void setResp(String respue) {
        if (respue.equals("subir")) {
            resp = "subir";
        }
        if (respue.equals("bajar")) {
            resp = "bajar";
        }
        if (respue.equals("ver")) {
            resp = "ver";
        }
    }

    //Validas si está libre u ocupado
    public String validarSubir(int cantidadPersonas) {
        subir(cantidadPersonas);
        if (getPersonas() >= 5) {
            status = "ocupado";
        } else {
            if (cantidadPersonas > getPersonas()) {
                status = "ocupado";
            } else {
                status = "libre";
            }
        }
        return status;
    }

    //Validas que no sean negativos o 0 para bajar
    public String validarBajar(int cantidadPersonas) {
        bajar(cantidadPersonas);
        if (getPersonas() <= 0) {
            status = "ocupado";
        } else {
            status = "libre";
        }
        return status;
    }

   //Asignas la cantidad a bajar 
    public void bajar(int cantidadPersonas) {
        setPersonas(cantidadPersonas);
    }

    //Obtienes la cantidad de personas
    public int getPersonas() {
        return cantPersonas;
    }

    //Asignas la cantidad de personas
    public void setPersonas(int num) {
        cantPersonas = num;
    }

    //Asignas la cantidad a subir
    public void subir(int cantidadPersonas) {
        setPersonas(cantidadPersonas);
    }

    //Verificas si va hacia arriba o abajo
    public String direccionElevador(String direcElevador) {
        solicitudBajarSubir(direcElevador);
        if (direcElevador.equals(getSolicitud())) {
            direccion = "arriba";
        }
        if (direccion.equals(getSolicitud())) {
            direccion = "abajo";
        }
        return direccion;
    }

    //Validas la solicitud de "bajar / subir"
    public void solicitudBajarSubir(String soli) {
        if (soli.equals("bajar")) {
            solicitud = "bajar";
        }
        if (soli.equals("subir")) {
            solicitud = "subir";
        }
    }

    //Obtienes el valor de la solicitud
    public String getSolicitud() {
        return solicitud;
    }
}
