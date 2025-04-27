import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class TimeSpillGui {
    private static int clicks = 0;
    private static Instant startTime;
    private static int maxClicks = 10;

    private static void reset() {
        clicks = 0;
    }
    private static void startTime() {
        startTime = Instant.now();
    }
    private static Float stopTime() {
        Long millis = Duration.between(startTime, Instant.now()).toMillis();
        return millis.floatValue() / 1000;
    }
    private static int incrementClicks() {
        return ++clicks;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }
        JFrame vindu = new JFrame("Time spill");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setSize(400, 400);

        JPanel infoPanel = new JPanel();
        JButton startButton = new JButton("Start");

        infoPanel.add(startButton);

        vindu.add(infoPanel, BorderLayout.NORTH);

        JPanel gamePanel = new JPanel();
        vindu.add(gamePanel);

        JButton clickButton = new JButton("Trykk");
        clickButton.setVisible(false);
        
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickButton.setVisible(true);
                setRandomPosition(clickButton, gamePanel.getHeight(), gamePanel.getWidth());
                // ^ dene sliter litt ja
                startTime();
            }
        });

        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incrementClicks();
                
                if (clicks == maxClicks) {
                    Float timeUsed = stopTime();
                    JOptionPane.showMessageDialog(vindu, "Du brukte " + timeUsed + " sekunder på å trykke på " + maxClicks + " knapper");
                    clickButton.setVisible(false);
                    reset();
                }
                setRandomPosition(clickButton, gamePanel.getHeight(), gamePanel.getWidth());
            }
        });
        
        gamePanel.add(clickButton);
        
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);

    }
    public static void setRandomPosition(JButton button, int height, int width) {
        Random r = new Random();

        int r1 = r.nextInt(height - button.getHeight());
        int r2 = r.nextInt(width - button.getWidth());

        button.setBounds(r1, r2, button.getWidth(), button.getHeight());

    }
}
