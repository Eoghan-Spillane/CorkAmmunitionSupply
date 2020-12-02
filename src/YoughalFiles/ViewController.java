package YoughalFiles;

import Controller.FactoryController;
import ServerController.OutpostController;

// This class holds the functions that are activated by button presses in the gui
public class ViewController {
    static FactoryController factories = new FactoryController(); //This places all the ShipFactories/BombFactories methods in once place to be called more easily
    static OutpostController outposts = new OutpostController();  //This contains all the methods needed for the Observer, Observables and Threads.
    static int fleetCounter = 0;

    //Spot Ships
    public void spotDestroyerEast(){
        if(fleetCounter < 10){
            fleetCounter++;
            outposts.checkForShipsEast(factories.buildDestroyer());
        } else{
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

    // Misc
    public void checkOutpostName(){
        System.out.print(outposts.getKinsaleName());
        System.out.print(outposts.getYoughalName());
    }

    public void switchOnPowerInBlarney(){
        outposts.createObserver();
    }

}
