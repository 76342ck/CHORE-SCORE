public class User {

   private String userName;
   private Integer points = 0;
   
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

   public void addPoints(Integer chorePoints) {
        points += chorePoints;
    }

   public Integer getPoints() {
      return points;
   }
   public String toString() {
      return userName + "\n";
   }

}      
  