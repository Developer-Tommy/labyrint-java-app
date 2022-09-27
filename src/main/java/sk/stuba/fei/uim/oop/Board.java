package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    private final JFrame frame;
    private Labyrinth lab;
    private Player player;
    private Buttons buttons;
    private JLabel text;
    private int wins;
    private final Timer t;

    public Board(JFrame frame, JLabel label){
        t = new Timer(25, this);
        this.frame = frame;
        this.lab = new Labyrinth(15,15);
        this.player = new Player();
        this.text = label;
        this.wins = 0;
        this.text.setText("Wins: "+this.wins);
        this.buttons = new Buttons(this, text, player, lab);
        this.frame.add(buttons, BorderLayout.NORTH);

        addKeyListener(new Move(player, lab));
        addMouseListener(new Mouse(player));
        addMouseMotionListener(new Mouse(player));
        setFocusable(true);
        t.start();
    }

    public void actionPerformed(ActionEvent e) {
        if (player.getPosX() == 13 && player.getPosY() == 13){
            System.out.println("Winner");
            player.setPosX(1);
            player.setPosY(1);
            startAgain(false);
        }

        repaint();

    }

    public void paint(Graphics g){
        super.paint(g);

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 15; j++){
                if (lab.getMaze(i, j) == 0){
                    g.setColor(Color.WHITE);
                    g.fillRect(i * 32, j * 32, 31, 31);
                }
                if (lab.getMaze(i, j) == 1){
                    g.setColor(Color.BLACK);
                    g.fillRect(i * 32, j * 32, 32, 32);
                }
                if (lab.getMaze(i, j) == 2){
                    g.setColor(Color.RED);
                    g.fillOval(i * 32, j * 32, 32, 32);
                }
            }
        }

        if (player.getMouseOnPlayer()) {
            g.setColor(Color.ORANGE);
            drawPath(g);

        }

        if (player.isClicked()){
            g.setColor(Color.ORANGE);
            drawPath(g);

            if (player.getPosSquareX() != 0 && player.getPosSquareY() != 0) {
                g.setColor(Color.MAGENTA);
                g.fillOval(player.getPosSquareX() * 32 + 9, player.getPosSquareY() * 32 + 9, 14, 14);
            }
        }

        g.setColor(Color.GREEN);
        g.fillOval(player.getPosX() * 32, player.getPosY() * 32, 32, 32);

    }

    public void startAgain(boolean reset){
        this.lab = new Labyrinth(15,15);
        this.player = new Player();
        this.wins++;

        if (reset){
            wins = 0;
        }

        this.text = new JLabel();
        this.frame.remove(buttons);
        this.buttons = new Buttons(this, text, player, lab);
        this.frame.add(buttons, BorderLayout.NORTH);
        this.text.setText("Wins: "+this.wins);
        addKeyListener(new Move(player, lab));
        addMouseListener(new Mouse(player));
        addMouseMotionListener(new Mouse(player));
        setFocusable(true);
        t.start();
    }

    public void drawPath(Graphics g){

        int status1, status2, status3, status4;
        int pos1, pos2, pos3, pos4;
        int[][] path = new int[2][50];
        int i = 0;
        int j = 0;

        status1 = lab.getMaze(player.getPosX(),(player.getPosY() + 1));
        status2 = lab.getMaze(player.getPosX(),(player.getPosY() - 1));
        status3 = lab.getMaze((player.getPosX() + 1),player.getPosY());
        status4 = lab.getMaze((player.getPosX() - 1),player.getPosY());

        pos1 = player.getPosY() + 1;
        pos2 = player.getPosY() - 1;
        pos3 = player.getPosX() + 1;
        pos4 = player.getPosX() - 1;

        while (status1 != 1){

            g.fillRect(player.getPosX() * 32 + 9, pos1 * 32 + 9, 14,14);
            path[i][j] = player.getPosX();
            i++;
            path[i][j] = pos1;
            j++;

            pos1++;
            status1 = lab.getMaze(player.getPosX(),pos1);
            i = 0;

        }

        while (status2 != 1){
            g.fillRect(player.getPosX() * 32 + 9, pos2 * 32 + 9, 14,14);
            path[i][j] = player.getPosX();
            i++;
            path[i][j] = pos2;
            j++;

            pos2--;
            status2 = lab.getMaze(player.getPosX(),pos2);
            i = 0;

        }

        while (status3 != 1){

            g.fillRect(pos3 * 32 + 9, player.getPosY() * 32 + 9, 14,14);
            path[i][j] = pos3;
            i++;
            path[i][j] = player.getPosY();
            j++;

            pos3++;
            status3 = lab.getMaze(pos3, player.getPosY());
            i = 0;

        }

        while (status4 != 1){
            g.fillRect(pos4 * 32 + 9, player.getPosY() * 32 + 9, 14,14);
            path[i][j] = pos4;
            i++;
            path[i][j] = player.getPosY();
            j++;

            pos4--;
            status4 = lab.getMaze(pos4, player.getPosY());
            i = 0;
        }

        player.setReachable(path);

    }

}
