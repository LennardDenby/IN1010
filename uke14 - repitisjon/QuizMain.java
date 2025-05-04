import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

class QuizMain {
    static SporsmalManager spmManager = new SporsmalManager("spm.txt");


    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            System.exit(1);
        }
        JFrame vindu = new JFrame("Quiz spill");
        vindu.setSize(400, 300);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel spmPanel = new JPanel();
        JPanel svarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 50));

        JLabel spmLabel = new JLabel(spmManager.hentSpm());

        JButton jaButton = new JButton("Ja");
        JButton neiButton = new JButton("Nei");

        neiButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if(spmManager.hentSvar()) {
                    flyttKnappTilfeldig(neiButton, svarPanel.getWidth(), svarPanel.getHeight());
                }
            }
        });

        jaButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                if(!spmManager.hentSvar()) {
                    flyttKnappTilfeldig(jaButton, svarPanel.getWidth(), svarPanel.getHeight());
                }
            }
        });

        ActionListener knappTrykket = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sporsmal nesteSpm = spmManager.next();
                if (nesteSpm == null) {
                    JOptionPane.showMessageDialog(vindu, "Wow!!! Du klarte å svare riktig på alle spørsmål!");
                    vindu.dispose();
                } else {
                    spmLabel.setText(spmManager.hentSpm());
                }
            }
        };

        jaButton.addActionListener(knappTrykket);
        neiButton.addActionListener(knappTrykket);

        spmPanel.add(spmLabel);

        svarPanel.add(jaButton);
        svarPanel.add(neiButton);

        vindu.add(spmPanel, BorderLayout.NORTH);
        vindu.add(svarPanel);
       
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }
    static void flyttKnappTilfeldig(JButton button, int maksX, int maksY) {
        Random random = new Random();

        int xPos = random.nextInt(maksX - button.getWidth());
        int yPos = random.nextInt(maksY - button.getHeight());

        button.setBounds(xPos, yPos, button.getWidth(), button.getHeight());
    }
}