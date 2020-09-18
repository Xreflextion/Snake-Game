package java_snake_game;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Gameplay game_play = new Gameplay();
        frame.setLocation(0,0);
        frame.setSize(615, 640);
        // frame.setBounds(0, 0, 600, 600);
        frame.setTitle("Snake");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game_play);
        frame.setVisible(true);
    }
}
