package files.practices.practice5;

public class Point {
    public float x, y;


    public Point(float x, float y) {
        this.x = x;
        this.y = y;

    }


    public double calcLength(Point otherPoint) {
        System.out.println("x=" + x);
        System.out.println("y=" + y);

        System.out.println("otherPoint.x=" + otherPoint.x);
        System.out.println("otherPoint.y=" + otherPoint.y);


        return Math.sqrt(Math.pow((x - otherPoint.x), 2) + Math.pow((y - otherPoint.y), 2));

    }

}