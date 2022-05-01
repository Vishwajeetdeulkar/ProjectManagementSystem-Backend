package com.iiitb.projectmanagementsystembackend.service.impl;

import com.iiitb.projectmanagementsystembackend.data.model.*;
import com.iiitb.projectmanagementsystembackend.data.repository.*;
import com.iiitb.projectmanagementsystembackend.service.ManagerService;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.*;

@Service(value = "managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private  UserDao userDao;

    @Autowired
    private TaskStatusLuDao taskStatusLuDao;

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private EffortDao effortDao;

    @Autowired
    private UserService userService;

    @Override
    public List<Project> getAllProject(String username){

        List<Project> projects = new ArrayList<Project>();
        User user = userService.findOne(username);
        projectDao.getAllProjectByUserId(user.getId()).forEach(project -> projects.add(project));
        return  projects;
    }

    @Override
    public Project addProject(Map<String,String> payload,String username){
        Map<String,String> res = new HashMap<>();
        Project project = new Project();
        project.setProjectname(payload.get("name"));
        project.setDescription(payload.get("description"));
        User user = userService.findOne(username);
        Set<User> usersSet = new HashSet<>();
        usersSet.add(user);
        project.setUsers(usersSet);
        Project project1 = projectDao.save(project);


        return projectDao.findById(project1.getId());
    }

    @Override
    public Project updateProject(Map<String,String> payload)
    {
        Project project = projectDao.findById(Long.parseLong(payload.get("id")));
        project.setDescription(payload.get("description"));
        return projectDao.save(project);
    }

    @Override
    public Map<String,String> removeProject(Map<String,String> param)
    {
        projectDao.deleteById(Long.parseLong(param.get("projectId")));
        Map<String,String> res = new HashMap<>();
        res.put("msg","Project Remove");
        return  res;
    }

    @Override
    public List<User> getFreeEmployee(Map<String,String> param){
        System.out.println("in get free employee service");
        long id = Long.parseLong(param.get("projectId"));
        List<User> freeEmployee = userDao.getFreeEmployee(id);
        return freeEmployee;
    }

    @Override
    public Project addUserToProject(Map<String,Object> payload)
    {
//        System.out.println(param);
        long projectId = Long.valueOf((Integer)payload.get("projectId"));
        List<Integer> userIds = (List<Integer>)(payload.get("userId"));
        System.out.println(userIds.toString());
        Project project = projectDao.findById(projectId);
        Set<User> userSet = project.getUsers();
        userIds.forEach((id) -> userSet.add((userDao.findById((long)Long.valueOf(id)))));
//        userSet.add(userDao.findById(userId));
        project.setUsers(userSet);
        Project project1 = projectDao.save(project);
        return  project1;
    }

    @Override
    public Project removeUserFromProject(Map<String,String> param)
    {
        Project project = projectDao.findById(Long.parseLong(param.get("projectId")));
        User user = userDao.findById(Long.parseLong(param.get("userId")));
        Set<User> userSet = project.getUsers();
        userSet.remove(user);
        project.setUsers(userSet);
        Project project1 = projectDao.save(project);
        return  project1;
    }



    @Override
    public Project addTaskToProject(Map<String,String> payload){
        Project project = projectDao.findById(Long.parseLong(payload.get("projectId")));
        User user = userDao.findById(Long.parseLong(payload.get("userId")));
        TaskStatusLu taskStatusLu = taskStatusLuDao.findById(1);
        Task task = new Task();
        task.setTaskname(payload.get("name"));
        task.setDescription(payload.get("desc"));
        task.setProject(project);
        task.setUser(user);
        task.setStatusLu(taskStatusLu);
        taskDao.save(task);
        project = projectDao.findById(Long.parseLong(payload.get("projectId")));
        return project;
    }

    @Override
    public Project removeTaskFromProject(Map<String,String> param){
        taskDao.deleteById(Long.parseLong(param.get("taskId")));
        Project project= projectDao.findById(Long.parseLong(param.get("projectId")));
        return project;
    }



    @Override
    public Project updateEffortTable(Map<String,String> payload)
    {
        EffortTable effort = effortDao.findById(Long.parseLong(payload.get("effortId")));
        effort.setRequirementAnalysisHours(Integer.parseInt(payload.get("rah")));
        effort.setDesigningHours(Integer.parseInt(payload.get("dh")));
        effort.setCodingHours(Integer.parseInt(payload.get("ch")));
        effort.setTestingHours(Integer.parseInt(payload.get("th")));
        effort.setProjectManagementHours(Integer.parseInt(payload.get("pmh")));
        effortDao.save(effort);
        Project project = projectDao.findById(Long.parseLong(payload.get("projectId")));
        return  project;
    }

    @Override
    public Project initializeEffortTable(Project project)
    {
        EffortTable effort = new EffortTable();
        effort.setRequirementAnalysisHours(0);
        effort.setDesigningHours(0);
        effort.setCodingHours(0);
        effort.setTestingHours(0);
        effort.setProjectManagementHours(0);
        effort.setProject(project);
        effortDao.save(effort);
        Project project1 = projectDao.findById(project.getId());
        return project1;
    }

}
