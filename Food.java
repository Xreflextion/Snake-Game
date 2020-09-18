package java_snake_game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Food {
    protected int x;
    protected int y;
    protected int[] coor = {0,0};

    public void draw(Graphics g, int size) {
        g.setColor(Color.red);
        x = coor[0]*size;
        y = coor[1]*size;
        g.fillRect(x, y, size, size);
    }

    public void set_var() {
        coor[0] = (int) (Math.random() * 40 );
        coor[1] = (int) (Math.random() * 40);
        // System.out.println(coor[0]);
        // System.out.println(coor[1]);
    }

    public boolean if_intersect(Rectangle a, int size) {
        x = coor[0]*size;
        y = coor[1]*size;
        Rectangle f = new Rectangle(x, y, size, size);
        if (a.intersects(f)) {
            return false;
        }
        return true;
    }
}
