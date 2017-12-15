package Helper;


import Model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Add {
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";
    
    public void add(String task,Person person){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String create = "INSERT INTO TaskTooDoo VALUES(?,?);";
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1, task);
            createStm.setString(2, person.getUserName());
            createStm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        person.setTasks(new Read().readTask(person));
    }
    
    public void addUser(Person person){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String create = "INSERT INTO UsersTooDoo VALUES(?,?,?,?,?,?)";
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1, person.getFirstName());
            createStm.setString(2, person.getLastName());
            createStm.setString(3, person.getUserType());
            createStm.setString(4, person.getUserName());
            createStm.setString(5, person.getPassword());
            createStm.setString(6, person.getStatus());
            createStm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
