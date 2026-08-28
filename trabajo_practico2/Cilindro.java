import java.util.Scanner;

public class Cilindro {
    private double radio;
    private double altura;

    public Cilindro(){
        this.radio = 1.0;
        this.altura = 1.0;
    }
    public Cilindro(double radio,double altura){
        this.radio = radio;
        this.altura = altura;
    }

    public void getAltura(){

    }

    public void setAltura(){

    }

    public void getRadio(){

    }
    public void setRadio()[
        
    ]

    public double calcular_volumen(double radio, double altura){
        double volumen_cilindro = Math.PI * Math.pow(2, radio) * altura;
        return volumen_cilindro;
    }

    public double calcular_superficie(double radio,double altura){
        double superficie_cilindro = 2 * Math.PI * radio * (radio + altura) ;
        return superficie_cilindro;
    }

    public static void main_menu(){
        System.out.println("MENU");
        System.out.println("1.INGRESE EL RADIO:");
        System.out.println("2.INGRESE LA ALTURA:");
        System.out.println("3.CREAR OBJETO");
        System.out.println("4.CALCULAR EL VOLUMEN DEL CILINDRO");
        System.out.println("5.CALCULAR LA SUPERFICIE DEL CILINDRO");
        System.out.println("6.SALIR");
    }
    public static void main(String[] args){
        main_menu();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Elige una opcion: ");
        int opcion = entrada.nextInt();
        
        Cilindro cilindro1 = new Cilindro(2.0,4);

    }

}
