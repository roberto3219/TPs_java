package trabajo_practico1;

import java.util.Scanner;
public class Ciudadania {
    public static void main(String[] args) {
        System.out.println("Hola, soy un ciudadano");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la ciudad donde vive: ");
        String nombre_ciudad = entrada.nextLine();
        System.out.println("Hola, soy un ciudadano de " + nombre_ciudad);
        System.out.println("Ingrese el nombre del país donde vive: ");
        String nombre_pais = entrada.nextLine();
        System.out.println("Hola, soy un ciudadano de " + nombre_ciudad + ", " + nombre_pais);

        int cantidad_caracteres_ciudad = nombre_ciudad.length();
        int cantidad_caracteres_pais = nombre_pais.length();
        System.out.println("La ciudad " + nombre_ciudad + " tiene " + cantidad_caracteres_ciudad + " caracteres ");
        System.out.println("El país " + nombre_pais + " tiene " + cantidad_caracteres_pais + " caracteres ");

        if(cantidad_caracteres_ciudad > cantidad_caracteres_pais){
            System.out.println("La ciudad " + nombre_ciudad + " tiene mas caracteres que el pais " + nombre_pais);
        }else if(cantidad_caracteres_ciudad < cantidad_caracteres_pais){
            System.out.println("El pais " + nombre_pais + " tiene mas caracteres que la ciudad " + nombre_ciudad);
        }else if(cantidad_caracteres_ciudad == cantidad_caracteres_pais){
            System.out.println("La ciudad " + nombre_ciudad + " y el pais " + nombre_pais + " tiene la misma cantidad de caracteres ");
        }

        //verifica si contiene la letra Ñ
        nombre_ciudad = nombre_ciudad.toLowerCase();
        if(nombre_ciudad.contains("ñ")){
            System.out.println("La ciudad " + nombre_ciudad + " contiene la letra ñ");
        }
    }
}
