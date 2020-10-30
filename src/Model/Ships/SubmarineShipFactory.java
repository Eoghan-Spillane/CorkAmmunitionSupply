package Model.Ships;

public class SubmarineShipFactory implements ShipFactory{

    public SubmarineShip buildShip(){
        return new SubmarineShip("Submarine", 5, 20, 30);
    }

}
