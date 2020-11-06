package Model;

import Model.Ships.Ship;

import java.util.Observable;
import java.util.Observer;

public class DistributionHub implements Observer {
    Observable outpost1; //Kinsale
    Observable outpost2; //Youghal
    String name;
    int Threats;

    public DistributionHub(String hubName, Observable Ob1, Observable Ob2 ) {
        System.out.print("\nBlarney Powering Up\n");
        name = hubName;
        this.outpost1 = Ob1;
        this.outpost2 = Ob2;
        outpost1.addObserver(this);
        outpost2.addObserver(this);
    }

    @Override
    public void update(Observable obs, Object arg) {
        try{
            Threats++;
            System.out.print("\nNew Threat Spotted in "+ ((Outpost) obs).getOutpostName() + ", " + ((Ship) arg).getShipName() + " Detected. Currently " + Threats + " ships in the fleet");
        }catch (Exception e){
            System.out.print("No Ship");
        }
    }
}
