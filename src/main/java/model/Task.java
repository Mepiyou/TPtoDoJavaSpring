package model;

import java.time.LocalDate;

public class Task {
    private  long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDate dueDate;
    private  static long countid = 1;

    public Task(String title, String description, LocalDate dueDate){
        this.id = countid++;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.dueDate = dueDate;
    }
}
