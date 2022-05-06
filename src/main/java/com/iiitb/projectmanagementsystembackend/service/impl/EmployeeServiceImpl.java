package com.iiitb.projectmanagementsystembackend.service.impl;

import com.iiitb.projectmanagementsystembackend.data.model.Project;
import com.iiitb.projectmanagementsystembackend.data.model.Task;
import com.iiitb.projectmanagementsystembackend.data.model.TaskStatusLu;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.repository.ProjectDao;
import com.iiitb.projectmanagementsystembackend.data.repository.TaskDao;
import com.iiitb.projectmanagementsystembackend.data.repository.TaskStatusLuDao;
import com.iiitb.projectmanagementsystembackend.service.EmployeeService;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.TabableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskStatusLuDao taskStatusLuDao;

    @Override
    public List<Project> getAllProjects(String username)
    {
        List<Project> projects = new ArrayList<Project>();
        User user = userService.findOne(username);
        projectDao.getAllProjectByUserId(user.getId()).forEach(project -> projects.add(project));
        return  projects;
    }

    @Override
    public List<Task> getAllTaskByProjectByUser(Map<String,String> param,String username)
    {
        long projectId = Long.parseLong(param.get("projectId"));
        User user = userService.findOne(username);
        List<Task> taskList = taskDao.getAllByProjectAndUser(projectId,user.getId());
        return  taskList;
    }

    @Override
    public List<Task> updateTaskStatus(Map<String,String> payload,String username)
    {
        long taskId = Long.parseLong(payload.get("taskId"));
        long statusLuId  = Long.parseLong(payload.get("statusId"));
        long projectId = Long.parseLong(payload.get("projectId"));
        Task task = taskDao.findById(taskId);
        TaskStatusLu taskStatusLu = taskStatusLuDao.findById(statusLuId);
        task.setStatusLu(taskStatusLu);
        taskDao.save(task);
        User user = userService.findOne(username);
        List<Task> taskList = taskDao.getAllByProjectAndUser(projectId,user.getId());
        return  taskList;
    }
}
