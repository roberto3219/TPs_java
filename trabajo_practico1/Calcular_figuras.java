package trabajo_practico1;

import java.util.Scanner;
public class Calcular_figuras {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int opcion;
        boolean control = true;
        do{
            menu();
            System.out.println("Ingrese una opcion: ");
            opcion = entrada.nextInt();
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el lado del cuadrado: ");
                    double lado = entrada.nextDouble();
                    double area_cuadrado = lado * lado;
                    System.out.println("El area del cuadrado es: " + area_cuadrado);
                    break;
                case 2:
                    System.out.println("Ingrese la base del triangulo: ");
                    double base = entrada.nextDouble();
                    System.out.println("Ingrese la altura del triangulo: ");
                    double altura = entrada.nextDouble();
                    double area_triangulo = (base * altura) / 2;
                    System.out.println("El area del triangulo es: " + area_triangulo);
                    break;
                case 3:
                    System.out.println("Ingrese el radio del circulo: ");
                    double radio = entrada.nextDouble();
                    double area_circulo = Math.PI * radio * radio;
                    System.out.println("El area del circulo es: " + area_circulo);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    control = false;
                    break;
                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
            }
        }while(control);


        
    }

    public static void menu(){
        System.out.println("1. Calcular area de un cuadrado");
        System.out.println("2. Calcular area de un triangulo");
        System.out.println("3. Calcular area de un circulo");
        System.out.println("4. Salir");
    }
}
