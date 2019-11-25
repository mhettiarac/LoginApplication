package com.sample.login.controller;

import com.sample.login.entity.dto.UserDTO;
import com.sample.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** convert the class into a rest endpoint */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /** REST Method should be a verb aways**/

    @PostMapping("/user")
    public Boolean doLogin(@RequestBody UserDTO userDTO){
        return loginService.authenticateUser(userDTO);
    }
}
