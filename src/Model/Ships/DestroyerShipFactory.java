package Model.Ships;

public class DestroyerShipFactory implements ShipFactory {

    public DestroyerShip buildShip() {
        return new DestroyerShip("Destroyer", 10,30,100);
    }
}
