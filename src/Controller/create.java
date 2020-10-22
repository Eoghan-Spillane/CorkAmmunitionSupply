package Controller;

import Model.Bomb;
import Model.Ship;

public class create {

    public Ship buildSpecialShip(String name, int armorThickness, int speed, int hitPoints){
        return new Ship(name, armorThickness, speed, hitPoints);
    }

    public Ship buildDestroyer(){
        return new Ship("Destroyer", 20, 30, 100);
    }

    public Ship buildBattleship(){
        return new Ship("Battleship", 40, 15, 150);
    }

    public Bomb buildSpecialBomb(String name, int damage, int penetration){
        return new Bomb(name, damage, penetration);
    }

}
