package Model.Bombs;

public abstract class Bomb {
    private int damage;
    private String bombDesignation;
    private int penetration;

    public Bomb(String bombName, int damage, int penetration){
        this.bombDesignation = bombName;
        this.penetration = penetration;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getBombDesignation() {
        return bombDesignation;
    }

    public void setBombDesignation(String bombDesignation) {
        this.bombDesignation = bombDesignation;
    }

    public int getPenetration() {
        return penetration;
    }

    public void setPenetration(int penetration) {
        this.penetration = penetration;
    }

    public String toString(){
        return "Bomb Type: " + bombDesignation + ", Penetration Depth: " + penetration + ", Damage Value: " + damage;
    }
}
