package ServerController;

import Model.Ships.Ship;
import Model.spotShipServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements spotShipServer{
    OutpostController outposts;
    public RMIServerImpl(OutpostController outpost) throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        outposts = outpost;
    }

    @Override
    public void spotShip(Ship ship) throws RemoteException {
        outposts.checkForShipsEast(ship);
    }
}
