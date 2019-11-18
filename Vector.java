public class Vector
{
    private R2Point p;
    public Vector()
    {
        p = new R2Point(0,0);
    }
    public Vector(R2Point p0, R2Point p1)
    {
        p = new R2Point((p1.getX() - p0.getX()),(p1.getY() - p0.getY()));
    }
    public R2Point getPoint()
    {
        return p;
    }
    public void change(R2Point p0, R2Point p1)
    {
        p.setPoint(p1.getX() - p0.getX(), p1.getY() - p0.getY());
    }
    public double lenght()
    {
        return Math.sqrt(p.getX()*p.getX() + p.getY()*p.getY());
    }
    public static double cos(Vector v1, Vector v2)
    {
        return ((v1.getPoint().getX()*v2.getPoint().getX() + v1.getPoint().getY()*v2.getPoint().getY()) / (v1.lenght()*v2.lenght()));
    }
}
