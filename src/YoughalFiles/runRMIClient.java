package YoughalFiles;

import Controller.FactoryController;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class runRMIClient {
    private static FactoryController factory = new FactoryController();

    public static void main(String[] args) throws RemoteException, NotBoundException {
        rmiClient client = new rmiClient();
        client.startClient();

        client.spotShip(factory.buildBattleship());

    }
}
