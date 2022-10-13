package com.company.GameView;

import com.company.Sprite.TemComendmentView.TenComendmentSprite;

import javax.swing.*;
import java.util.ArrayList;

public class TenComendmentView extends GameView{

    private ArrayList<TenComendmentSprite> stones = new ArrayList<>();
    private int count ;
    public TenComendmentView(){
        count=0;
        elements =new ArrayList<>();
        img=new ImageIcon("mountain.jpg");

        stones.add(new TenComendmentSprite(3,4));
        stones.add(new TenComendmentSprite(6,6));
        stones.add(new TenComendmentSprite(8,6));
        stones.add(new TenComendmentSprite(3,9));
        stones.add(new TenComendmentSprite(7,7));
        stones.add(new TenComendmentSprite(9,10));
        stones.add(new TenComendmentSprite(2,8));
        stones.add(new TenComendmentSprite(5,1));
        stones.add(new TenComendmentSprite(3,4));
        stones.add(new TenComendmentSprite(7,4));
        elements.addAll(stones);


    }
    public ArrayList<TenComendmentSprite> getStone(){
        return stones;

    }
    public int getCount(){
        return count;
    }
    public void setCount(int count ){
        this.count+=count;
    }


}
