package Model.Bombs;

public class TorpedoBombFactory implements BombFactory{

    public Bomb buildBomb() {
        return new TorpedoBomb("Torpedo", 100, 50);
    }

}
