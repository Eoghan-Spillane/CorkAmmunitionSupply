package KinsaleFiles;

import Controller.FactoryController;
import Model.Ships.Ship;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    static FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    Ship threat = null;
    //Spot Ships
    public void spotBattleshipWest(){
        threat = factories.buildBattleship();
        polling(threat);
    }

    public void spotDestroyerWest(){
        threat = factories.buildDestroyer();
        polling(threat);
    }

    public void spotSubmarineWest(){
        threat = factories.buildSubmarine();
        polling(threat);
    }

    public void polling(Ship ship){
        try{
            Socket socket = new Socket("localhost", 4998);
            System.out.println("Connected");

            //Object to be sent must be created first

            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(ship);

            System.out.println("Closing Socket");

            //Setting threat to null so that when after the object is sent it continues polling the server
            threat = null;
            thread();

            socket.close();
        }catch(IOException e){
            System.out.println("No Response From Server");
            thread();
        }
    }

    public void thread(){
        System.out.println("New Thread Starting");
        try{
            new Thread(new Runnable() {
                public void run() {
                    polling(threat);
                }
            }).start();
        }catch (Exception e){
            System.out.print("No Ship");
        }
    }

    public void startPolling(){
        polling(threat);
    }

}
