/**
 * Created by Lia on 11/21/2015.
 */
import java.lang.String;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.*;

public class ChoreScore {

    private static ArrayList<Chore> chores = new ArrayList<>();

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

    public static void main(String[] args) {
        User lia = new User("Lia");
        Chore chore1 = new Chore("Wash dishes", Frequency.DAILY, 30);
        Chore chore2 = new Chore("Sweep staircase", Frequency.WEEKLY, 10);
        Chore chore3 = new Chore("Scrub kitchen floor", Frequency.MONTHLY, 90);
        Chore chore4 = new Chore("Clean downstairs toilet", Frequency.MONTHLY, 30);
        Chore chore5 = new Chore("Change Dorian's litter", Frequency.WEEKLY, 20);
        Chore chore6 = new Chore("Change Lucy's litter", Frequency.WEEKLY, 20);
        Chore chore7 = new Chore("Change guinea pig's litter", Frequency.WEEKLY, 30);

        chores.add(chore1);
        chores.add(chore2);
        chores.add(chore3);
        chores.add(chore4);
        chores.add(chore5);
        chores.add(chore6);
        chores.add(chore7);

        ArrayList<Chore> availableChores = new ArrayList<>();
        for (Chore chore : chores) {
            if (isChoreComplete(chore) == false) {
                availableChores.add(chore);
            }
        }

        ChoreListWindow choreListWindow = new ChoreListWindow();
        choreListWindow.drawChoreList(availableChores, lia);
    }
}
