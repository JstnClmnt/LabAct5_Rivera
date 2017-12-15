/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import Model.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;
/**
 *
 * @author Justine Clemente
 */
public class Update {
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";

    public void update(String pastTask,String presentTask,Person person){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String create ="UPDATE TaskTooDoo SET Task=? WHERE Task=? AND Username=?" ;
            PreparedStatement createStm = connect.prepareStatement(create);
            createStm.setString(1,presentTask);
            createStm.setString(2,pastTask);
            createStm.setString(3,person.getUserName());
            createStm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
         person.setTasks(new Read().readTask(person));
    
    }
    
    public void UpdateUser(Person person){
        try {
            Class.forName(dbDriver);
            Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
            String create ="UPDATE UsersTooDoo SET Status=? WHERE Username=?" ;
            PreparedStatement createStm = connect.prepareStatement(create);
            if(person.getStatus().equals("Inactive")){
                createStm.setString(1,"Active");
            }
            else{
                createStm.setString(1,"Inactive");
            }
            createStm.setString(2,person.getUserName());
            createStm.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
}
