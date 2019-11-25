import java.awt.*;

public class Point implements Figure
{
    private R2Point p;
    public Point(R2Point p)
    {
        this.p = p;
    }
    public double perimeter()
    {
        return 0.0;
    }
    public double area()
    {
        return 0.0;
    }
    public Figure add(R2Point q)
    {
        if (!R2Point.equal(p,q)) return new Segment(p, q);
        else return this;
    }
    public void draw(Graphics2D g)
    {
        g.drawOval(p.getX(), p.getY(), 1,1);
    }
    public int pair(Triangle t)
    {
        return 0;
    }
    public int newPair(Triangle t)
    {
        return 0;
    }
}
