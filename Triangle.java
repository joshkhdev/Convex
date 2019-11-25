import java.awt.*;

public class Triangle {
    public static Polygon t;
    public static Vector v1, v2, v3;
    public static int pairs = 0;
    public Triangle(R2Point a, R2Point b, R2Point c)
    {
        t = new Polygon(a, b, c);
        v1 = new Vector(a, b);
        v2 = new Vector(b, c);
        v3 = new Vector(c, a);
    }
    public void draw(Graphics2D g)
    {
        t.draw(g);
    }
}