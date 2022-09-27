package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private final Board newBoard;
    private final Player p;
    private final Labyrinth l;

    public ButtonListener(JButton up, JButton down, JButton left, JButton right, JButton startNewGame, Board board, Player player, Labyrinth labyrinth) {
        this.newBoard = board;
        this.p = player;
        this.l = labyrinth;

        up.setFocusable(false);
        down.setFocusable(false);
        left.setFocusable(false);
        right.setFocusable(false);
        startNewGame.setFocusable(false);

        up.addActionListener(this);
        left.addActionListener(this);
        down.addActionListener(this);
        right.addActionListener(this);
        startNewGame.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("UP")){
            if ((l.getMaze(p.getPosX(), (p.getPosY()-1))) != 1){
                p.movePlayer(0, -1);
            }
        }

        if (action.equals("DOWN")){
            if ((l.getMaze(p.getPosX(), (p.getPosY()+1))) != 1){
                p.movePlayer(0, 1);
            }
        }

        if (action.equals("LEFT")){
            if ((l.getMaze((p.getPosX()-1), p.getPosY())) != 1) {
                p.movePlayer(-1, 0);
            }
        }

        if (action.equals("RIGHT")){
            if ((l.getMaze((p.getPosX()+1), p.getPosY())) != 1) {
                p.movePlayer(1, 0);
            }
        }

        if (action.equals("AGAIN")){
            newBoard.startAgain(true);
        }

        p.setPosSquareX(0);
        p.setPosSquareY(0);

    }
}
