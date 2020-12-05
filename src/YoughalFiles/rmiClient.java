package YoughalFiles;

import Model.Ships.Ship;
import Model.spotShipServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class rmiClient {

    private spotShipServer server;

    public rmiClient() { }

    public void startClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (spotShipServer) registry.lookup("Server");
    }

    public String spotShip(Ship ship) throws RemoteException {
        String result = null;
        try{
            server.spotShip(ship);
        } catch (RemoteException e){
            e.printStackTrace();
            throw new RuntimeException("Could not contact server");
        }
        return null;
    }
}
