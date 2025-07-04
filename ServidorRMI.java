package rmiserver;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmiinterface.OperacionesMatematicas;

/**
 * Implementación del servidor RMI
 */
public class ServidorRMI extends UnicastRemoteObject implements OperacionesMatematicas {
    
    public ServidorRMI() throws RemoteException {
        super();
    }
    
    @Override
    public double calcularLogaritmoNatural(double numero) throws RemoteException {
        System.out.println("Calculando logaritmo natural de: " + numero);
        return Math.log(numero);
    }
    
    @Override
    public double calcularPromedio(double[] numeros) throws RemoteException {
        System.out.println("Calculando promedio de un arreglo de " + numeros.length + " elementos");
        double suma = 0;
        for (double num : numeros) {
            suma += num;
        }
        return suma / numeros.length;
    }
    
    public static void main(String[] args) {
        try {
            // Crear el objeto del servidor
            ServidorRMI servidor = new ServidorRMI();
            
            // Crear y exportar el registro en el puerto 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Vincular el objeto remoto al registro con un nombre
            registry.rebind("OperacionesMatematicas", servidor);
            
            System.out.println("Servidor RMI iniciado. Esperando conexiones...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}