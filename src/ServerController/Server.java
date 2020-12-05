package ServerController;


import Model.spotShipServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private static SocketServer socketServerBase = new SocketServer();
    static OutpostController outposts = socketServerBase.getOutpost();


    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
            outposts.createObserver();

            Thread socketServer = new Thread((Runnable) socketServerBase);
            socketServer.start();

        spotShipServer server = new RMIServerImpl(outposts);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("Server", server);
        System.out.println("RMI Server Started\n\n");
    }

    public static void restartSocketServer(){
        Thread socketServer = new Thread((Runnable) socketServerBase);
        socketServer.start();
    }

}
