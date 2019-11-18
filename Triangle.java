import java.awt.*;

public class Triangle {
    private Polygon t;
    public Triangle(R2Point a, R2Point b, R2Point c)
    {
        t = new Polygon(a, b, c);
    }
    public int pair(Convex c)
    {
        try {
            System.out.println("Pair Polygon");
            return t.pair((Polygon)c.fig());
        }
        catch (Exception ex) {
            try {
                System.out.println("Pair Segment");
                return t.pair((Segment)c.fig());
            }
            catch (Exception ex1)
            {
                try {
                    System.out.println("Pair Point");
                    return t.pair((Point)c.fig());
                }
                catch (Exception ex2)
                {
                    try {
                        System.out.println("Pair Void");
                        return t.pair((Void)c.fig());
                    }
                    catch (Exception ex3) {
                        System.out.println("Pair Figure");
                        return t.pair(c.fig());
                    }
                }
            }
        }
    }
    public void draw(Graphics2D g)
    {
        t.draw(g);
    }
}
