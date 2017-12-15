package Helper;


import Model.Person;
import Model.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Read {
    public static String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";
    public ArrayList<Task> tasks=new ArrayList<Task>();
    public ArrayList<Person> users=new ArrayList<Person>();
    public ArrayList<Person> readUsers(){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            Statement readStm = connect.createStatement();
            String read = "SELECT * FROM UsersTooDoo WHERE UserType='User'";
            ResultSet rs = readStm.executeQuery(read);
            
            while(rs.next()){
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String UserType=rs.getString("UserType");
                String Username = rs.getString("Username");
                String Password=rs.getString("Password");
                String Status = rs.getString("Status");
                Person user = new Person(FirstName,LastName, UserType, Username, Password, Status);
                users.add(user);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public Person readUser(String username){
        Person user=new Person();
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String read = "SELECT * FROM UsersTooDoo WHERE Username=?";
            PreparedStatement readStm = connect.prepareStatement(read);
            readStm.setString(1, username);
            ResultSet rs = readStm.executeQuery();
            while(rs.next()){
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String UserType=rs.getString("UserType");
                String Username = rs.getString("Username");
                String Password=rs.getString("Password");
                String Status = rs.getString("Status");
                user = new Person(FirstName,LastName, UserType, Username, Password, Status);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;

    }
    
    public ArrayList<Task> readTask(Person person){
        try {
            person.setTasks(tasks);
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            
            String create = "SELECT * FROM TaskTooDoo WHERE Username=?";
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1, person.getUserName());
            
            ResultSet rs = createStm.executeQuery();
            Task task;
            
            while(rs.next()){
                task = new Task(rs.getString("Task"));
                tasks.add(task);
            }
            person.setTasks(tasks);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }  
        person.setTasks(tasks);
        return tasks;   
    }
}
