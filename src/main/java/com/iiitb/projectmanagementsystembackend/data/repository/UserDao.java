package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    public User findByUsername(String username);

    @Query(value = "SELECT * FROM user U INNER JOIN user_roles UR ON U.id = UR.user_id WHERE UR.role_id=2",nativeQuery= true)
    public List<User> getAllManager();

    @Query(value = "SELECT * FROM user U INNER JOIN user_roles UR ON U.id = UR.user_id WHERE UR.role_id=3",nativeQuery= true)
    public List<User> getAllEmployee();

    @Query(value = "DELETE  FROM user U WHERE U.id=?1",nativeQuery= true)
    public void deleteUser(long id);
}