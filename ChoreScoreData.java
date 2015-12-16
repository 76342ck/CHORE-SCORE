import java.io.*;
import java.util.ArrayList;

/**
 * Created by Lia on 12/13/2015.
 */
public class ChoreScoreData {

    public static final String SAVE_FILE_PATH = "C:\\Users\\Lia\\Dropbox\\ChoreScore\\";

    private static ArrayList<User> userList = new ArrayList<User>();
    private static ArrayList<Chore> choreList = new ArrayList<Chore>();

    public static void writeChoreData() throws FileNotFoundException {
        try {
            FileWriter choreWriter = new FileWriter(SAVE_FILE_PATH+"Chores.txt", false);
            BufferedWriter writeFile = new BufferedWriter(choreWriter);
            for (int i = 0; i < choreList.size(); i++) {
                writeFile.write(choreList.get(i).getName());
                writeFile.write("|");

                writeFile.write(choreList.get(i).getFrequency().toString());
                writeFile.write("|");

                writeFile.write(choreList.get(i).getPoints().toString());
                writeFile.write("|");

                if (choreList.get(i).getLastCompleted() == null) {
                    writeFile.write("");
                }
                else {
                    writeFile.write(choreList.get(i).getLastCompleted().toString());
                }
                writeFile.newLine();
            }
            writeFile.close();
            choreWriter.close();
        }
        catch (IOException e) {}
    }
    public static void writeUserData() throws FileNotFoundException {
        try {
            FileWriter userWriter = new FileWriter(SAVE_FILE_PATH+"Users.txt", false);
            BufferedWriter writeFile = new BufferedWriter(userWriter);
            for (int i = 0; i < userList.size(); i++) {
                writeFile.write(userList.get(i).getUserName());
                writeFile.write("|");

                writeFile.write(userList.get(i).getPoints().toString());
                writeFile.newLine();
            }
            writeFile.close();
            userWriter.close();
        }
        catch (IOException e) {}
    }

    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static void setUserList(ArrayList<User> userList) {
        ChoreScoreData.userList = userList;
    }

    public static ArrayList<Chore> getChoreList() {
        return choreList;
    }

    public static void setChoreList(ArrayList<Chore> choreList) {
        ChoreScoreData.choreList = choreList;
    }
}
