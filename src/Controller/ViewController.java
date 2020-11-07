package Controller;

import Controller.FactoryController;
import Controller.OutpostController;
import Model.Ships.BattleshipShipFactory;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    static FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    static OutpostController outposts = new OutpostController();  //This contains all the methods needed for the Observer, Observables and Threads.
    static int fleetCounter = -1;

    //Spot Ships
    public void spotDestroyerEast(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsEast(factories.buildDestroyer());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotBattleshipEast(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsEast(factories.buildBattleship());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotSubmarineEast(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsEast(factories.buildSubmarine());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotBattleshipWest(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsWest(factories.buildBattleship());
            //outposts.checkForShipsWest(new BattleshipShipFactory().buildShip());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotDestroyerWest(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsWest(factories.buildDestroyer());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotSubmarineWest(){

        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsWest(factories.buildSubmarine());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }


    // Misc
    public void checkOutpostName(){
        System.out.print(outposts.getKinsaleName());
        System.out.print(outposts.getYoughalName());
    }

    public void switchOnPowerInBlarney(){
        outposts.createObserver();
    }

}
