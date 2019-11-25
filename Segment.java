import javax.swing.table.TableRowSorter;
import java.awt.*;

public class Segment implements Figure
{
    private R2Point p, q;
    public Segment(R2Point p, R2Point q)
    {
        this.p = p; this.q = q;
    }
    public double perimeter()
    {
        return 2.0 * R2Point.dist(p, q);
    }
    public double area()
    {
        return 0.0;
    }
    public Figure add(R2Point r)
    {
        if (R2Point.isTriangle(p, q, r)) {
            return new Polygon(p, q, r);
        }
        if (q.inside(p, r)) q = r;
        if (p.inside(r, q)) p = r;
        return this;
    }
    public void draw(Graphics2D g)
    {
        g.drawLine(p.getX(), p.getY(), q.getX(), q.getY());
    }
    public int pair(Triangle t)
    {
        int n = 0;
        Vector v1 = new Vector(p, q);
        Vector v[] = new Vector[] { t.v1, t.v2, t.v3 };
        for (int i = 0; i < 3; i++)
        {
            if ((Vector.cos(v1, v[i]) > 0.9999) || (Vector.cos(v1, v[i]) < -0.9999)) {
                n++;
            }
        }
        return n;
    }
    public int newPair(Triangle t)
    {
        return Triangle.pairs;
    }
}
