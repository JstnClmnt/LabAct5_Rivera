package Model;

import Controller.*;
import Helper.Read;
import java.io.Serializable;
import java.util.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class Person implements Serializable{
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";
    private String firstName;
    private String lastName;
    private String userType;
    private String userName;
    private String password;
    private String status;
    private ArrayList<Task> tasks;

    public Person(String firstName, String lastName, String userType, String userName, String password, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public Person() {
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getLastName() {
        return lastName;
    }

     public void setUserName(String userName) {
        this.userName = userName;
    }
     
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    public String getPassword() {
        return password;
    }
    
    public void setUserType(String userType){
        this.userType = userType;
    }
    
    public String getUserType(){
        return userType;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return status;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    } 
    
    public ArrayList<Task> getTasks() {
        /**try {
            this.setTasks(new ArrayList<Task>());
            
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            
            String create = "SELECT * FROM TaskTooDoo WHERE Username=?";
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1, this.getUserName());
            
            ResultSet rs = createStm.executeQuery();
            Task task;
            
            while(rs.next()){
                task = new Task(rs.getString("Task"));
                this.tasks.add(task);
            }
            this.setTasks(tasks);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tasks;**/
        //return new Read().readTask(this);
        return tasks;
    }


}
