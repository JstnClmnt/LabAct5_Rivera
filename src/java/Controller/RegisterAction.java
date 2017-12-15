/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import Model.*;
import Helper.*;
/**
 *
 * @author Justine Clemente
 */
public class RegisterAction implements SessionAware{
    private Map<String, Object> sessionMap;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }
    public String execute(){
        Person person=new Person(firstname,lastname,"User",username,password,"Active");
        new Add().addUser(person);
        sessionMap.put("person",person);
        sessionMap.put("buttonName","Add");
        sessionMap.put("Tasks", new Read().readTask(person));
        sessionMap.put("userlog","logged");
        return "success";
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
