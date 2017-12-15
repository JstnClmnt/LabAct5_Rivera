/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import java.sql.*;
import java.util.ArrayList;
import Helper.*;
import Model.*;
/**
 *
 * @author Justine Clemente
 */
public class LoginAction implements SessionAware{
    String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=ICS114Reference";
    
    private String username;
    private String password;
    private Map<String, Object> sessionMap;
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }
    
    public String execute(){
               try {
                
                Class.forName(dbDriver);
                Connection connect = DriverManager.getConnection(dbUrl, "sa", "8888");
                
                String create = "SELECT * FROM UsersTooDoo";
                PreparedStatement createStm = connect.prepareStatement(create);
                ResultSet rs = createStm.executeQuery();
                
                String page= "index.jsp";
                ArrayList<Task> tasks = new ArrayList<Task>();
                
                while (rs.next()) {
                    String usernameInput = rs.getString("Username");
                    String passwordInput = rs.getString("Password");
                
                    if (username.equals(usernameInput) && password.equals(passwordInput)) {

                        
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String userName = rs.getString("UserName");
                        String passWord = rs.getString("Password");
                        String userType = rs.getString("UserType");
                        String status = rs.getString("Status");
                        
                        Person person = new Person(firstName, lastName, userType, userName, passWord, status);
                        if(userType.equals("Admin")){
                            sessionMap.put("person", person);
                            sessionMap.put("userlog", "logged");
                            sessionMap.put("userList", new Read().readUsers());
                            return "SuccessAdmin";
                        }
                        
                        
                        sessionMap.put("buttonName","Add");
                        sessionMap.put("person", person);
                        sessionMap.put("userlog", "logged");
                        sessionMap.put("Tasks", new Read().readTask(person));
                        
                        
                        return "SuccessUser";
                    }     
                }
                sessionMap.put("Error","Invalid Credentials");
                return "Error";
            } catch (SQLException | ClassNotFoundException ex) {
                return "Error";
            }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
