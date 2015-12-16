import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by Lia on 12/13/2015.
 */
public class MenuWindow extends JFrame {
    private MenuGreetingPanel banner;
    private MenuButtonPanel manageButtons;
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 400;


    public MenuWindow() {
        setTitle("Menu");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new ExitListener());

        setLayout(new GridLayout(3, 1));

        banner = new MenuGreetingPanel();

        manageButtons = new MenuButtonPanel();

        JPanel panel1 = new JPanel();
        panel1.add(banner);

        JPanel panel2 = new JPanel();
        panel2.add(manageButtons);

        JPanel panel3 = new JPanel();
//        panel3.add();

        add(panel1);
        add(panel2);
        add(panel3);

        setVisible(true);
    }

    public class ExitListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
            try {
                ChoreScoreData.writeUserData();
                ChoreScoreData.writeChoreData();
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }

        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }

    public static void main(String[] args) {
        String line;
        try {
            BufferedReader userReader = new BufferedReader(new FileReader(ChoreScoreData.SAVE_FILE_PATH + "Users.txt"));
            while ((line = userReader.readLine()) != null) {
                String[] splitUser = line.split("\\|");
                User user = new User();
                user.setUserName(splitUser [0]);
                user.addPoints(Integer.parseInt(splitUser[1]));
                ChoreScoreData.getUserList().add(user);
            }
            BufferedReader choreReader = new BufferedReader(new FileReader(ChoreScoreData.SAVE_FILE_PATH + "Chores.txt"));
            while ((line = choreReader.readLine()) != null) {
                String [] splitChore = line.split("\\|");
                Chore chore = new Chore(splitChore [0], Frequency.valueOf(splitChore [1]), Integer.parseInt(splitChore [2]));
                if (splitChore.length == 4) {
                    chore.setLastCompleted(LocalDateTime.parse(splitChore[3]));
                }
                ChoreScoreData.getChoreList().add(chore);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        MenuWindow menuWindow = new MenuWindow();
    }
}

