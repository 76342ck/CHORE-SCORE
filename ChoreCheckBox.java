import javax.swing.*;import javax.swing.JCheckBox;

/**
 * Created by Lia on 11/27/2015.
 */
public class ChoreCheckBox extends JCheckBox {
    private Chore chore;
    public ChoreCheckBox(Chore chore) {
        super(chore.getName());
        this.chore = chore;
    }
    public Chore getChore() {
        return chore;
    }
}
