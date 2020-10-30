package Model.Bombs;

public class SabotBombFactory implements BombFactory{

    public Bomb buildBomb() {
        return new SabotBomb("Sabot Shell", 40, 50);
    }
}
