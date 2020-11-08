package Model.Dao;

import Model.Bombs.Bomb;
import Model.Ships.Ship;

import java.util.List;

public interface ProductionLogDao {
    public List<BlarneyProductionLog> getAllLogs();

    public void addLog(Bomb bomb, Ship ship, String fort);
}
