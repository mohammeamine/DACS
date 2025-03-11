package client;

import shared.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
    
    public ClientImpl() throws RemoteException {
        super();
    }

    @Override
    public void recevoirNotification(String message) throws RemoteException {
        System.out.println("🔔 Notification reçue du serveur : " + message);
    }
}
