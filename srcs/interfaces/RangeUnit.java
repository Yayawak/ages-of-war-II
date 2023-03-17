package srcs.Interfaces;

import javax.swing.text.html.HTMLDocument.RunElement;

import srcs.GameUI.mainGame.SubScene.GameObject.GameObject;

public interface RangeUnit {
    public void fireBulletToOpponent(
        GameObject sender, // sender must have Bullet Image
        GameObject reciever
    );

}
