package Model;

import Model.Ships.Ship;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface spotShipServer extends Remote {
    void spotShip(Ship ship) throws RemoteException;
}
