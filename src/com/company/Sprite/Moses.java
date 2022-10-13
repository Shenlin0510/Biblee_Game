package com.company.Sprite;

import com.company.GameView.DisasterView;
import com.company.GameView.RedseaView;
import com.company.GameView.TenComendmentView;
import com.company.Main;
import com.company.Sprite.TemComendmentView.TenComendmentSprite;
import com.company.Sprite.disasterView.Bug;
import com.company.Sprite.disasterView.Frog;
import com.company.Sprite.disasterView.Ice;
import com.company.Sprite.disasterView.TombStone;
import com.company.Sprite.redseaView.Anubis;
import com.company.Sprite.redseaView.Cat;
import com.company.Sprite.redseaView.Pharoah;

import javax.swing.*;
import java.util.ArrayList;

public class Moses extends Sprite {

    public Moses (int x, int y){
        setPosition(x,y);
        img = new ImageIcon("Moses.png");
    }

    @Override
    public String overlap(int x, int y) {
        if (Main.gameView instanceof DisasterView){

            ArrayList<Frog> frogs = ((DisasterView) Main.gameView).getFrogs();
            ArrayList<Bug> bugs = ((DisasterView) Main.gameView).getBugs();
            for (Frog f : frogs){
                if(f.getRelativePosition()!=null && x == f.relativePosition.x && y == f.relativePosition.y){
                    return "Die";
                }
            }
            for (Bug b : bugs){
                if(b.getRelativePosition()!=null && x == b.relativePosition.x && y == b.relativePosition.y){
                    return "Die";
                }
            }

            ArrayList<Ice> ices = ((DisasterView) Main.gameView).getIceCubes();
            ArrayList<TombStone> stones = ((DisasterView) Main.gameView).getStones();
            for (Ice i : ices){
                if(i.getRelativePosition()!=null && x == i.relativePosition.x && y == i.relativePosition.y){
                    return "Cannot Move";
                }
            }
            for (TombStone t : stones){
                if(t.getRelativePosition()!=null && x == t.relativePosition.x && y == t.relativePosition.y){
                    return "Cannot Move";
                }
            }
            //check door
            Door door = Main.gameView.getDoor();
            if(x==door.getRelativePosition().x && y==door.getRelativePosition().y){
                return "Next level";
            }

        } else if (Main.gameView instanceof RedseaView) {
            ArrayList<Anubis> anubis = ((RedseaView) Main.gameView).getAnubis();
            ArrayList<Pharoah> pharoahs = ((RedseaView) Main.gameView).getPharoahs();
            for (Anubis a : anubis){
                if(a.getRelativePosition()!=null && x == a.relativePosition.x && y == a.relativePosition.y){
                    return "Die";
                }
            }
            for (Pharoah p : pharoahs){
                if(p.getRelativePosition()!=null && x == p.relativePosition.x && y == p.relativePosition.y){
                    return "Die";
                }
            }
            ArrayList<Cat> cats = ((RedseaView) Main.gameView).getCat();
            for (Cat c : cats){
                if(c.getRelativePosition()!=null && x == c.relativePosition.x && y == c.relativePosition.y){
                    return "Cannot Move";
                }
            }
            Door door = Main.gameView.getDoor();
            if(x==door.getRelativePosition().x && y==door.getRelativePosition().y){
                return "Next level";
            }

        } else if (Main.gameView instanceof TenComendmentView){
            ArrayList<TenComendmentSprite> stones =((TenComendmentView) Main.gameView).getStone();
            for(TenComendmentSprite stone : stones){
                if(stone.getRelativePosition()!=null && stone.getRelativePosition().x==x && stone.getRelativePosition().y==y){
                    stone.setNullPosition();
                    ((TenComendmentView) Main.gameView).setCount(1);
                    if(((TenComendmentView) Main.gameView).getCount()==10){
                        return "Game over";
                    }else {
                        return "none";
                    }
                }
            }
        }
        return "none";
    }
}
