package YoughalFiles;

import Controller.FactoryController;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    rmiClient client = new rmiClient();

    //Spot Ships
    public void spotDestroyerEast() throws RemoteException {
        client.spotShip(factories.buildDestroyer());
    }

    public void spotBattleshipEast() throws RemoteException {
        client.spotShip(factories.buildBattleship());
    }

    public void spotSubmarineEast() throws RemoteException {
        client.spotShip(factories.buildSubmarine());
    }

    public void startRMI() throws RemoteException, NotBoundException {
        client.startClient();
    }

    public void start() throws RemoteException, NotBoundException {
        startRMI();
    }
}
