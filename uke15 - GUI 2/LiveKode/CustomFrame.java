import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.GridLayout;

class CustomFrame extends JFrame {
    int rows;
    int cols;
    JPanel mainPanel;
    CustomButton[][] buttons;

    public CustomFrame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        buttons = new CustomButton[rows][cols];
        mainPanel = new JPanel(new GridLayout(rows, cols));

        setupFrame();
    }

    public String checkWin() {
        for (int row = 0; row < rows; row++) {
            String[] rowList = {
                buttons[row][0].getText(),
                buttons[row][1].getText(),
                buttons[row][2].getText()
            };
            String[] colList = {
                buttons[0][row].getText(),
                buttons[1][row].getText(),
                buttons[2][row].getText()
            };

            if (rowList[0].equals(" ")) return null;
            if (colList[0].equals(" ")) return null;

            if (rowList[0].equals(rowList[1]) && rowList[0].equals(rowList[2])) {
                return rowList[0];
            }
            if (colList[0].equals(colList[1]) && colList[0].equals(colList[2])) {
                return colList[0];
            }
        }
        return null;
    }
    private void addButtons() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                CustomButton button = new CustomButton(" ", this);
                buttons[i][j] = button;
                mainPanel.add(button);
            }
        }
    }
    private void setupFrame() {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName()
            );
        } catch (Exception e ) {
            System.err.println(e);
        }
        addButtons();
        add(mainPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}