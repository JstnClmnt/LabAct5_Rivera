/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.Read;
import Helper.Update;
import Model.Person;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Justine Clemente
 */
public class AdminAction implements SessionAware {
    private Map<String, Object> sessionMap;
    private String adminButton;
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }
    
    public String execute(){
        String username=adminButton;
        Person person=(Person)sessionMap.get("person");
        Person update=new Read().readUser(username);
        new Update().UpdateUser(update);
        sessionMap.put("userList", new Read().readUsers());
        return "success";
    
    }

    public String getAdminButton() {
        return adminButton;
    }

    public void setAdminButton(String adminButton) {
        this.adminButton = adminButton;
    }
    
    
}
