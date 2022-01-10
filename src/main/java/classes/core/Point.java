package classes.core;

public class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void move(int x, int y){
        this.x += x;
        this.y += y;
    }
}
