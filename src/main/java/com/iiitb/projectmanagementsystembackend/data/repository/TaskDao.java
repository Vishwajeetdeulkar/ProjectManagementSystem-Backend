package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskDao extends CrudRepository<Task,Long> {
    public Task findById(long id);

    @Query(value = "SELECT * FROM task T WHERE T.project_id=?1 AND T.user_id=?2",nativeQuery = true)
    List<Task> getAllByProjectAndUser(long projectId,long userId);
}
