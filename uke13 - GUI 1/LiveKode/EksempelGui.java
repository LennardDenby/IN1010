import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.Random;
import java.time.*;

class EksempelGui {
    private static int antTrykk = 0;
    private static int maksTrykk = 10;
    private static Instant startTid;

    private static void setTilfeldigPosisjon(JButton button) {
        Random r = new Random();

        int x = r.nextInt(400 - button.getWidth());
        int y = r.nextInt(400 - button.getHeight() - 20);

        button.setBounds(x, y, button.getWidth(), button.getHeight());
    }

    private static void trykk() {
        ++antTrykk;
    }
    private static void startTiden() {
        startTid = Instant.now();
    }
    private static Double stopTid() {
        Long millis = Duration.between(startTid, Instant.now()).toMillis();
        return millis.doubleValue() / 1000;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        JFrame vindu = new JFrame("Hei");
        vindu.setSize(400, 400);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel startPanel = new JPanel();
        JPanel gamePanel = new JPanel();

        JButton startButton = new JButton("Start");
        JButton gameButton = new JButton("Trykk");
        gameButton.setVisible(false);

        startPanel.add(startButton);
        gamePanel.add(gameButton);

        vindu.add(startPanel, BorderLayout.NORTH);
        vindu.add(gamePanel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameButton.setVisible(true);
                startTiden();
            }
        });

        gameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trykk();

                if (antTrykk == maksTrykk) {
                    Double tidBrukt = stopTid();
                    JOptionPane.showMessageDialog(vindu, "Du trykket " + maksTrykk + " ganger og brukte " + tidBrukt + " sekunder");
                    vindu.dispose();
                }
                setTilfeldigPosisjon(gameButton);
            }
        });
        
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }
}