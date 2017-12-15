package Helper;



import Model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Delete {
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";
    
    public void delete(String task,Person person){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String create = "DELETE FROM TaskTooDoo WHERE Username=? AND Task=?";
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1, person.getUserName());
            createStm.setString(2,task);
            createStm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
        person.setTasks(new Read().readTask(person));
    
    }
    
}
