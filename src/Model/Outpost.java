package Model;

import Model.Ships.Ship;
import java.util.Observable;

public class Outpost extends Observable implements Runnable {
    private String name;
    private Ship arrivingShip;
    DistributionHub assignedDistributionHub;

    public Outpost(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            try{
                //System.out.print("\nThread " + Thread.currentThread().getId() + " at "+ this.name + " is Running - Start");
                    //System.out.print("\nThread " + Thread.currentThread().getId() + " is Updating");
                    Ship ship = arrivingShip;
                    Thread.sleep(1000);
                    setChanged();
                    notifyObservers(ship);

                    if (hasChanged()) {
                        clearChanged();
                    }
                //System.out.print("\nThread " + Thread.currentThread().getId() + " is Running - End");
            }catch (Exception e){
                System.out.println("\tException is Caught. Makes Sure Blarney is Running");
                System.exit(0);
            }
    }

    public void spotShip(Ship ship){
        this.arrivingShip = ship;
    }

    public void setAssignedDistributionHub(DistributionHub hub){
        this.assignedDistributionHub = hub;
    }

    public String getOutpostName() {
        return name;
    }

    public void setOutpostName(String name) {
        this.name = name;
    }


}
