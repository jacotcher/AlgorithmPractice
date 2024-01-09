package Shared;

public class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistanceFromOrigin() {
        return Math.sqrt((Math.pow(this.x, 2)) + (Math.pow(this.y, 2)));
    }
}