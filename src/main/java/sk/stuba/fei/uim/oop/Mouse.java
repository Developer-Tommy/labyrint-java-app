package sk.stuba.fei.uim.oop;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

    private final Player p;
    private boolean isOnPlayer;
    private int[][] path;

    public Mouse(Player player) {
        this.p = player;
        this.isOnPlayer = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        mouseAction(e);
        p.setClicked(isOnPlayer);

        int x = e.getX();
        int y = e.getY();

        try {

            this.path = p.getReachable();

            for (int j = 0; j < 50; j++){
                if (path[0][j] != 0 && path[1][j] != 0){
                    if ((path[0][j] * 32 <= x && (path[0][j] + 1) * 32 >= x) && (path[1][j] * 32 <= y && (path[1][j] + 1) * 32 >= y)){
                        p.setPosX(path[0][j]);
                        p.setPosY(path[1][j]);
                    }

                    else{
                        p.setPosX(p.getPosX());
                        p.setPosY(p.getPosY());
                    }
                }
            }
        }

        catch (NullPointerException n){
            n.getMessage();
        }

        e.consume();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseAction(e);
        p.isMouseOnPlayer(isOnPlayer);

        int x = e.getX();
        int y = e.getY();

        try {

            if (p.isClicked()) {
                this.path = p.getReachable();

                for (int j = 0; j < 50; j++) {
                    if (path[0][j] != 0 && path[1][j] != 0) {
                        if ((path[0][j] * 32 <= x && (path[0][j] + 1) * 32 >= x) && (path[1][j] * 32 <= y && (path[1][j] + 1) * 32 >= y)) {
                            p.setPosSquareX(path[0][j]);
                            p.setPosSquareY(path[1][j]);
                        }

                    }
                }
            }
        }

        catch (NullPointerException n){
            n.getMessage();
        }

        e.consume();
    }

    public void mouseAction(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if ((p.getPosX() * 32 <= x && (p.getPosX() + 1) * 32 >= x) && (p.getPosY() * 32 <= y && (p.getPosY() + 1) * 32 >= y)){
            isOnPlayer = true;
        }
        else
            isOnPlayer = false;
    }
}
