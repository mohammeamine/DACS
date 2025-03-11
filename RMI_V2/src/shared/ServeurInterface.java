package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServeurInterface extends Remote {
    String getHoraire() throws RemoteException; // Get server time
    void enregistrerClient(ClientInterface client) throws RemoteException; // Register client for notifications
}
