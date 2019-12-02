import java.awt.*;

public class Triangle {
    public static Polygon t;
    public static R2Point p1, p2, p3;
    public static Vector v1, v2, v3;
    public static int pairs = 0;
    private static int count = 0;
    public Triangle(){ }
    public void add() throws Exception {
        switch (count)
        {
            case 0:
                p1 = new R2Point();
                count++;
                break;
            case 1:
                p2 = new R2Point();
                count++;
                break;
            case 2:
                p3 = new R2Point();
                count++;
                t = new Polygon(p1, p2, p3);
                v1 = new Vector(p1, p2);
                v2 = new Vector(p2, p3);
                v3 = new Vector(p3, p1);
                break;
            default:
                System.out.println("Triangle already set");
                break;
        }
    }
    public Triangle(R2Point a, R2Point b, R2Point c)
    {
        t = new Polygon(a, b, c);
        v1 = new Vector(a, b);
        v2 = new Vector(b, c);
        v3 = new Vector(c, a);
    }
    public void draw(Graphics g)
    {
        if (t != null) {
            t.draw(g);
        }
    }
}