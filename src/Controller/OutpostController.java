package Controller;

import Model.Outpost;
import Model.Ships.Ship;
import Model.DistributionHub;

import java.util.Observable;

public class OutpostController{
    Outpost kinsale = new Outpost("Kinsale"); //Observable
    Outpost youghal = new Outpost("Youghal"); //Observable

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
        DistributionHub.getInstance().setName("Blarney");
        DistributionHub.getInstance().AddObservers(kinsale, youghal);
        Thread blarneyThread = new Thread(DistributionHub.getInstance());
        blarneyThread.start();
        kinsale.setAssignedDistributionHub(DistributionHub.getInstance());
        youghal.setAssignedDistributionHub(DistributionHub.getInstance());
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
