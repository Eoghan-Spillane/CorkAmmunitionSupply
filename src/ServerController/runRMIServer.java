package ServerController;

import Model.spotShipServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class runRMIServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        spotShipServer server = new RMIServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("Server Started");
    }

}
