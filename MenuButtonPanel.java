import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lia on 12/13/2015.
 */
public class MenuButtonPanel extends JPanel {
    private JButton manageUsersButton;
    private JButton manageChoresButton;
    private JButton choreListButton;

    public MenuButtonPanel() {
        manageUsersButton = new JButton("Manage Users");
        manageUsersButton.addActionListener(new manageUsersButtonListener());

        manageChoresButton = new JButton("Manage Chores");
        manageChoresButton.addActionListener(new manageChoresButtonListener());

        choreListButton = new JButton("View Available Chores");
        choreListButton.addActionListener(new choreListButtonListener());

        add(manageUsersButton);
        add(manageChoresButton);
        add(choreListButton);
    }
    private class manageUsersButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ManageUsersGUI manageUsers = new ManageUsersGUI();
        }
    }
    private class manageChoresButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AddDelete manageChores = new AddDelete();
        }
    }
    private class choreListButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            ChoreListWindow choreListWindow = new ChoreListWindow();
//            choreListWindow.drawChoreList();
        }
    }
}
