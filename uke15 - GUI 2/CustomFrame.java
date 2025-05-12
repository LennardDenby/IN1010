import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CustomFrame extends JFrame {
    JPanel mainPanel;
    int rows;
    int cols;

    public CustomFrame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        setupFrame();
    }

    private void addButtons() {
        for (int i = 0; i < rows * cols; i++) {
            CustomButton button = new CustomButton("Knapp " + i);
            mainPanel.add(button);
        }
    }
    private void setupFrame() {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainPanel = new JPanel(new GridLayout(rows, cols));
        addButtons();
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
