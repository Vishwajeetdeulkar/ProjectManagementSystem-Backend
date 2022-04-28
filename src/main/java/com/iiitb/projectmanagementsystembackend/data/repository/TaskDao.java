package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends CrudRepository<Task,Long> {

}
