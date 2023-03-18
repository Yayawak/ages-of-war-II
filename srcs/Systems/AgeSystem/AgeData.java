package srcs.Systems.AgeSystem;
import java.awt.*;
import java.util.ArrayList;

import helpers.ImageData;
import srcs.Enums.AgeType;
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

    // protected AgeData(String relPathToBgImage,
    //     ArrayList<CharacterPrototype> characterPrototypes,
    //     ArrayList<TurretPrototype> turretPrototypes,
    //     TowerPrototype towerPrototype,
    //     int expRequiredToUpgrade
    // ) {
    //     this.backgroundImage = new ImageData(relPathToBgImage).getSprite();
    //     this.characterPrototypes = characterPrototypes;
    //     this.turretPrototypes = turretPrototypes;
    //     this.expRequiredToUpgrade = expRequiredToUpgrade;
    // }

    protected AgeData() { }

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
}
