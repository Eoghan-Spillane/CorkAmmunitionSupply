package Model;

import Controller.FactoryController;
import Model.Bombs.Bomb;
import Model.Ships.Ship;
import java.util.Observable;
import java.util.Observer;

public class DistributionHub implements Runnable, Observer {
    private static DistributionHub hub;
    FactoryController factories = new FactoryController();
    Observable outpost1; //Kinsale
    Observable outpost2; //Youghal
    String name;
    Bomb capacity = null;

//    private DistributionHub(String hubName, Observable Ob1, Observable Ob2) {
//        System.out.print("\nBlarney Powering Up\n");
//        name = hubName;
//        this.outpost1 = Ob1;
//        this.outpost2 = Ob2;
//        outpost1.addObserver(this);
//        outpost2.addObserver(this);
//    }

    private DistributionHub(){
        System.out.println("Distribution Hub Running");
    }

    public void AddObservers(Observable Ob1, Observable Ob2){
        this.outpost1 = Ob1;
        this.outpost2 = Ob2;
        outpost1.addObserver(this);
        outpost2.addObserver(this);
    }

    public void setName(String name){
        this.name = name;
    }

    public void produce(Ship threat) throws InterruptedException{
            synchronized (this) {
                while (capacity != null) {
                    wait();
                }

                if(threat.getArmorThicc() > 25){
                    capacity = factories.buildSabotBomb();
                }else if(threat.getArmorThicc() > 10){
                    capacity = factories.buildHighExplosiveBomb();
                }else{
                    capacity = factories.buildTorpedoBomb();
                }

                notify();

                //Thread.sleep(1000);
            }
    }

    public void consume() throws InterruptedException{
        while (true) {
            synchronized (this) {
                while (capacity == null){
                    wait();
                }

                System.out.println("\n" + capacity.toString());
                capacity = null;

                notify();

//                try{
                    //Thread.sleep(2000);
//                }catch (Exception e){
//                    System.out.println("Exception is caught");
//                }
            }
        }
    }

    @Override
    public void update(Observable obs, Object arg) {
        System.out.print("\nThread " + Thread.currentThread().getId() + " is Updating");
        try{
            // Create producer thread
            new Thread(new Runnable() {
                @Override
                public void run()
                {
                    try {
                        produce(((Ship) arg));
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            //System.out.print("\nThread " + Thread.currentThread().getId() + " is Updating");
            System.out.print("\nNew Threat Spotted in "+ ((Outpost) obs).getOutpostName() + ", " + ((Ship) arg).getShipName() + " Detected.");
        }catch (Exception e){
            System.out.print("No Ship");
        }
    }

    @Override
    public void run() {
        try{
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        consume();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }catch (Exception e){
            System.out.println("Observer Failed");
        }
    }

    public static DistributionHub getInstance(){
        if(hub == null){
            hub = new DistributionHub();
        }
        return hub;
    }

}
