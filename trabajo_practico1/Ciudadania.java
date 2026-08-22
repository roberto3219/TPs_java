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
    }
}
