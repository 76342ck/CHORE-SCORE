import javax.swing.*;import javax.swing.JFrame;import javax.swing.JLabel;
import java.awt.*;import java.awt.BorderLayout;

/**
 * Created by Lia on 12/7/2015.
 */
public class ChoreHistoryWindow extends JFrame {

    private JLabel messageLabel;
    final int WINDOW_WIDTH = 400;
    final int WINDOW_HEIGHT = 550;

    public ChoreHistoryWindow() {
        setTitle("Chore History");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messageLabel = new JLabel("Below are the chores completed, as well as the date and user that completed the chore.");

        add(messageLabel, BorderLayout.NORTH);

        setVisible(true);
    }
}
