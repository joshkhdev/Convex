import java.awt.*;
import java.util.ArrayList;
public class ConvexTest
{
    public static void main(String[] args) throws Exception
    {
        int k = 0;
        Convex convex = new Convex();
        Triangle triangle = new Triangle();
        Window window = new Window(triangle, convex);
        while (k < 3)
        {
            try
            {
                System.out.println("Triangle: Enter point №" + (k+1) + ": ");
                triangle.add();
                k++;
                window.paint();
            }
            catch (Exception ex)
            {
                System.out.println(ex);
                break;
            }
        }
        while (true)
        {
            try
            {
                System.out.println("Convex: Enter a point: ");
                convex.add(new R2Point());
                window.paint();
            }
            catch (Exception ex)
            {
                break;
            }
            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter() + ", NewPairs = " + convex.newPair(triangle));
        }
    }
}