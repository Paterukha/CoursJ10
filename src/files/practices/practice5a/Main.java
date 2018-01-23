package files.practices.practice5a;

public class Main {
    public static void main(String[] args) {

        Point p1= new Point(2.0,0.0);
        Point p2 = new Point(5,6);

        p1.calcLength();
        System.out.println( p1.calcLength());
        System.out.println(p1.normalize());
    }
}
