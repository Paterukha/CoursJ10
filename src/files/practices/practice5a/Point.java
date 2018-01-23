package files.practices.practice5a;

public class Point {
    public static final Point ZERO = new Point(0,0);
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }

    public double calcLength(Point otherPoint) {

        return Math.sqrt(Math.pow((x - otherPoint.x), 2) + Math.pow((y - otherPoint.y), 2));
    }


    public double calcLength() {
      return calcLength(ZERO);

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Point normalize(){
        return new Point(x/calcLength(),y/calcLength());
    }
}
