package Model.Bombs;

public class HighExplosiveBombFactory {

    public HighExplosive buildBomb(){
        return new HighExplosive("High Explosive", 100, 10);
    }
}
