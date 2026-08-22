package trabajo_practico1;

import java.util.Scanner;
public class Examen_estudiante {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de estudiantes:");
        int cantidad_estudiantes = entrada.nextInt();
        double cantidad_preguntas = 0;
        double cantidad_respuestas_correctas = 0;

        String[] nombres_estudiantes = new String[cantidad_estudiantes];
        double[] preguntas = new double[cantidad_estudiantes];
        double[] respuestas_correctas = new double[cantidad_estudiantes];
        double[] promedio_nota = new double[cantidad_estudiantes];

        String nombre_estudiante;

        for (int i = 0; i < cantidad_estudiantes; i++) {
            System.out.println("Ingrese el nombre del estudiante " + (i+1) + ":");
            nombre_estudiante = entrada.next();
            nombres_estudiantes[i] = nombre_estudiante;
            
            System.out.println("Ingrese la cantidad de preguntas del examen:");
            cantidad_preguntas = entrada.nextDouble();
            preguntas[i] = cantidad_preguntas;
            System.out.println("Ingrese la cantidad de respuestas correctas del estudiante " + (i+1) + ":");
            cantidad_respuestas_correctas = entrada.nextDouble();
            respuestas_correctas[i] = cantidad_respuestas_correctas;
            promedio_nota[i] = ((cantidad_respuestas_correctas / cantidad_preguntas) * 100);
            System.out.println(cantidad_respuestas_correctas);
            System.out.println(((cantidad_respuestas_correctas / cantidad_preguntas)));
            System.out.println("El promedio de nota del estudiante " + (i+1) + " es: " + promedio_nota[i] + "%");
            if(promedio_nota[i] >= 90){
                System.out.println("Mayor o igual a 90%: Excelente");
            } else if(promedio_nota[i] >= 70 && promedio_nota[i] < 90){
                System.out.println("Entre 70% y 89.99%: Aprobado");
            } else if(promedio_nota[i]>= 50 && promedio_nota[i] < 69.99){
                System.out.println("Entre 50% y 69.99%: Regular");
            } else if(promedio_nota[i] < 50){
                System.out.println("Menor a 50%: Reprobado");
            }
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Lista de estudiantes: " + java.util.Arrays.toString(nombres_estudiantes));
        System.out.println("Lista de preguntas: " + java.util.Arrays.toString(preguntas));
        System.out.println("Lista de respuestas correctas: " + java.util.Arrays.toString(respuestas_correctas));
        System.out.println("Lista de promedios de nota: " + java.util.Arrays.toString(promedio_nota));
    }
}
