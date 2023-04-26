package srcs.GameUI.mainGame.SubScene.GameObject.Effects;

import helpers.SpritesInstallator;
import srcs.Enums.TeamType;
import srcs.GameUI.mainGame.SubScene.GameObject.Character.CharacterGObject;

public class HealingDrone extends AbstractEffect {
    int healAmountPerTick = 30;
    int totalHealAmount = 150;
    public HealingDrone(TeamType team, int healAmountPerTick) {
        this(team);
        this.healAmountPerTick = healAmountPerTick;
    }
    public HealingDrone(TeamType team) {
        setTeamType(team);
        // setImg(img);
        effectFrames = SpritesInstallator.getSpritesInFolder(
            "characters/cyberAge/howell/flying medkit"
        );
        // setPos(pos);
        this.initAnimation();
    }


    protected void initAnimation() {
        new Thread(() -> {
            long animationSpeed = 200;
            int i = 0;
            while (!isEffectDied) {
                CharacterGObject ally = findClosestAlly();
                if (ally != null) {
                    setPos(ally.getPos());
                    ally.getCharacter().increaseHp(healAmountPerTick);
                    totalHealAmount -= healAmountPerTick;
                }
                try { Thread.sleep(animationSpeed); } catch (Exception e) { }
                if (i < effectFrames.size()) {
                    setImg(effectFrames.get(i));
                } else {
                    i = 0;
                    continue;
                }
                if (totalHealAmount <= 0 || ally == null) {
                    destroyGameObject();
                }
                i++;
                // System.out.println("blood splash");
            }
        }).start();
    }
}
