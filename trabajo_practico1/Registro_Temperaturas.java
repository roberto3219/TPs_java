package trabajo_practico1;
import java.util.Arrays;
import java.util.Scanner;
public class Registro_Temperaturas {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de mediciones que desea realizar:");
        int cantidad_mediciones = entrada.nextInt();
        int[] mediciones_realizadas = new int[cantidad_mediciones]; // Suponiendo un máximo de 10 mediciones
        
            for(int i = 0; i < cantidad_mediciones; i++){
                //Entre -10 hasta 40 grados Celsius
                int random_temperatura = (int)(-10 + (40 - (-10)) * Math.random());
                System.out.println("La temperatura aleatoria es: " + random_temperatura);
                mediciones_realizadas[i] = random_temperatura;
            }

            int cantidad_temperaturas_heladas = 0;
            int cantidad_temperaturas_calientes = 0;
            for(int i=0; i < cantidad_mediciones; i++){
                if(mediciones_realizadas[i] < 0){
                    //mediciones_heladas[i] = mediciones_realizadas[i];
                    cantidad_temperaturas_heladas++;
                } else if(mediciones_realizadas[i] > 30){
                    //mediciones_calientes[i] = mediciones_realizadas[i];
                    cantidad_temperaturas_calientes++;
                }
            }
            int[] mediciones_heladas = new int[cantidad_temperaturas_heladas];
            int[] mediciones_calientes = new int[cantidad_temperaturas_calientes];

            int index_heladas = 0;
            int index_calientes = 0;
            for(int i=0; i < cantidad_mediciones; i++){
                if(mediciones_realizadas[i] < 0){
                    mediciones_heladas[index_heladas] = mediciones_realizadas[i];
                    index_heladas++;
                } else if(mediciones_realizadas[i] > 30){
                    mediciones_calientes[index_calientes] = mediciones_realizadas[i];
                    index_calientes++;
                }
            }
            

            int suma_temperaturas = 0;
            int cantidad_temperaturas = mediciones_realizadas.length;
            double promedio_temperaturas = 0;
            for(int i=0; i < cantidad_mediciones; i++){
                suma_temperaturas += mediciones_realizadas[i];
            }
            promedio_temperaturas = (double)(suma_temperaturas / cantidad_temperaturas);
            
            System.out.println("La temperatura promedio es: " + promedio_temperaturas);

        System.out.println("Las mediciones realizadas son: " + Arrays.toString(mediciones_realizadas));
        System.out.println("Las mediciones heladas son: " + Arrays.toString(mediciones_heladas));
        System.out.println("Las mediciones calientes son: " + Arrays.toString(mediciones_calientes));

    }
}
