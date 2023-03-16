package srcs.Prototypes.Turrets;

import java.util.ArrayList;

import srcs.Enums.TeamType;
import srcs.Prototypes.Turrets.TurretLists.FireGunTurret;
import srcs.Prototypes.Turrets.TurretLists.RedLaserTurret;

public class TurretsData {
    private static TurretsData instance;
    private ArrayList<TurretPrototype> availableTurrents = new ArrayList<>();

    public static TurretsData getInstance() {
        if (instance == null)
            instance = new TurretsData();
        return instance;
    }

    private TurretsData() {
        init();
    }

    private void init() {
        availableTurrents.add(new FireGunTurret(TeamType.PLAYER));
        availableTurrents.add(new RedLaserTurret(TeamType.PLAYER));
    }

    public ArrayList<TurretPrototype> getAvailableTurrents() {
        return availableTurrents;
    }

    public void setAvailableTurrents(ArrayList<TurretPrototype> availableTurrents) {
        this.availableTurrents = availableTurrents;
    }
}
