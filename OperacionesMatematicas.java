package rmiinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interfaz para definir operaciones matemáticas remotas
 */
public interface OperacionesMatematicas extends Remote {
    
    /**
     * Calcula el logaritmo natural de un número
     * @param numero El número para calcular su logaritmo natural
     * @return El resultado del logaritmo natural
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public double calcularLogaritmoNatural(double numero) throws RemoteException;
    
    /**
     * Calcula el promedio de un arreglo de números
     * @param numeros El arreglo de números
     * @return El promedio de los números en el arreglo
     * @throws RemoteException Si ocurre un error en la comunicación remota
     */
    public double calcularPromedio(double[] numeros) throws RemoteException;
    
}