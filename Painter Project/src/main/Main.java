package main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Slumber:ZZZ");

        View view = new View();
        window.add(view);
        window.pack();

        view.startThread();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
