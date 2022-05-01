package com.iiitb.projectmanagementsystembackend.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","project"})
public class EffortTable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private int requirementAnalysisHours;

    @Column
    private int designingHours;

    @Column
    private int codingHours;

    @Column
    private int testingHours;

    @Column
    private int projectManagementHours;

    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public EffortTable(){

    }

    public EffortTable(long id, int requirementAnalysisHours, int designingHours, int codingHours, int testingHours, int projectManagementHours,  Project project) {
        this.id = id;
        this.requirementAnalysisHours = requirementAnalysisHours;
        this.designingHours = designingHours;
        this.codingHours = codingHours;
        this.testingHours = testingHours;
        this.projectManagementHours = projectManagementHours;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRequirementAnalysisHours() {
        return requirementAnalysisHours;
    }

    public void setRequirementAnalysisHours(int requirementAnalysisHours) {
        this.requirementAnalysisHours = requirementAnalysisHours;
    }

    public int getDesigningHours() {
        return designingHours;
    }

    public void setDesigningHours(int designingHours) {
        this.designingHours = designingHours;
    }

    public int getCodingHours() {
        return codingHours;
    }

    public void setCodingHours(int codingHours) {
        this.codingHours = codingHours;
    }

    public int getTestingHours() {
        return testingHours;
    }

    public void setTestingHours(int testingHours) {
        this.testingHours = testingHours;
    }

    public int getProjectManagementHours() {
        return projectManagementHours;
    }

    public void setProjectManagementHours(int projectManagementHours) {
        this.projectManagementHours = projectManagementHours;
    }


    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
