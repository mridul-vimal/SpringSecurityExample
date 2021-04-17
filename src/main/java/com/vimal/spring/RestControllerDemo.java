package com.vimal.spring;

import com.vimal.spring.config.UserLoginDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class RestControllerDemo {

    @Autowired
    private UserLoginDetails userLoginDetails;

    @GetMapping("/")
    public ResponseEntity<String> sayHello(){
        log.info("Calling method SayHello ");

        return ResponseEntity.ok("Hello from Spring ");
    }
    @GetMapping("api/users")
    public ResponseEntity<UserDetails> getCurrentUserDetails(){
        log.info("Calling method SayHello ");
        UserDetails userDetails =  userLoginDetails.getCurrentUser();
        return ResponseEntity.ok(userDetails);
    }

}
