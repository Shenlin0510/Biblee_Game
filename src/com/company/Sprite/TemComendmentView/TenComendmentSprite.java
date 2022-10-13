package com.company.Sprite.TemComendmentView;

import com.company.Sprite.Sprite;

import javax.swing.*;

public class TenComendmentSprite extends Sprite {

    public TenComendmentSprite(int x , int y){
        setPosition(x,y);
        img = new ImageIcon("stone.png");
    }

    @Override
    public String overlap(int x, int y) {
        return null;
    }
}
