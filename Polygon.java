import java.awt.*;

public class Polygon extends Deq implements Figure
{
    private double s, p;
    private void grow(R2Point a, R2Point b, R2Point t)
    {
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }
    public Polygon(R2Point a, R2Point b, R2Point c)
    {
        pushFront(b);
        if (b.light(a, c))
        {
            pushFront(a); pushBack(c);
        }
        else
        {
            pushFront(c); pushBack(a);
        }
        p = R2Point.dist(a, b) + R2Point.dist(b, c) + R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }
    public double perimeter()
    {
        return p;
    }
    public double area()
    {
        return s;
    }
    public Figure add(R2Point t)
    {
        int i;
        // Ищем освещенные ребра, просматривая их одно за другим.
        for (i=length(); i>0 && !t.light(back(),front()); i--)
            pushBack(popFront());
        // УТВЕРЖДЕНИЕ: либо ребро [back(),front()] освещено из t,
        // либо освещенных ребер нет совсем.
        if (i>0)
        {
            R2Point x;
            grow(back(), front(), t);
        // Удаляем все освещенные ребра из начала дека.
            for (x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t );
            pushFront(x);
        // Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);
// Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }
        return this;
    }
    public void draw(Graphics2D g)
    {
        R2Point first, second;
        for (int i=0; i < length(); i++)
        {
            first = popFront();
            second = popFront();
            g.drawLine(first.getX(), first.getY(), second.getX(), second.getY());
            pushBack(first);
            pushFront(second);
        }
    }
    public int pair(Figure f)
    {
        return 0;
    }
    public int pair(Void v)
    {
        return 0;
    }
    public int pair(Point p)
    {
        return 0;
    }
    public int pair(Segment s)
    {
        int n = 0;
        final Vector v1 = new Vector(s.first(), s.second());
        Vector v2 = new Vector();
        R2Point first, second;
        for (int i = 0; i < length(); i++)
        {
            first = popFront();
            second = popFront();
            v2.change(first, second);
            if ((Vector.cos(v1, v2) > 0.9999) || (Vector.cos(v1, v2) < -0.9999))
                n++;
            pushBack(first);
            pushFront(second);
        }
        return n;
    }
    public int pair(Polygon p)
    {
        int n = 0;
        Vector v1 = new Vector();
        Vector v2 = new Vector();
        R2Point first, second;
        R2Point Pfirst, Psecond;
        for (int i = 0; i < p.length(); i++)
        {
            Pfirst = p.popFront();
            Psecond = p.popFront();
            v1.change(Pfirst, Psecond);
            for (int j = 0; j < length(); j++)
            {
                first = popFront();
                second = popFront();
                v2.change(first, second);
                if ((Vector.cos(v1, v2) > 0.9999) || (Vector.cos(v1, v2) < -0.9999))
                    n++;
                pushBack(first);
                pushFront(second);
            }
            p.pushBack(Pfirst);
            p.pushFront(Psecond);
        }
        return n;
    }
}
