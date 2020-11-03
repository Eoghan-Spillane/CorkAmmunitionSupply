package Controller;

import Controller.FactoryController;

public class ViewController {
    FactoryController factories = new FactoryController();

    public void printShips(){
        System.out.print(factories.buildDestroyer().toString());
    }

    public void printBombs(){
        System.out.print(factories.buildTorpedoBomb());
    }

}
