package ServerController;

import Model.Ships.Ship;
import Model.spotShipServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements spotShipServer{

    public RMIServerImpl() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void spotShip(Ship ship) throws RemoteException {
        System.out.println(ship.getShipName());
    }
}
