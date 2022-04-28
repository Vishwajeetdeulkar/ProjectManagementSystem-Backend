package com.iiitb.projectmanagementsystembackend.data.model;

import javax.persistence.*;

@Entity
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


}
