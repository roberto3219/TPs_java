package trabajo_practico1;

public class Numeros_aleatorios {
    public static void main(String[] args){
        int num1,num2,num3;
        //entre 1 y 100
        num1 = (int)(Math.random() * 100) + 1;
        //entre 101 y 200
        num2 = (int)(Math.random() * 100) + 101;
        //entre 2 y 9
        num3 = (int)(Math.random() * 8) + 2;

        System.out.println("Numero aleatorio entre 1 y 100: " + num1);
        System.out.println("Numero aleatorio entre 101 y 200: " + num2);
        System.out.println("Numero aleatorio entre 2 y 9: " + num3);

        int diferencia_cantidad = 0 ;
        int promedio_divisibles = 0;
        int acumulador_divisibles = 0;
        diferencia_cantidad = num2 - num1;
        //Generar y mostrar todos los numeros desde el num1 hasta el num2 que sean divisibles por num3
        for(int i = 0; i < diferencia_cantidad; i++){
            if((num1 + i) % num3 == 0){
                System.out.println(num1 + i);
                promedio_divisibles ++;
                acumulador_divisibles += (num1 + i);
            }   

        }
        if(promedio_divisibles > 0){
            System.out.println("Promedio de los numeros divisibles por " + num3 + ": " + (double)acumulador_divisibles / promedio_divisibles);
        }
    }
}
