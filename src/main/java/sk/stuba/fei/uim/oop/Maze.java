package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Maze {

    private JFrame frame;
    private JLabel label;
    private Board panelMaze;

    public Maze(){
        frame = new JFrame("Maze Game");
        frame.setLayout(new BorderLayout());
        label = new JLabel();
        panelMaze = new Board(frame, label);
        frame.add(panelMaze, BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(480,590));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
