package com.iiitb.projectmanagementsystembackend.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","project"})
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String taskname;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name="status_id")
    private TaskStatusLu statusLu;

    @ManyToOne
    @JoinColumn(name="project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Task() {
    }

    public Task(long id, String taskname, String description, TaskStatusLu statusLu, Project project, User user) {
        this.id = id;
        this.taskname = taskname;
        this.description = description;
        this.statusLu = statusLu;
        this.project = project;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatusLu getStatusLu() {
        return statusLu;
    }

    public void setStatusLu(TaskStatusLu statusLu) {
        this.statusLu = statusLu;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
