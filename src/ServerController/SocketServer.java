package ServerController;

import Model.Ships.Ship;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class SocketServer implements Runnable{
    static OutpostController outposts = new OutpostController();

    @Override
    public void run() {
        System.out.println("Socket Server Started");

        try{
            ServerSocket serverSocket = new ServerSocket(4998);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Ship ship = (Ship) objectInputStream.readObject();
            outposts.checkForShipsWest(ship);

            System.out.println("Closing Socket Server\n");
            serverSocket.close();
            socket.close();
            Server.restartSocketServer();

        }catch (IOException | ClassNotFoundException e){
            System.out.print("ERROR");
        }
    }

    public OutpostController getOutpost(){
        return outposts;
    }
}
