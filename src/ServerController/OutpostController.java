package ServerController;

import Model.Outpost;
import Model.Ships.Ship;
import Model.DistributionHub;

public class OutpostController{
    Outpost kinsale = new Outpost("Kinsale"); //Observable
    Outpost youghal = new Outpost("Youghal"); //Observable


    // This function is used to spot new ships in Kinsale
    public void checkForShipsWest(Ship ship){
        kinsale.spotShip(ship);
        Thread kinsaleThread = new Thread(kinsale);
        kinsaleThread.start();
    }

    // This function is used to spot new ships in Youghal
    public void checkForShipsEast(Ship ship){
        youghal.spotShip(ship);
        Thread youghalThread = new Thread(youghal);
        youghalThread.start();
    }

    // Singleton Pattern & Observer Pattern
    public void createObserver(){
        DistributionHub.getInstance().setName("Blarney"); //Singleton pattern & Observer
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
