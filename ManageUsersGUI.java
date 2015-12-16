import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JCheckBox;

public class ManageUsersGUI extends JFrame {
    public ArrayList<User> users = new ArrayList<>();

    private JLabel addNewUserLabel;
    private JTextField addNewUserTextField;
    private JLabel deleteUsersLabel;
    private JButton addButton;
    private JButton deleteButton;
    private JPanel namePanel;
    final int WINDOW_WIDTH = 650;
    final int WINDOW_HEIGHT = 500;
    

    public ManageUsersGUI() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //construct components
        addNewUserLabel = new JLabel ("Add new User here:");
        addNewUserTextField = new JTextField (0);
        deleteUsersLabel = new JLabel ("Select which User(s) you would like to delete:");
        addButton = new JButton ("Add");
        deleteButton = new JButton ("Delete");
        namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));

        //set components properties
        addNewUserTextField.setToolTipText ("Enter name and click on Add button.");
        addButton.setToolTipText ("Click here to Add new user.");
        deleteButton.setToolTipText ("Click here to delete User(s) selected.");

        //adjust size and set layout
        setPreferredSize (new Dimension (580, 485));
        setLayout (null);

        //add components
        add (addNewUserLabel);
        add (addNewUserTextField);
        add (deleteUsersLabel);
        add (namePanel);
        add (addButton);
        add (deleteButton);

        //set component bounds (only needed by Absolute Positioning)
        addNewUserLabel.setBounds (85, 130, 120, 25);
        addNewUserTextField.setBounds (235, 130, 125, 25);
        deleteUsersLabel.setBounds (135, 225, 281, 25);
        addButton.setBounds (385, 130, 100, 25);
        namePanel.setBounds(225, 270, 140, 0);
        deleteButton.setBounds (230, 335, 100, 25);

        addButton.addActionListener(new AddButtonListener());
        
        deleteButton.addActionListener(new DeleteButtonListener());

        setVisible(true);
    }
           
       
    private class AddButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text = addNewUserTextField.getText();
            ChoreScoreData.getUserList().add(new User(text));

            // Display the changes.
            JOptionPane.showMessageDialog(null, text + " has been added.");
            
            JCheckBox nameCheckBox = new JCheckBox();
            nameCheckBox.setText(addNewUserTextField.getText());
            namePanel.add(nameCheckBox);
            namePanel.setBounds(225, 270, 140, namePanel.getHeight() + 25);
            deleteButton.setBounds(230, deleteButton.getY() + 25, 100, 25);
            JFrame frame = (JFrame) getRootPane().getParent();
            frame.setSize(frame.getWidth(), frame.getHeight() + 25);
            frame.pack(); 
        }
    }
    
    private class DeleteButtonListener implements ActionListener {
         @Override
         public void actionPerformed(ActionEvent e) {
            for(Component component : namePanel.getComponents()) {
               if(component instanceof JCheckBox) {
                  if(((JCheckBox)component).isSelected())
                     namePanel.remove(component);
               }
            }
            namePanel.revalidate();
            namePanel.repaint();
         }   
    }
                

    public static void main (String[] args) {
        JFrame frame = new JFrame ("AddUsersPanel1");
        frame.setTitle("Manage Users");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ManageUsersGUI());
        frame.pack();
        frame.setVisible (true);
    }
}
