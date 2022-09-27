package sk.stuba.fei.uim.oop;

import java.awt.event.*;

public class Move extends KeyAdapter {

    private final Player p;
    private final Labyrinth l;

    public Move(Player p, Labyrinth l){
        this.p = p;
        this.l = l;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP){
            if ((l.getMaze(p.getPosX(), (p.getPosY()-1))) != 1) {
                p.movePlayer(0, -1);
            }
        }
        else if (key == KeyEvent.VK_DOWN){
            if ((l.getMaze(p.getPosX(), (p.getPosY()+1))) != 1) {
                p.movePlayer(0, 1);
            }
        }
        else if (key == KeyEvent.VK_LEFT){
            if ((l.getMaze((p.getPosX()-1), p.getPosY())) != 1) {
                p.movePlayer(-1, 0);
            }
        }
        else if (key == KeyEvent.VK_RIGHT){
            if ((l.getMaze((p.getPosX()+1), p.getPosY())) != 1) {
                p.movePlayer(1, 0);
            }
        }

        p.setPosSquareX(0);
        p.setPosSquareY(0);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
