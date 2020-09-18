package java_snake_game;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

public class Snake {
    protected int length = 5;
    protected int x;
    protected int y;
    protected int[] dir = {0, 0};
    protected boolean add = false;
    protected ArrayList<ArrayList<Integer>> coor = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> c;

    public void draw(Graphics g, int size) {
        g.setColor(Color.white);
        for (int i = 0; i < coor.size(); i++) {
            x = coor.get(i).get(0)*size;
            y = coor.get(i).get(1)*size;
            g.fillRect(x, y, size, size);
            // System.out.println(x);
        }
    }

    public void create(int y) {
        for (int i=5; i > 0; i--) {
            c = new ArrayList<Integer>();
            c.add(i);
            c.add(y);
            coor.add(c);
        }
    }

    public void move() {
        switch (dir[0]) {
            case 1:
                c = new ArrayList<Integer>(coor.get(0));
                c.set(0, c.get(0)+dir[1]);
                coor.add(0, c);
                // System.out.println(c);
                if (!add) {
                    coor.remove(coor.size()-1);
                } else {
                    add = false;
                }
                break;
            case 2:
                c = new ArrayList<Integer>(coor.get(0));
                c.set(1, c.get(1)+dir[1]);
                coor.add(0, c);
                // System.out.println(c);
                if (!add) {
                    coor.remove(coor.size()-1);
                } else {
                    add = false;
                }
                break;
        }
    }

    public void change_dir(int dir1, int dir2) {
        dir[0] = dir1;
        dir[1] = dir2;
    }

}
