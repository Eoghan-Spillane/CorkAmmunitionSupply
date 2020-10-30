package Model.Ships;

public abstract class Ship {
    private int hitPoints;
    private String shipName;
    private int armorThicc;
    private int speed;

    public Ship(String name, int armorThickness, int speed, int hitPoints){
        this.shipName = name;
        this.armorThicc = armorThickness;
        this.speed = speed;
        this.hitPoints = hitPoints;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getArmorThicc() {
        return armorThicc;
    }

    public void setArmorThicc(int armorThicc) {
        this.armorThicc = armorThicc;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void takeDamage(int damageValue){
        hitPoints = hitPoints - (damageValue - armorThicc);
    }

    public boolean isSank(){
        return hitPoints <= 0;
    }

    public String toString(){
        return "The " + shipName + " has taken " + (100 - hitPoints) + " points of damage. /nIt is moving at " + speed + " knots. /nIt's armor is " + armorThicc + "mm thick.";
    }
}
