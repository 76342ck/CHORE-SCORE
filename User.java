public class User {

   private String userName;
   private int points = 0;
   
   public User(String userName) {
      this.userName = userName;
   }
   
   public User() {
      userName = "";
   }   
   
   public void setUserName(String userName) {
      this.userName = userName;   
   }
   
   public String getUserName() {
      return userName;
   }

    public void addPoints(int chorePoints) {
        points += chorePoints;
    }
   public String toString() {
      return userName + "\n";
   }

}      
  