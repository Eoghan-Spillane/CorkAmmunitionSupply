package Controller;

import Controller.FactoryController;
import Controller.OutpostController;
import Model.Ships.BattleshipShipFactory;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    OutpostController outposts = new OutpostController();  //This contains all the methods needed for the Observer, Observables and Threads.
    int fleetCounter = 0;

    //Spot Ships
    public void spotDestroyerEast(){
        if(fleetCounter < 10){
            System.out.println(fleetCounter);
            fleetCounter++;
            outposts.checkForShipsEast(factories.buildDestroyer());
        }
        else{
            System.out.print("\n Fleet Full, there are " + fleetCounter + " Ships");
        }
    }

    public void spotBattleshipEast(){
        outposts.checkForShipsEast(factories.buildBattleship());
    }

    public void spotSubmarineEast(){
        outposts.checkForShipsEast(factories.buildSubmarine());
    }

    public void spotBattleshipWest(){
        outposts.checkForShipsWest(factories.buildBattleship());
        //outposts.checkForShipsWest(new BattleshipShipFactory().buildShip());
    }

    public void spotDestroyerWest(){
        outposts.checkForShipsWest(factories.buildDestroyer());
    }

    public void spotSubmarineWest(){
        outposts.checkForShipsWest(factories.buildSubmarine());
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
