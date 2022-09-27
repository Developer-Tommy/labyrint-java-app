package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Buttons extends JPanel{

    public Buttons(Board b, JLabel text, Player p, Labyrinth l) {
        this.setLayout(new GridLayout(0,3));
        JButton up = new JButton("UP");
        JButton down = new JButton("DOWN");
        JButton left = new JButton("LEFT");
        JButton right = new JButton("RIGHT");
        JButton startNewGame = new JButton("AGAIN");
        this.add(text);
        this.add(up);
        this.add(startNewGame);
        this.add(left);
        this.add(down);
        this.add(right);
        new ButtonListener(up, down, left, right, startNewGame, b, p, l);
    }


}
