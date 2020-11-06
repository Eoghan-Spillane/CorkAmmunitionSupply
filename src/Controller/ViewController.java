package Controller;

import Controller.FactoryController;
import Controller.OutpostController;
import Model.Ships.BattleshipShipFactory;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    OutpostController outposts = new OutpostController();  //This contains all the methods needed for the Observer, Observables and Threads.

    public void switchOnPowerInBlarney(){
        outposts.createObserver();
    }

    public void spotDestroyerEast(){
        outposts.checkForShipsEast(factories.buildDestroyer());
    }

    public void spotBattleshipWest(){
        outposts.checkForShipsWest(factories.buildBattleship());
        //outposts.checkForShipsWest(new BattleshipShipFactory().buildShip());
    }

    public void checkOutpostName(){
        System.out.print(outposts.getKinsaleName());
        System.out.print(outposts.getYoughalName());
    }

}
