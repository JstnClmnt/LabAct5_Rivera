/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Helper.Add;
import Helper.Delete;
import Helper.Update;
import Model.Person;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Justine Clemente
 */
public class ControlAction implements SessionAware{
    private Map<String, Object> sessionMap;
    private String button;
    private String taskAdd;
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap=map;
    }
    
    public String execute(){
        String[] param=button.split(",");
        String choice=param[0];
        Person person = (Person) sessionMap.get("person");
        if(person.getStatus().equals("Inactive")){
            sessionMap.put("Notify","Sorry, Your account is locked due to inactivity. Please Contact the Administrator.");
            return "success";
        }
       
        if(choice.equals("Delete")){
            String task =param[1];
            new Delete().delete(task, person);
            sessionMap.put("Tasks", person.getTasks());
            return "success";
        }
        
        else if(choice.equals("Update")){
            String presentTask=(String)sessionMap.get("presentTask");
            new Update().update(presentTask, taskAdd, person);
            sessionMap.put("Tasks", person.getTasks());
            sessionMap.put("buttonName", "Add");
            sessionMap.remove("presentTask");
            return "success";
        
        }
        else if(choice.equals("Add")){
            
            new Add().add(taskAdd,person);
            sessionMap.put("Tasks", person.getTasks());
            return "success";
        
        }
        else if(choice.equals("prepareUpdate")){
            String task =param[1];
            sessionMap.put("buttonName", "Update");
            sessionMap.put("presentTask",task);
            return "success";
        
        }
        
        return "failed";
    
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getTaskAdd() {
        return taskAdd;
    }

    public void setTaskAdd(String taskAdd) {
        this.taskAdd = taskAdd;
    }
    
}
