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
   
   @Override 
   public boolean equals(Object obj) { 
      if (this == obj) return true; 
      if (obj == null) return false; 
      if (getClass() != obj.getClass()) return false; 
      User other = (User) obj; 
      if (userName == null) { 
         if (other.userName != null) return false; 
      } else if (!userName.equals(other.userName)) return false; 
         return true; 
   }
   

}      
  
