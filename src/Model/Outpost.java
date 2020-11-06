package Model;

import Model.Ships.Ship;

import java.util.Observable;

public class Outpost extends Observable implements Runnable {
    private String name;
    private Ship arrivingShip;

    public Outpost(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        try{
            System.out.print("\nThread " + Thread.currentThread().getId() + " is Running - Start");

            Thread.sleep(1000);
            setChanged();
            notifyObservers(arrivingShip);

            if(hasChanged()){
                clearChanged();
            }

            System.out.print("\nThread " + Thread.currentThread().getId() + " is Running - End");

        }catch (Exception e){
            System.out.println("Exception is caught");

        }
    }

    public void spotShip(Ship ship){
        this.arrivingShip = ship;
    }

    public String getOutpostName() {
        return name;
    }

    public void setOutpostName(String name) {
        this.name = name;
    }


}
