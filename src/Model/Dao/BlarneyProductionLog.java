package Model.Dao;

import Model.Bombs.Bomb;
import Model.Ships.Ship;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlarneyProductionLog implements java.io.Serializable{
    Ship threat;
    Bomb response;
    String fort;
    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss");
    Date date = new Date(System.currentTimeMillis());

    public BlarneyProductionLog(Bomb bomb, Ship ship, String fort) {
        this.threat = ship;
        this.response = bomb;
        this.fort = fort;
    }

    public String toString(){
      return "Time/Date: "+ formatter.format(date) + "\t Threat: " + threat.getShipName() + "\t Fort: " + fort  + "\t Response Sent: " + response.getBombDesignation() + "\n";
    }
}
