import javax.swing.*;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JPanel;
import java.awt.*;
import java.awt.BorderLayout;import java.awt.event.*;
import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.lang.Override;import java.util.ArrayList;
import java.util.List;


public class ChoreListWindow extends JFrame {

    private JLabel messageLabel;
    private JPanel panel;
    private JButton completeButton;
    final int WINDOW_WIDTH = 200;
    final int WINDOW_HEIGHT = 550;

    public ChoreListWindow() {
        setTitle("Chore List");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messageLabel = new JLabel("List of Available Chores");

        add(messageLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    public void drawChoreList(List<Chore> chores, User user) {
        panel = new JPanel();
        ArrayList<ChoreCheckBox> checkBoxes = new ArrayList<>();

        for (Chore chore : chores) {
            JPanel chorePanel = new JPanel();
            ChoreCheckBox choreCheckBox = new ChoreCheckBox(chore);
            checkBoxes.add(choreCheckBox);
            chorePanel.add(choreCheckBox);
            panel.add(chorePanel, BorderLayout.CENTER);
        }
        add(panel);
        completeButton = new JButton("Complete");
        add(completeButton, BorderLayout.SOUTH);
        completeButton.addActionListener(new CompleteButtonListener(checkBoxes, user));
        validate();

    }

    private class CompleteButtonListener implements ActionListener {
        private User user;
        private ArrayList<ChoreCheckBox> checkBoxes = new ArrayList<>();


        public CompleteButtonListener(ArrayList<ChoreCheckBox> checkBoxes, User user) {
            this.checkBoxes = checkBoxes;
            this.user = user;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (ChoreCheckBox checkBox : checkBoxes) {
                checkBox.getChore();
                if (checkBox.isSelected()) {
                    user.addPoints(checkBox.getChore().getPoints());
                    checkBox.getChore().setComplete();
                }
            }
            //TODO: Exit on close when Complete is clicked.
        }
    }
}