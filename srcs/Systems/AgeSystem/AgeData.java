package srcs.Systems.AgeSystem;
import java.awt.*;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.AgeType;
import srcs.Enums.TeamType;
import srcs.Prototypes.Characters.CharacterPrototype;
import srcs.Prototypes.Tower.TowerPrototype;
import srcs.Prototypes.Turrets.TurretPrototype;

public abstract class AgeData {
    private AgeData nextAgeData;
    private AgeType ageType;
    private Image backgroundImage;
    private ArrayList<CharacterPrototype>  characterPrototypes = new ArrayList<>();
    private ArrayList<TurretPrototype> turretPrototypes = new ArrayList<>();
    // private Image ultimateGameObject;
    private TowerPrototype towerPrototype;
    private int expRequiredToUpgrade;
    private Image upgradeImage;
    // protected AgeData() { }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public ArrayList<CharacterPrototype> getCharacterPrototypes() {
        return characterPrototypes;
    }

    public void setCharacterPrototypes(ArrayList<CharacterPrototype> characterPrototypes) {
        this.characterPrototypes = characterPrototypes;
    }

    public ArrayList<TurretPrototype> getTurretPrototypes() {
        return turretPrototypes;
    }

    public void setTurretPrototypes(ArrayList<TurretPrototype> turretPrototypes) {
        this.turretPrototypes = turretPrototypes;
    }

    public TowerPrototype getTowerPrototype() {
        return towerPrototype;
    }

    public void setTowerPrototype(TowerPrototype towerPrototype) {
        this.towerPrototype = towerPrototype;
    }

    public int getExpRequiredToUpgrade() {
        return expRequiredToUpgrade;
    }

    public void setExpRequiredToUpgrade(int expRequiredToUpgrade) {
        this.expRequiredToUpgrade = expRequiredToUpgrade;
    }

    public Image getUpgradeImage() {
        return upgradeImage;
    }

    public void setUpgradeImage(Image upgradeImage) {
        this.upgradeImage = upgradeImage;
    }

    public AgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(AgeType ageType) {
        this.ageType = ageType;
    }

    public AgeData getNextAgeData() {
        return nextAgeData;
    }

    public void setNextAgeData(AgeData nextAgeData) {
        this.nextAgeData = nextAgeData;
    }

    // * This is for factory pattern
    public TowerPrototype getNewTowerPrototype(TeamType team) {
        // return new TowerPrototype(0, null, null, null, null, null)
        return new TowerPrototype(
            towerPrototype.getHp(),
            team,
            towerPrototype.getTurretAbove(),
            towerPrototype.getTurretBelow(),
            towerPrototype.getImageData(),
            towerPrototype.getPosition()
        );

    }

}
