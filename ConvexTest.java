import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ConvexTest
{
    public static void main(String[] args) throws Exception
    {
        int k = 0;
        Convex convex = new Convex();
        ArrayList<R2Point> a = new ArrayList<R2Point>();
        while (k < 3)
        {
            try
            {
                System.out.println("Triangle: Enter point №" + (k+1) + ": ");
                a.add(new R2Point());
                k++;
            }
            catch (Exception ex)
            {
                break;
            }
        }
        Triangle triangle = new Triangle(a.get(0), a.get(1), a.get(2));
        while (true)
        {
            try
            {
                System.out.println("Convex: Enter a point: ");
                convex.add(new R2Point());
            }
            catch (Exception ex)
            {
                break;
            }
            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter() + ", Pairs = " + triangle.pair(convex));
        }
        Window window = new Window(triangle, convex);
    }
}