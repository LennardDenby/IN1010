import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class HeiMain {
    static ArrayList<Sporsmal> spmListe = new ArrayList<>();
    static int naverendeSpm = 0;
    static int antRiktig = 0;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        lesFraFil("spm.txt");

        JFrame vindu = new JFrame("Hei vindu");
        vindu.setLayout(new GridLayout(2, 1));

        JPanel spmPanel = new JPanel();

        Sporsmal forsteSpm = spmListe.get(naverendeSpm);
        JLabel spmLabel = new JLabel(forsteSpm.spm);

        JPanel svarPanel = new JPanel(new GridLayout(1, 2));

        JButton jaButton = new JButton("Ja");
        JButton neiButton = new JButton("Nei");

        class KnappListener implements ActionListener {
            String verdi;
            public KnappListener(String verdi) {
                this.verdi = verdi;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verdi.equals(spmListe.get(naverendeSpm).riktigSvar)) {
                    antRiktig++;
                }
                naverendeSpm++;
                if (naverendeSpm == spmListe.size() - 1) {
                    JOptionPane.showMessageDialog(vindu, "Du fikk " + antRiktig + "/" + spmListe.size() + " riktige!");
                    vindu.dispose();
                }

                spmLabel.setText(spmListe.get(naverendeSpm).spm);
            }
        }

        jaButton.addActionListener(new KnappListener("Ja"));
        neiButton.addActionListener(new KnappListener("Nei"));

        spmPanel.add(spmLabel);

        svarPanel.add(jaButton);
        svarPanel.add(neiButton);

        vindu.add(spmPanel);
        vindu.add(svarPanel);

        vindu.pack();
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLocationRelativeTo(null);
        vindu.setVisible(true);
    }

    static void lesFraFil(String filnavn) {
        try {
            Scanner scanner = new Scanner(new File(filnavn));
            while (scanner.hasNextLine()) {
                String linje = scanner.nextLine();
                String[] data = linje.split(",");

                String spm = data[0];
                String svar = data[1];

                Sporsmal spmOb = new Sporsmal(spm, svar);
                spmListe.add(spmOb);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println(e);
        }


    }
}