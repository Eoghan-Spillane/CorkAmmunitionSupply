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

            try{
                    Ship ship = (Ship) objectInputStream.readObject();
                    if (ship == null){
                        //Do Nothing
                    }else{
                        outposts.checkForShipsWest(ship);
                    }

            } catch (ClassNotFoundException e) {
                System.out.println("No Ship Spotted");
            }


            System.out.println("Closing Socket Server\n");
            serverSocket.close();
            socket.close();
            Server.restartSocketServer();

        }catch (IOException e){
            System.out.print("No Ship Sighted");
            Server.restartSocketServer();
        }
    }

    public OutpostController getOutpost(){
        return outposts;
    }
}