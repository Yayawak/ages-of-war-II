package srcs.Interfaces;

import srcs.UI.mainGame.SubScene.GameObject.GameObject;

public interface RangeUnit {
    public void fireBulletToOpponent(
        GameObject sender, // sender must have Bullet Image
        GameObject reciever
    );
}
