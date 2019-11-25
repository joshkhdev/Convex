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
                grow(x, front(), t);
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
        for (int i=0; i < length(); i++)
        {
            g.drawLine(front().getX(), front().getY(), back().getX(), back().getY());
            pushBack(popFront());
        }
    }
    public int pair(Triangle t)
    {
        int n = 0;
        Vector v1 = new Vector();
        Vector v[] = new Vector[] { t.v1, t.v2, t.v3 };
        for (int i = 0; i < length(); i++)
        {
            v1.change(front(), back());
            for (int j = 0; j < 3; j++) {
                if ((Vector.cos(v1, v[j]) > 0.9999) || (Vector.cos(v1, v[j]) < -0.9999)) {
                    n++;
                }
            }
            pushBack(popFront());
        }
        return n;
    }
    public int newPair(Triangle t)
    {
        return Triangle.pairs;
    }
}
