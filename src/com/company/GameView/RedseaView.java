package com.company.GameView;

import com.company.Sprite.Door;
import com.company.Sprite.redseaView.Anubis;
import com.company.Sprite.redseaView.Cat;
import com.company.Sprite.redseaView.Pharoah;

import javax.swing.*;
import java.util.ArrayList;

public class RedseaView extends GameView{


    private ArrayList<Anubis> anubis = new ArrayList<>();
   private ArrayList<Cat> cats = new ArrayList<>();
   private ArrayList<Pharoah> pharoahs = new ArrayList<>();

    public ArrayList<Anubis> getAnubis() {
        return anubis;
    }

    public ArrayList<Cat> getCat(){
        return cats;
    }

    public ArrayList<Pharoah> getPharoahs(){
        return pharoahs;
    }

    public RedseaView(){
        img=new ImageIcon("sea.jpg");
        elements = new ArrayList<>();
        door=new Door(10,10);


        cats.add(new Cat(6, 3));
        cats.add(new Cat(6, 4));
        cats.add(new Cat(6, 5));
        cats.add(new Cat(8, 3));
        cats.add(new Cat(1, 3));
        cats.add(new Cat(6, 9));
        cats.add(new Cat(2, 7));
        cats.add(new Cat(2, 5));

        pharoahs.add(new Pharoah(5, 4));
        pharoahs.add(new Pharoah(6, 1));
        pharoahs.add(new Pharoah(5, 1));
        pharoahs.add(new Pharoah(4, 1));
        pharoahs.add(new Pharoah(3, 1));
        pharoahs.add(new Pharoah(1, 4));

        anubis.add(new Anubis(2, 6));
        anubis.add(new Anubis(7, 6));
        anubis.add(new Anubis(7, 7));
        anubis.add(new Anubis(7, 8));
        anubis.add(new Anubis(10, 1));

        elements.add(door);
        elements.addAll(anubis);
        elements.addAll(pharoahs);
        elements.addAll(cats);
    }
}
