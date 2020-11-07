package Model.Bombs;

public class HighExplosiveBombFactory implements BombFactory{

    public HighExplosive buildBomb(){
        return new HighExplosive("High Explosive", 100, 10);
    }
}
