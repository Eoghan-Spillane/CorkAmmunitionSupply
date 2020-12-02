package KinsaleFiles;

import Controller.FactoryController;
import ServerController.OutpostController;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    static FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily

    //Spot Ships
    public void spotBattleshipWest(){
        try{
            Socket socket = new Socket("localhost", 4998);
            System.out.println("Connected");

            //Object to be sent must be created first

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(factories.buildBattleship());

            System.out.println("Closing Socket");

            //Forces unsent data to be sent
            socket.close();
        }catch(IOException e){
            System.out.println("No Response From Server");
        }
    }

    public void spotDestroyerWest(){
        try{
            Socket socket = new Socket("localhost", 4998);
            System.out.println("Connected");

            //Object to be sent must be created first

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(factories.buildDestroyer());

            System.out.println("Closing Socket");

            //Forces unsent data to be sent
            socket.close();
        }catch(IOException e){
            System.out.println("No Response From Server");
        }
    }

    public void spotSubmarineWest(){
        try{
            Socket socket = new Socket("localhost", 4998);
            System.out.println("Connected");

            //Object to be sent must be created first

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(factories.buildSubmarine());

            System.out.println("Closing Socket");

            //Forces unsent data to be sent
            socket.close();
        }catch(IOException e){
            System.out.println("No Response From Server");
        }
    }

}
