package Model.Dao;

import Model.Bombs.Bomb;
import Model.Ships.Ship;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class BlarneyProductionImpl implements ProductionLogDao {
    private static BlarneyProductionImpl Impl;
    List<BlarneyProductionLog> Logs;

    private BlarneyProductionImpl() {
        Logs = new ArrayList<BlarneyProductionLog>();
    }

    @Override
    public List<BlarneyProductionLog> getAllLogs() {
        return Logs;
    }

    @Override
    public void addLog(Bomb bomb, Ship ship, String fort) {
        Logs.add(new BlarneyProductionLog(bomb, ship, fort));
        processLog();
        SaveList();
    }

    public static BlarneyProductionImpl getInstance(){
        if (Impl == null){
            Impl = new BlarneyProductionImpl();
        }
        return Impl;
    }

    public void processLog(){
        try {
            FileWriter myWriter = new FileWriter("BlarneyProductionLog.txt");

            for (BlarneyProductionLog x: Logs) {
                myWriter.write(x.toString());
            }

            myWriter.close();
        } catch(IOException e) {
            System.out.println("An error occurred when writing txt Log");
        }
    }

    public void SaveList(){
        try {
            FileOutputStream fileOut = new FileOutputStream("SerializedLogs.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(Logs);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
