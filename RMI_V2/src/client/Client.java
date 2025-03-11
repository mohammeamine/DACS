package client;

import shared.ServeurInterface;
import shared.ClientInterface;
import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            // Retrieve the remote server object
            ServeurInterface serveur = (ServeurInterface) Naming.lookup("rmi://localhost/ServeurService");
            
            // Create client object
            ClientInterface client = (ClientInterface) new ClientImpl();

            // Register client on the server
            serveur.enregistrerClient(client);
            System.out.println("✅ Client enregistré auprès du serveur.");

            // Get server time
            System.out.println(serveur.getHoraire());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
