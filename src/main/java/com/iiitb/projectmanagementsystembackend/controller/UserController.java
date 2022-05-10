package com.iiitb.projectmanagementsystembackend.controller;


import com.iiitb.projectmanagementsystembackend.config.TokenProvider;
import com.iiitb.projectmanagementsystembackend.data.model.AuthToken;
import com.iiitb.projectmanagementsystembackend.data.model.LoginUser;
import com.iiitb.projectmanagementsystembackend.data.model.User;
import com.iiitb.projectmanagementsystembackend.data.model.UserDto;
import com.iiitb.projectmanagementsystembackend.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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


    private static final Logger logger = LogManager.getLogger("ProjectManagementSystem");

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateToken(@RequestBody Map<String,String> payload) throws AuthenticationException {
        try {
            LoginUser loginUser = new LoginUser();
            loginUser.setUsername(payload.get("username"));
            loginUser.setPassword(payload.get("password"));
            final Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginUser.getUsername(),
                            loginUser.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            final String token = jwtTokenUtil.generateToken(authentication);
            logger.info("[UserController] - [Generate Token]");
            return ResponseEntity.ok(new AuthToken(token));
        }catch (Exception e){
            logger.error("[UserController] - [Error in Generate Token]");
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody Map<String,String> payload){
       try {
           User user = userService.save(payload);
           logger.info("[UserController] - [Save User]");
           return ResponseEntity.ok(user);
       }catch (Exception e){
           logger.error("[UserController] - [Error in Save User]");
           return ResponseEntity.badRequest().body(e.getMessage());
       }

    }


    @PreAuthorize("hasRole('MANAGER')")
    @RequestMapping(value="/managerping", method = RequestMethod.GET)
    public ResponseEntity<?> managerPing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only Manager Can Read This");
            logger.info("[UserController] - [Manager Ping]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("[UserController] - [Error in Manager Ping]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/adminping", method = RequestMethod.GET)
    public ResponseEntity<?> adminPing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only admin Can Read This");
            logger.info("[UserController] - [Admin Ping]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("[UserController] - [Error in Admin Ping]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PreAuthorize("hasRole('EMPLOYEE')")
    @RequestMapping(value="/employeeping", method = RequestMethod.GET)
    public ResponseEntity<?> employeePing(){
        try {
            Map<String, String> res = new HashMap<>();
            res.put("msg", "Only Employee Can Read This");
            logger.info("[UserController] - [Employee Pin]");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("[UserController] - [Error in Employee Pin]");
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
