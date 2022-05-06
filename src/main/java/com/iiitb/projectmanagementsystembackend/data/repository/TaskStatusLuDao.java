package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.TaskStatusLu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusLuDao extends CrudRepository<TaskStatusLu,Long> {
    public TaskStatusLu findById(long id);
}
