package com.iiitb.projectmanagementsystembackend.data.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Risk {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String description;

    @Column
    private String  status;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Risk(){

    }

    public Risk(long id, String description, String status, Project project) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
