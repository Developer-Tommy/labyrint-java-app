package sk.stuba.fei.uim.oop;

public class Player {

    private int posX, posY;
    private boolean status;
    private boolean clicked;
    private int posSquareX;
    private int posSquareY;
    private int[][] reachable;

    public Player(){
        this.posX = 1;
        this.posY = 1;
        this.status = false;
        this.clicked = false;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setClicked(boolean clicked) { this.clicked = clicked; }

    public boolean isClicked() {
        return clicked;
    }

    public void isMouseOnPlayer(boolean status){
        this.status = status;
    }

    public boolean getMouseOnPlayer(){
        return status;
    }

    public void setReachable(int[][] reachable) {
        this.reachable = reachable;
    }

    public int[][] getReachable() {
        return reachable;
    }

    public void setPosSquareX(int posSquareX) {
        this.posSquareX = posSquareX;
    }

    public void setPosSquareY(int posSquareY) {
        this.posSquareY = posSquareY;
    }

    public int getPosSquareX() {
        return posSquareX;
    }

    public int getPosSquareY() {
        return posSquareY;
    }

    public void movePlayer(int x, int y){
        this.posX += x;
        this.posY += y;
    }

}
