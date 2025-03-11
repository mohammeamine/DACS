package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    void recevoirNotification(String message) throws RemoteException; // Receive a notification from server
}
