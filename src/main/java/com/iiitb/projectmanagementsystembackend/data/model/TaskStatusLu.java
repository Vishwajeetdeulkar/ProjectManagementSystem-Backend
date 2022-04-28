package com.iiitb.projectmanagementsystembackend.data.model;


import javax.persistence.*;

@Entity
public class TaskStatusLu {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;


    @Column
    private String statusname;

    @Column
    private String description;

    public TaskStatusLu() {
    }

    public TaskStatusLu(long id, String statusname, String description) {
        this.id = id;
        this.statusname = statusname;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
