package trabajo_practico3;
import java.util.*;
import java.lang.*;
public class Equipo {
    private int idEquipo;
    private String nombre;
    private int puntajeAcumulado;
    private int partidosJugados;

    public Equipo(int idEquipo,String nombre,int puntajeAcumulado,int partidosJugados){

        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.puntajeAcumulado = puntajeAcumulado;
        this.partidosJugados = partidosJugados;
    }

    public int getIdEquipo(){
        return idEquipo;
    }

    public String getNombre(){
        return nombre;
    }
    public int getPuntajeAcumulado(){
        return puntajeAcumulado;
    }
    public int getPartidosJugados(){
        return partidosJugados;
    }

    public void setIdEquipo(int idEquipo){
        this.idEquipo = idEquipo;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setPuntajeAcumulado(int puntajeAcumulado){
        this.puntajeAcumulado = puntajeAcumulado;
    }
    public void setPartidosJugados(int partidosJugados){
        this.partidosJugados = partidosJugados;
    }


    public void mostrarInformacion(){
         System.out.println("---------------------------");
        System.out.println("ID: " + idEquipo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Puntaje: " + puntajeAcumulado);
        System.out.println("Partidos jugados: " + partidosJugados);
    }

    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        int cantidad ;
        do{
            try{
                System.out.println("Ingrese la cantidad de equipos a gestionar: ");
                cantidad = entrada.nextInt();
                if(cantidad < 0 ){
                    throw new IllegalArgumentException();
                }
                break;            
            }catch(InputMismatchException e){
                System.out.println("Ingrese la cantidad correspondiente ");
                entrada.nextLine();
            }catch(IllegalArgumentException e){
                System.out.println("Ingrese valores mayores a 0, por favor");
                entrada.nextLine();
            }
        }while(true);

        Equipo[] equipos = new Equipo[cantidad];

        int opcion;
        do{
            menu();
            opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    actualizarPuntaje(equipos);
                    break;
                case 2:
                    int total = calcularTotalPartidos(equipos);
                    System.out.println("El total de partidos jugados es: "+total);
                    break;
                case 3:
                    double promedio = calcularPromedio(equipos);
                    System.out.println("El promedio de puntaje es: " + promedio);
                    break;
                case 4:
                    Equipo lider = obtenerEquipoConMasPuntos(equipos);
                    System.out.println("\nEQUIPO LIDER:");
                    lider.mostrarInformacion();
                    break;
                case 5:
                    double promedioPuntos = calcularPromedio(equipos);
                    mostrarZonaDescenso(equipos, promedioPuntos);
                    break;
                case 6:
                    mostarEquipos(equipos);
                    break;
                case 0:
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(opcion !=0);
    }

    public static void ingresarEquipos(Equipo[] equipos){
        Scanner entrada = new Scanner(System.in);
        for(int i =0; i< equipos.length;i++){
            System.out.println(
                "\n---EQUIPO " + (i+1) + " ---" 
            );
            System.out.println("Ingrese ID:");
            int id = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Ingrese nombre: ");
            String nombre = entrada.nextLine();
            entrada.nextLine();

            System.out.println("Ingrese puntaje acumulado: ");
            int puntaje = entrada.nextInt();
            entrada.nextLine();

            System.out.println("Ingrese partidos jugados: ");
            int partidos = entrada.nextInt();

            equipos[i] = new Equipo(
                id,
                nombre,
                puntaje,
                partidos
            );
        }
    }

    public static void actualizarPuntaje(Equipo[] equipos){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el ID del equipo:");
        int id = entrada.nextInt();
        boolean encontrado = false;
        for(int i = 0; i<equipos.length;i++){
            if(equipos[i].getIdEquipo() == id){
                System.out.println("Ingrese los puntos a agregar");
                int puntos = entrada.nextInt();
                int nuevosPuntajes = equipos[i].getPuntajeAcumulado() + puntos;

                equipos[i].setPartidosJugados(nuevosPuntajes);

                System.out.println("Puntaje actualizado correctamente ");

                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("No existe un equipo con ese ID");
        }
    }

    public static int calcularTotalPartidos(Equipo[] equipos){
        int total = 0;

        for(int i = 0; i<equipos.length; i++){
            total = total + equipos[i].getPartidosJugados();
        }
        return total;
    }

    public static double calcularPromedio(Equipo[] equipos){
        int suma = 0;
        for(int i = 0; i< equipos.length; i++){
            suma = suma + equipos[i].getPuntajeAcumulado();

        }
        double promedio = (double)suma / equipos.length;
        return promedio;
    }

    public static Equipo obtenerEquipoConMasPuntos(Equipo[] equipos){
        Equipo lider = equipos[0];
        for(int i = 0; i<equipos.length;i++){
            if(equipos[i].getPuntajeAcumulado() > lider.getPuntajeAcumulado()){
                lider = equipos[i];
            }
        }
        return lider;
    }
    public static void mostrarZonaDescenso(Equipo[] equipos,double promedio){
        boolean hayEquipo = false;

        System.out.println("\n EQUIPOS EN ZONA DE DESCENSO: ");

        for(int i = 0 ; i<equipos.length;i++){
            if(equipos[i].getPuntajeAcumulado()<promedio){
                equipos[i].mostrarInformacion();
                System.out.println("ESTE EQUIPO ESTA EN ZONA DE DESCENSO");

                hayEquipo = true;
            }
        }

        if(!hayEquipo){
            System.out.println("NO hay equipos por debajo del promedio");
        }
    }

    public static void mostarEquipos(Equipo[] equipos){
        for(int i = 0; i<equipos.length;i++){
            equipos[i].mostrarInformacion();
        }
    }
    public static void menu(){
        System.out.println("\n========= MENU =========");

        System.out.println("1. Actualizar puntaje de un equipo");
        System.out.println("2. Calcular total de partidos jugados");
        System.out.println("3. Mostrar promedio de puntajes");
        System.out.println("4. Mostrar equipo lider");
        System.out.println("5. Mostrar equipos en zona de descenso");
        System.out.println("6. Mostrar todos los equipos");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opcion: ");
    }
}
