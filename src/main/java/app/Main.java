package app;

import javax.swing.JFrame;

import view.GraphPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Trend Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        frame.add(new GraphPanel());
        frame.setVisible(true);
    }
}
