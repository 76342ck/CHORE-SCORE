import javax.swing.*;import javax.swing.JButton;import javax.swing.JFrame;import javax.swing.JLabel;import javax.swing.JPanel;
import java.awt.*;
import java.awt.BorderLayout;import java.awt.event.*;
import java.awt.event.ActionEvent;import java.awt.event.ActionListener;import java.lang.Override;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChoreListWindow extends JFrame {

    private JLabel messageLabel;
    private JPanel panel;
    private JButton completeButton;
    final int WINDOW_WIDTH = 400;
    final int WINDOW_HEIGHT = 550;

    public ChoreListWindow() {
        setTitle("Chore List");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        messageLabel = new JLabel("List of Available Chores");
        messageLabel.setFont(new Font("Serif", Font.PLAIN, 28));

        add(messageLabel, BorderLayout.NORTH);

        ArrayList<Chore> availableChores = new ArrayList<>();
        for (Chore chore : ChoreScoreData.getChoreList()) {
            if (isChoreComplete(chore) == false) {
                availableChores.add(chore);
            }
        }
        drawChoreList(availableChores);

        setVisible(true);
    }

    public void drawChoreList(List<Chore> chores) {
        JLabel userMessage;
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        add(panel);

        String [] users = new String[ChoreScoreData.getUserList().size()];
        for (int x = 0; x < ChoreScoreData.getUserList().size(); x++) {
            users[x] = ChoreScoreData.getUserList().get(x).getUserName();
        }
        JComboBox userList = new JComboBox(users);
        JPanel userListPanel = new JPanel();
        userMessage = new JLabel("Which user completed the chore/s?");
        userMessage.setFont(new Font("Serif", Font.PLAIN, 15));
        userListPanel.add(userMessage);
        userListPanel.add(userList);
        userListPanel.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));

        panel.add(Box.createVerticalGlue());
        panel.add(userListPanel);
        panel.add(Box.createVerticalGlue());


        ArrayList<ChoreCheckBox> checkBoxes = new ArrayList<>();
        for (Chore chore : chores) {
            ChoreCheckBox choreCheckBox = new ChoreCheckBox(chore);
            checkBoxes.add(choreCheckBox);
            panel.add(choreCheckBox);
        }

        Dimension minSize = new Dimension(5, 10);
        Dimension prefSize = new Dimension(5, 50);
        Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);
        panel.add(new Box.Filler(minSize, prefSize,maxSize));

        completeButton = new JButton("Complete Chore");
        add(completeButton, BorderLayout.SOUTH);
        completeButton.addActionListener(new CompleteButtonListener(checkBoxes));

        validate();
    }

    private class CompleteButtonListener implements ActionListener {
        private ArrayList<ChoreCheckBox> checkBoxes = new ArrayList<>();


        public CompleteButtonListener(ArrayList<ChoreCheckBox> checkBoxes) {
            this.checkBoxes = checkBoxes;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            for (ChoreCheckBox checkBox : checkBoxes) {
                checkBox.getChore();
                if (checkBox.isSelected()) {
                    //user.addPoints(checkBox.getChore().getPoints());
                    checkBox.getChore().setComplete();
                }
            }
            dispose();
        }
    }
    public static boolean isChoreComplete(Chore chore) {
        if (chore.getLastCompleted() == null)
            return false;

        LocalDateTime cutOff = null;
        if (chore.getFrequency() == Frequency.DAILY) {
            cutOff = LocalDateTime.now().minusDays(1);
        }
        else if(chore.getFrequency() == Frequency.WEEKLY) {
            cutOff = LocalDateTime.now().minusWeeks(1);
        }
        else if (chore.getFrequency() == Frequency.MONTHLY) {
            cutOff = LocalDateTime.now().minusMonths(1);
        }

        return chore.getLastCompleted().isAfter(cutOff);
    }

}