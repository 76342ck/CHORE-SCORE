import javax.swing.*;
import java.awt.*;

/**
 * Created by Lia on 12/13/2015.
 */
public class MenuGreetingPanel extends JPanel {
 private JLabel greeting;
    public MenuGreetingPanel() {
        greeting = new JLabel("Welcome to CHORESCORE!");
        greeting.setFont(new Font("Serif", Font.PLAIN, 35));

        add(greeting);
    }
}
