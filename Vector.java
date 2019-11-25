public class Vector
{
    private double x, y;
    public Vector()
    {
        x = 0; y = 0;
    }
    public Vector(R2Point p0, R2Point p1)
    {
        x = p1.getX() - p0.getX();
        y = p1.getY() - p0.getY();
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public void change(R2Point p0, R2Point p1)
    {
        x = p1.getX() - p0.getX();
        y = p1.getY() - p0.getY();
    }
    public double length()
    {
        return Math.sqrt(x*x + y*y);
    }
    public static double cos(Vector v1, Vector v2)
    {
        return ((v1.getX()*v2.getX() + v1.getY()*v2.getY()) / (v1.length()*v2.length()));
    }
}
