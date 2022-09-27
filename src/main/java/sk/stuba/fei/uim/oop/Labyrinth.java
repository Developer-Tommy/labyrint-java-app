package sk.stuba.fei.uim.oop;

import java.util.Random;

public class Labyrinth {

    private int[][] labyrinth;
    private final int width;
    private final int height;
    private final Random rand;

    public Labyrinth (int width, int height) {
        this.width = width;
        this.height = height;
        rand = new Random();
        labyrinth = generateMaze();
    }

    public int[][] generateMaze() {
        labyrinth = new int[width][height];
        int w,h;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                labyrinth[i][j] = 1;
            }
        }

        w = width - 2;
        h = height - 2;

        backtrackMaze(labyrinth,1,1, w, h);

        labyrinth[width - 2][height - 2] = 2;

        return labyrinth;
    }


    public void backtrackMaze(int[][] labyrinth, int row, int col, int w, int h) {
        labyrinth[row][col] = 0;

        if ((row > w) || (row < 1) || (col > h) || (col < 1)) {
            return;
        }

        switch (rand.nextInt(4)) {
            case 0:
                if(unvisitedNeighbour(labyrinth, row, col, w, h)) {
                    if(col + 2 > h) {
                    } else if(labyrinth[row][col + 2] != 0){
                        labyrinth[row][col + 1] = 0;
                        backtrackMaze(labyrinth, row, col + 2, w, h);
                    }
                    backtrackMaze(labyrinth, row, col, w, h);
                }
                break;
            case 1:
                if(unvisitedNeighbour(labyrinth, row, col, w, h)) {
                    if(col - 2 < 0) {
                    } else if(labyrinth[row][col - 2] != 0){
                        labyrinth[row][col - 1] = 0;
                        backtrackMaze(labyrinth, row, col - 2, w, h);
                    }
                    backtrackMaze(labyrinth, row, col, w, h);
                }
                break;
            case 2:
                if(unvisitedNeighbour(labyrinth, row, col, w, h)) {
                    if(row + 2 > w) {
                    }else if(labyrinth[row + 2][col] != 0){
                        labyrinth[row + 1][col] = 0;
                        backtrackMaze(labyrinth, row + 2, col, w, h);
                    }
                    backtrackMaze(labyrinth, row, col, w, h);
                }
                break;

            case 3:
                if(unvisitedNeighbour(labyrinth, row, col, w, h)) {
                    if(row - 2 < 0) {
                    } else if(labyrinth[row - 2][col] != 0) {
                        labyrinth[row - 1][col] = 0;
                        backtrackMaze(labyrinth, row - 2, col, w, h);
                    }
                    backtrackMaze(labyrinth, row, col, w, h);
                }
                break;
        }
    }

    public boolean unvisitedNeighbour(int[][] labyrinth, int row, int col, int w, int h) {
        if (row + 2 > w) {
        } else if (labyrinth[row + 2][col] == 1) {
            return true;
        }
        if (row - 2 < 0) {
        } else if (labyrinth[row - 2][col] == 1) {
            return true;
        }
        if (col + 2 > h) {
        } else if (labyrinth[row][col + 2] == 1) {
            return true;
        }
        if (col - 2 < 0) {
        } else if (labyrinth[row][col - 2] == 1) {
            return true;
        }
        return false;
    }

    public int getMaze(int x, int y){
        return labyrinth[x][y];
    }
}
