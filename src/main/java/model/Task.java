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

        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne peut pas être vide");
        }

        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("La description ne peut pas être vide");
        }

        if (dueDate == null) {
            throw new IllegalArgumentException("La date d'échéance est obligatoire");
        }
        this.id = countid++;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.dueDate = dueDate;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getTitle(){
        return this.title;
    }

    public TaskStatus getStatus(){
        return this.status;
    }

    public long getId(){
        return this.id;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }


}
