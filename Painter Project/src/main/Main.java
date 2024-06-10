package main;
//import swing
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame window = new JFrame();

        //When the user clicks the ("X") button it closes the window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setResizable(true);
        window.setTitle("Slumber:ZZZ");

        GamePanel gamePanel = new GamePanel();
        //add it to the content pane
        window.add(gamePanel);
        window.pack();

        gamePanel.startThread();

        //Make window in the middle of the screen
        window.setLocationRelativeTo(null);

        //Lets us see the screen
        window.setVisible(true);
    }
}
