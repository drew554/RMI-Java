package rmiclient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import rmiinterface.OperacionesMatematicas;

/**
 * Cliente RMI para conectar con el servidor
 */
public class ClienteRMI {
    
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            
            // Dirección IP del servidor
            System.out.print("Ingrese la direccion IP del servidor: ");
            String serverIP = scanner.nextLine();
            
            // Obtener referencia al registro remoto
            Registry registry = LocateRegistry.getRegistry(serverIP, 1099);
            
            // Buscar el objeto remoto por su nombre
            OperacionesMatematicas operaciones = (OperacionesMatematicas) registry.lookup("OperacionesMatematicas");
            
            int opcion;
            do {
                // Menú de opciones
                System.out.println("\n--- MENU DE OPERACIONES ---");
                System.out.println("1. Calcular logaritmo natural");
                System.out.println("2. Calcular promedio de arreglo");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el numero para calcular su logaritmo natural: ");
                        double numero = scanner.nextDouble();
                        double resultadoLog = operaciones.calcularLogaritmoNatural(numero);
                        System.out.println("El logaritmo natural de " + numero + " es: " + resultadoLog);
                        break;
                        
                    case 2:
                        System.out.print("Ingrese la cantidad de numeros para el arreglo: ");
                        int cantidadNumeros = scanner.nextInt();
                        double[] arreglo = new double[cantidadNumeros];
                        
                        for (int i = 0; i < cantidadNumeros; i++) {
                            System.out.print("Ingrese el numero " + (i+1) + ": ");
                            arreglo[i] = scanner.nextDouble();
                        }
                        
                        double resultadoPromedio = operaciones.calcularPromedio(arreglo);
                        System.out.println("El promedio del arreglo es: " + resultadoPromedio);
                        break;
                        
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                        
                    default:
                        System.out.println("Opcion no valida. Intente nuevamente.");
                }
                
            } while (opcion != 0);
            
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}