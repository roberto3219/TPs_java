
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Ingreso_datos();
		System.out.println("Gracias por usar nuestro programa");
	}
	
	public static double condiciones_descuento(double salario_bruto){
	    double descuento = 0;
	    double descuento_salario=0;
	    if(salario_bruto <= 1000000){
	        descuento = 9/100;
	        
	    }else if(salario_bruto > 100000000 && salario_bruto <= 300000000){
	        descuento = 12/100;
	    }else if(salario_bruto > 300000000){
	        descuento = 15/100;
	    }else{
	        descuento = 0;
	    }
	    descuento_salario = salario_bruto * descuento;
	    
	    return descuento_salario;
	}
	
	
	public static void Ingreso_datos(){
	    
	    Scanner entrada = new Scanner(System.in);
	    System.out.print("Ingrese su nombre: ");
	    String nombre_trabajador = entrada.nextLine();
	    System.out.print("Cuantas horas trabajas?:  ");
	    int cantidad_horas = entrada.nextInt();
	    System.out.print("Cuanto te pagan por hora trabajada por semana?:  ");
	    int valor_por_hora=entrada.nextInt();
	    
	    calcular_saldo(cantidad_horas,valor_por_hora);   
	    }
	    
	    
	    
	    public static  double  calcular_saldo(int horas,int valor_horas){
	        double total_bruto;
	        int sueldo_normal = horas * valor_horas;
	        System.out.println("Tu saldo bruto es : " + sueldo_normal);
	        double pago_extra_function = calcular_saldoExtra(horas);
	        double descuento_sueldo_bruto= condiciones_descuento(sueldo_normal);
			System.out.println("Tu descuento por ley es de: " + descuento_sueldo_bruto);
	        System.out.println("Tu pago extra por horas extras es de: " + pago_extra_function);
	        total_bruto=sueldo_normal+pago_extra_function-descuento_sueldo_bruto;
	        System.out.println("Tu saldo total es: " + total_bruto);
	        return total_bruto;
	        }
	        
	        
	        
	     public static double calcular_saldoExtra(int cantidad_horas){
	         double pagoExtra;
	         int horasExtra = cantidad_horas - 40 ;
	         if (horasExtra >0){
	                   System.out.println("Usted trabaja horas extra: ");
	                   pagoExtra=horasExtra *(cantidad_horas*1.5);
	                   
	             }else{
	                 System.out.println("Usted no trabaja horas extra ");
	                 pagoExtra = 0;
	             }
	         return pagoExtra; 
	         }
}