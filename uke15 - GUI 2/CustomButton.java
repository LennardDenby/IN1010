import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CustomButton extends JButton {
    boolean clickState = false;
    String value;

    public CustomButton(String s) {
        value = s;
        setText(s);
        addActionListener(new CustomActionListener());
    }

    private void onClick() {
        if (clickState) {
            setText(value);
        } else {
            setText("Trykk!!");
        }
        clickState = !clickState;
    }
    
    private class CustomActionListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                onClick();
            }
    }
}
