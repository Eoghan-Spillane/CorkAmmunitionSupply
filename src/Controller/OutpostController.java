package Controller;

import Model.Outpost;
import Model.Ships.Ship;
import Model.DistributionHub;

import java.util.Observable;

public class OutpostController{
    Outpost kinsale = new Outpost("Kinsale"); //Observable
    Outpost youghal = new Outpost("Youghal"); //Observable
    DistributionHub blarney; //Observer


    public void checkForShipsWest(Ship ship){
        kinsale.spotShip(ship);
        Thread kinsaleThread = new Thread(kinsale);
        kinsaleThread.start();
    }

    public void checkForShipsEast(Ship ship){
        youghal.spotShip(ship);
        Thread youghalThread = new Thread(youghal);
        youghalThread.start();
    }

    public void createObserver(){
        DistributionHub blarney = new DistributionHub("Blarney", kinsale, youghal);
        Thread blarneyThread = new Thread(blarney);
        blarneyThread.start();
        kinsale.setAssignedDistributionHub(blarney);
        youghal.setAssignedDistributionHub(blarney);
    }

    public String getKinsaleName(){
        return kinsale.getOutpostName();
    }
    public String getYoughalName(){
        return youghal.getOutpostName();
    }

    public void setKinsaleName(String name){
        kinsale.setOutpostName(name);
    }

    public void setYoughalName(String name){
        youghal.setOutpostName(name);
    }

}
