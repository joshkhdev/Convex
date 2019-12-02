import javax.swing.*;
import java.awt.*;

public class Window extends JFrame
{
    private Triangle t;
    private Convex c;
    public Window()
    {
        setSize(1280, 720);
        setVisible(true);
        setTitle("Empty");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public Window(Triangle t, Convex c)
    {
        setSize(1280, 720);
        setVisible(true);
        setTitle("Figures");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.t = t;
        this.c = c;
    }
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.blue);
        t.draw(g);
        g.setColor(Color.black);
        c.draw(g);
    }
    public void paint()
    {
        paint(getGraphics());
    }
}