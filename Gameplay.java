package java_snake_game;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import java.util.ArrayList;
import java.util.Collections;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    final int width = 600;
    final int height = 600;

    private Timer timer;
    private int delay = 8;
    private int num = 0;

    private boolean end = false;
    private boolean running = false;
    private int score;

    private int size = 15;
    private boolean is_food;
    private ArrayList<Integer> front;

    private Snake snake = new Snake();
    private Food food = new Food();
    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        snake.create(30);
        snake.change_dir(1, 1);
        food.set_var();
        is_food = true;

        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0,width, height);

        snake.draw(g, size);

        food.draw(g, size);

        g.setColor(Color.white);
        g.setFont(new Font("Dialog", Font.PLAIN, 20));
        g.drawString("Score: "+score, 500, 30 );

        if (!running && end) {
            g.setColor(Color.red);
            g.setFont(new Font("Dialog", Font.BOLD, 30));
            g.drawString("GAME OVER, Score: "+score, 160, 200 );

            g.setFont(new Font("Dialog", Font.BOLD, 25));
            g.drawString("Press Enter to Restart", 200, 250 );
        }

        g.dispose();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (running && !end) {
            if (num == 10) {
                snake.move();
                num = 0;
            }
            if (!is_food) {
                snake.add = true;
                score += 1;
                food.set_var();
                is_food = true;
            }
            num++;
            front = new ArrayList<Integer>(snake.coor.get(0));

            Rectangle s = new Rectangle(front.get(0)*size, front.get(1)*size, size, size);
            is_food = food.if_intersect(s, size);

            if (front.get(0)*size >= width || front.get(0) < 0 || front.get(1)*size >= height || front.get(1) < 0) {
                running = false;
                end = true;
            }
            if (Collections.frequency(snake.coor, new ArrayList<Integer>(snake.coor.get(0)) ) > 1) {
                running = false;
                end = true;
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!end) {
            running = true;
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (snake.dir[0] == 2) {
                    snake.change_dir(1, 1);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (snake.dir[0] == 2) {
                    snake.change_dir(1, -1);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (snake.dir[0] == 1) {
                    snake.change_dir(2, 1);
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (snake.dir[0] == 1) {
                    snake.change_dir(2, -1);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER && !running && end) {
            score = 0;
            end = false;
            running = true;
            num = 0;

            snake = new Snake();
            snake.create(30);
            snake.change_dir(1, 1);
            food.set_var();
            is_food = true;

            timer.start();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
