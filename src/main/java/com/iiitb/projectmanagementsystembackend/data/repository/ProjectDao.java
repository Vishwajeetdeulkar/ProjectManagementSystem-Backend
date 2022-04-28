package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectDao extends JpaRepository<Project,Long> {

    @Query(value = "SELECT * FROM project P WHERE P.id IN (SELECT UP.project_id FROM user_projects UP WHERE UP.users_id=?1) ",nativeQuery = true)
    List<Project> getAllProjectByUserId(long id);
}
