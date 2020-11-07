package Model.Ships;

public class DestroyerShipFactory implements ShipFactory {

    public DestroyerShip buildShip() {
        return new DestroyerShip("Destroyer", 15,30,100);
    }
}
