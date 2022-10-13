package com.company;

import com.company.GameView.DisasterView;
import com.company.GameView.GameView;
import com.company.GameView.RedseaView;
import com.company.GameView.TenComendmentView;
import com.company.Sprite.Moses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel implements KeyListener {

    public static final int CELL = 50; //每一格人物佔據50cm
    public static final int Width = 500;
    public static final int Height = 500;
    public static final int Row = Width/CELL;
    public static final int Column = Height/CELL;
    private int level ;

    Moses moses;
    public static GameView gameView;

    public Main(){
        level =1;
        resetGame(new DisasterView());
        addKeyListener(this);

    }

    public void resetGame(GameView game){
        moses =new Moses(1,1);
        gameView =game;
        repaint();
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(Width,Height);
    }
    @Override
    public void paintComponent(Graphics g){
        gameView.drawView(g);
        moses.draw(g);
        requestFocusInWindow();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Biblee Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(new Main());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);

    }

    public boolean ChangeLevel(String result) {
        if (result.equals("Next level")) {
            level++;
            if (level == 2) {
                resetGame(new RedseaView());
            }else if(level == 3){
                resetGame(new TenComendmentView());
            }
            return true;
        }
        return false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Point MosesPoint = moses.getRelativePosition();
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP :
                if (MosesPoint.y>1){
                    String result = moses.overlap(MosesPoint.x,MosesPoint.y-1);
                if(result.equals("Die")){
                    //reset Game
                    JOptionPane.showMessageDialog(this,"You Die ,The Game will be restart.");
                    resetGame(new DisasterView());
                    return;
                }
                if(!result.equals("Cannot Move")){
                    MosesPoint.y-=1;
                }
                if(result.equals("Game over")){
                    JOptionPane.showMessageDialog(this,"Game Over You win !!");
                }
                if(ChangeLevel(result)){
                    return;
                }

                }
                break;
            case KeyEvent.VK_DOWN:
                if(MosesPoint.y<10){
                    String result = moses.overlap(MosesPoint.x,MosesPoint.y+1);
                    if(result.equals("Die")){
                        //reset Game
                        level=1;
                        JOptionPane.showMessageDialog(this,"You Die ,The Game will be restart.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot Move")){
                        MosesPoint.y+=1;
                    }
                    if(result.equals("Game over")){
                        JOptionPane.showMessageDialog(this,"Game Over You win !!");
                        return;
                    }
                    if(ChangeLevel(result)){
                        return;
                    }
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(MosesPoint.x<10){
                    String result = moses.overlap(MosesPoint.x+1,MosesPoint.y);
                    if(result.equals("Die")){
                        //reset Game
                        level=1;
                        JOptionPane.showMessageDialog(this,"You Die ,The Game will be restart.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot Move")){
                        MosesPoint.x+=1;
                    }
                    if(result.equals("Game over")){
                        JOptionPane.showMessageDialog(this,"Game Over You win !!");
                        return;
                    }
                    if(ChangeLevel(result)){
                        return;
                    }
                }
                break;
            case KeyEvent.VK_LEFT:
                if(MosesPoint.x>1){
                    String result = moses.overlap(MosesPoint.x-1,MosesPoint.y);
                    if(result.equals("Die")){
                        //reset Game
                        level=1;
                        JOptionPane.showMessageDialog(this,"You Die ,The Game will be restart.");
                        resetGame(new DisasterView());
                        return;
                    }
                    if(!result.equals("Cannot Move")){
                        MosesPoint.x-=1;
                    }
                    if(result.equals("Game over")){
                        JOptionPane.showMessageDialog(this,"Game Over You win !!");
                        return;
                    }
                    if(ChangeLevel(result)){
                        return;
                    }
                }
                break;
        }
        moses.setPosition(MosesPoint);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
