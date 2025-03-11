package serveur;

import shared.ServeurInterface;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class Serveur {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ServeurImpl serveur = new ServeurImpl();
            Naming.rebind("rmi://localhost/ServeurService", serveur);
            System.out.println("Serveur RMI en attente...");

            // Allow server to send messages to clients
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Entrez un message pour notifier les clients (ou 'exit' pour quitter) : ");
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                serveur.notifierClients(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
