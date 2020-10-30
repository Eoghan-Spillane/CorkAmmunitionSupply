package Model.Ships;

public class BattleshipShipFactory implements ShipFactory {

    public BattleshipShip buildShip() {
        return new BattleshipShip("Battleship", 30,10,200);
    }

}
