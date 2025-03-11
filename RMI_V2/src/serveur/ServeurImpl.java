package serveur;

import shared.ServeurInterface;
import shared.ClientInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ServeurImpl extends UnicastRemoteObject implements ServeurInterface {
    
    private List<ClientInterface> clients = new ArrayList<>(); // List of registered clients

    public ServeurImpl() throws RemoteException {
        super();
    }

    @Override
    public String getHoraire() throws RemoteException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        return "Heure actuelle du serveur : " + formatter.format(new Date());
    }

    @Override
    public void enregistrerClient(ClientInterface client) throws RemoteException {
        clients.add(client);
        System.out.println("Un client a été enregistré.");
    }

    // Send notification to all registered clients
    public void notifierClients(String message) throws RemoteException {
        for (ClientInterface client : clients) {
            client.recevoirNotification(message);
        }
    }
}
