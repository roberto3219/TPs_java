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

    public double getAltura(){
  
           return this.altura ;
    }

    public void setAltura(double altura){
           Scanner entrada = new Scanner(System.in);
           while(altura <0){
               System.out.println("Debe ser mayor a 0: ");
               altura = entrada.nextDouble();
           }
           this.altura = altura;
    }

    public double getRadio(){
            return this.radio;
    }
    public void setRadio(double radio){
            Scanner entrada = new Scanner(System.in);
            while(radio <0){
               System.out.println("Debe ser mayor a 0: ");
               radio = entrada.nextDouble();
           }
            this.radio=radio;
}

    public double calcular_volumen(){
        double volumen_cilindro = Math.PI * Math.pow(2, this.radio) * this.altura;
        return volumen_cilindro;
    }

    public double calcular_superficie(){
        double superficie_cilindro = 2 * Math.PI * this.radio * (this.radio + this.altura) ;
        return superficie_cilindro;
    }

    public static void main_menu(){
        System.out.println("MENU");
        System.out.println("1.INGRESE/MODIFIQUE EL RADIO:");
        System.out.println("2.INGRESE/MODIFIQUE LA ALTURA:");
        System.out.println("3.CALCULAR EL VOLUMEN DEL CILINDRO");
        System.out.println("6.Detalles del cilindro");
        System.out.println("4.CALCULAR LA SUPERFICIE DEL CILINDRO");
        System.out.println("5.SALIR");
    }
    public static int opciones_menu(int option, Cilindro cilindro1, Scanner entrada){
    
        double radio;
        double altura;
        if (option == 1){
            System.out.println("Ingrese el radio:");
            radio = entrada.nextDouble();
            cilindro1.setRadio(radio);
            return option;
        }else if (option ==2){
            System.out.print("Ingrese la altura: ");
            altura = entrada.nextDouble();
            cilindro1.setAltura(altura);
            return option;
        }else if(option ==3){
            
            System.out.println( "El volumen del cilindro es: " + cilindro1.calcular_volumen());
            return option;
        }else if(option == 4){
            System.out.println("La superficie del cilindro es: " + cilindro1.calcular_superficie());
            return option;
        }else if(option == 5){
            System.out.println("Hasta luego!");
            return option;
        }else if(option == 6){
            System.out.println("Cilindro(atributos):");
            System.out.println("Radio: "+cilindro1.getRadio());
            System.out.println("Altura: " +cilindro1.getAltura());
            return option;
           }else{
            System.out.println("Elige entre 1 a 6: ");
            return option;
        }
    }
    public static void main(String[] args){
       byte continuar = 1;
       Scanner entrada = new Scanner(System.in);
       Cilindro cilindro1 = new Cilindro();
      
      do{
        try{
          
         main_menu();

        System.out.println("Elige una opcion: ");
          int opcion = entrada.nextInt();
           int funcion_opcion = opciones_menu(opcion,cilindro1,entrada);
    
        if (funcion_opcion == 5){
            continuar = 0;
        }
        
        
       }catch(Exception e){
           
           System.out.println("Error: por favor ingrese bien " + e);
           
          
       }
      }while(continuar ==1);

       
       
    }

            }
                               
