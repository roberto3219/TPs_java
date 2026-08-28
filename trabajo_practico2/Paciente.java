import java.util.Scanner;

public class Paciente {

    // =========================
    // ATRIBUTOS PRIVADOS
    // =========================
    private String nombre;
    private String dni;
    private double peso;
    private double altura;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Paciente(String nombre, String dni, double peso, double altura) {
        setNombre(nombre);
        setDni(dni);
        setPeso(peso);
        setAltura(altura);
    }

    // =========================
    // GETTERS
    // =========================
    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    // =========================
    // SETTERS CON VALIDACIONES
    // =========================
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        this.nombre = nombre;
    }

    public void setDni(String dni) {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede estar vacío.");
        }
        if(dni.length() != 8){
            throw new IllegalArgumentException("El DNI debe tener 8 digitos .");
        }
        this.dni = dni;
    }

    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor que 0.");
        }

        this.peso = peso;
    }

    public void setAltura(double altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("La altura debe ser mayor que 0.");
        }

        this.altura = altura;
    }

    // =========================
    // MÉTODO PARA CALCULAR EL IMC
    // =========================
    public double calcularIMC(double peso,double altura) {
        return peso / (altura * altura);
    }

    // =========================
    // MÉTODO PARA OBTENER EL ESTADO NUTRICIONAL
    // =========================
    public String estadoNutricional() {

        double imc = calcularIMC(peso,altura);

        if (imc < 18.5) {
            return "Bajo peso";
        } else if (imc < 25) {
            return "Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidad";
        }
    }

    // =========================
    // MÉTODO AUXILIAR PARA LEER TEXTO
    // =========================
    private static String ingresarTexto(Scanner teclado, String mensaje) {

        while (true) {
            try {
                System.out.print(mensaje);
                String dato = teclado.nextLine();

                if (dato.trim().isEmpty()) {
                    throw new IllegalArgumentException(
                            "El dato no puede estar vacío."
                    );
                }
                if(dato.length() < 4){
                    throw new IllegalArgumentException("Debe tener al menos 4 caracteres");
                }

                return dato;

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private static String leerDNI(Scanner teclado,String mensaje){
        while (true){
            try{
                System.out.print(mensaje);
                String dato = teclado.nextLine();
                if(!dato.matches("[0-9]+")){
                    throw new Exception("Debe contener solo numeros");
                }
                if(dato.length() != 8){
                    throw new Exception("Debe tener 8 caracteres");
                }
                return dato;
            }catch(Exception e){
                System.out.println("Error: " + e);
            }
        }
    }


    // =========================
    // MÉTODO AUXILIAR PARA LEER PESO
    // =========================
    private static double ingresarPeso(Scanner teclado) {

        while (true) {
            try {
                System.out.print("Ingrese el peso en kg: ");

                String entrada = teclado.nextLine();

                // Permite ingresar 70,5 o 70.5
                entrada = entrada.replace(',', '.');

                double peso = Double.parseDouble(entrada);

                if (peso <= 0) {
                    throw new IllegalArgumentException(
                            "El peso debe ser mayor que 0."
                    );
                }

                return peso;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: debe ingresar un número válido."
                );

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // =========================
    // MÉTODO AUXILIAR PARA LEER ALTURA
    // =========================
    private static double ingresarAltura(Scanner teclado) {

        while (true) {
            try {
                System.out.print("Ingrese la altura en metros(Ejemplo:1.70): ");

                String entrada = teclado.nextLine();


                if (!entrada.matches("[12]\\.[0-9]{2}")) {
                    throw new Exception("La altura debe escribirse como 1.70 por ejemplo");
                }

                // Permite ingresar 1,75 o 1.75
                entrada = entrada.replace(',', '.');

                double altura = Double.parseDouble(entrada);

                if (altura <= 0) {
                    throw new IllegalArgumentException(
                            "La altura debe ser mayor que 0."
                    );
                }

                return altura;

            } catch (NumberFormatException e) {
                System.out.println(
                        "Error: debe ingresar un número válido."
                );

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch(Exception e){
                System.out.println("Error: " + e);
            }

        }
    }

    // =========================
    // MENÚ DENTRO DE LA CLASE
    // =========================
    public static void menu() {
        do{
            Scanner continuar = new Scanner(System.in);
            Scanner teclado = new Scanner(System.in);

            System.out.println("======================================");
            System.out.println("       GESTIÓN DE INFORMACIÓN");
            System.out.println("             DEL PACIENTE");
            System.out.println("======================================");

            // Ingreso de datos
            String nombre = ingresarTexto(
                    teclado,
                    "Ingrese el nombre: "
            );

            String dni = leerDNI(
                    teclado,
                    "Ingrese el DNI: "
            );

            double peso = ingresarPeso(teclado);

            double altura = ingresarAltura(teclado);

            // Crear el objeto Paciente utilizando el constructor
            Paciente paciente = new Paciente(
                    nombre,
                    dni,
                    peso,
                    altura
            );

            // Calcular IMC
            double imc = paciente.calcularIMC(peso,altura);

            // Mostrar información
            System.out.println();
            System.out.println("======================================");
            System.out.println("        DATOS DEL PACIENTE");
            System.out.println("======================================");

            System.out.println("Nombre: " + paciente.getNombre());
            System.out.println("DNI: " + paciente.getDni());
            System.out.println("Peso: " + paciente.getPeso() + " kg");
            System.out.println("Altura: " + paciente.getAltura() + " m");

            System.out.printf("IMC: %.2f%n", imc);

            System.out.println(
                    "Estado nutricional: "
                    + paciente.estadoNutricional()
            );

            System.out.println("======================================");

            System.out.println("Desea continuar? (S/N):");
            String opcion = continuar.nextLine();
            if(opcion.equalsIgnoreCase("n")){
                System.out.println("Gracias, Hasta luego  ");
                break;
            }
        }while(true);


    }

    // =========================
    // PROGRAMA PRINCIPAL
    // =========================
    public static void main(String[] args) {
        menu();
    }
}
