package Controller;

import Model.Bombs.*;
import Model.Ships.*;

public class FactoryController {

    // Calls the Ship Factories and Creates them.
    public Ship buildDestroyer(){
        return new DestroyerShipFactory().buildShip();
    }

    public Ship buildBattleship(){
        return new BattleshipShipFactory().buildShip();
    }

    public Ship buildSubmarine(){
        return new SubmarineShipFactory().buildShip();
    }

    // Calls the bomb factories and creates them.
    public Bomb buildHighExplosiveBomb(){
        return new HighExplosiveBombFactory().buildBomb();
    }

    public Bomb buildSabotBomb(){
        return new SabotBombFactory().buildBomb();
    }

    public Bomb buildTorpedoBomb(){
        return new TorpedoBombFactory().buildBomb();
    }

}
