package Model;

import java.io.Serializable;

public class Task implements Serializable{
    private String task;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Task(String task) {
        this.task = task;
    }

    public Task() {
    }
}
