import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CustomButton extends JButton {
    String value;
    CustomFrame frame;
    static String player = "o";

    public CustomButton(String v, CustomFrame cf) {
        frame = cf;
        value = v;
        setText(value);
        addActionListener(new CustomActionListener());
    }

    public void onClick() {
        setText(player);
        setEnabled(false);

        if (player.equals("o")) {
            player = "x";
        } else {
            player = "o";
        }

        String winner = frame.checkWin();
        if (winner != null) {
            JOptionPane.showMessageDialog(frame, winner + " vant runden");
            frame.dispose();
        }
    }

    private class CustomActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            onClick();
        }
    }
}
