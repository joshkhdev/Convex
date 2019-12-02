import java.awt.*;

public class Convex
{
    private Figure fig;
    public Convex()
    {
        fig = new Void();
    }
    public void add(R2Point p)
    {
        fig = fig.add(p);
    }
    public double area()
    {
        return fig.area();
    }
    public double perimeter()
    {
        return fig.perimeter();
    }
    public void draw(Graphics g)
    {
        fig.draw(g);
    }
    public Figure fig()
    {
        return fig;
    }
    public int newPair(Triangle t)
    {
        return fig.newPair(t);
    }
}