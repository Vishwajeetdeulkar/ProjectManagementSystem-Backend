package com.iiitb.projectmanagementsystembackend.controller;


import com.iiitb.projectmanagementsystembackend.config.TokenProvider;
import com.iiitb.projectmanagementsystembackend.data.model.AuthToken;
import com.iiitb.projectmanagementsystembackend.data.model.LoginUser;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        System.out.println(loginUser.getPassword());
        System.out.println(loginUser.getUsername());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }


    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value="/managerping", method = RequestMethod.GET)
    public ResponseEntity<?> managerPing(){
        Map<String ,String> res = new HashMap<>();
        res.put("msg","Only Manager Can Read This");
        return ResponseEntity.ok(res);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public ResponseEntity<?> adminPing(){
        Map<String ,String> res = new HashMap<>();
        res.put("msg","Only admin Can Read This");
        return ResponseEntity.ok(res);
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value="/employeeping", method = RequestMethod.GET)
    public ResponseEntity<?> employeePing(){
        Map<String ,String> res = new HashMap<>();
        res.put("msg","Only Employee Can Read This");
        return ResponseEntity.ok(res);
    }


}
