package com.iiitb.projectmanagementsystembackend.service.impl;


import java.util.*;

import com.iiitb.projectmanagementsystembackend.data.repository.UserDao;
import com.iiitb.projectmanagementsystembackend.data.model.Role;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.service.RoleService;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User save(Map<String,String> payload) {

//        User nUser = user.getUserFromDto();
        User nUser = new User();
        nUser.setUsername(payload.get("username"));
        nUser.setPassword(bcryptEncoder.encode(payload.get("password")));
        nUser.setName(payload.get("name"));
        nUser.setEmail(payload.get("email"));
        nUser.setBusinessTitle(payload.get("businessTitle"));
        nUser.setPhone(payload.get("phone"));
        Set<Role> roleSet = new HashSet<>();


        if(nUser.getEmail().split("@")[1].equals("admin.org")){
            Role role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }
        else if(nUser.getEmail().split("@")[1].equals("manager.org")){
            Role role = roleService.findByName("MANAGER");
            roleSet.add(role);
        }
        else if(nUser.getEmail().split("@")[1].equals("employee.org")){
            Role role = roleService.findByName("EMPLOYEE");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }
}
