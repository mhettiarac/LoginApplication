package com.sample.login.controller;

import com.sample.login.entity.dto.LoginDTO;
import com.sample.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/** convert the class into a rest endpoint */
@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    private LoginService loginService;

    /** REST Method should be a verb aways**/

    @PostMapping("/user")
    public ResponseEntity<String> doLogin(@RequestBody LoginDTO userDTO){
        return loginService.authenticateSingleUser(userDTO);
    }

    @PostMapping("/jpa/user")
    public ResponseEntity<String> doJPALogin(@RequestBody LoginDTO userDTO){
        return loginService.authenticateUserthrouJPA(userDTO);
    }

    @PostMapping("/sql/user")
    public ResponseEntity<String> doSQLLogin(@RequestBody LoginDTO userDTO) throws SQLException, ClassNotFoundException {
        return loginService.authenticateUserthrouSQL(userDTO);
    }


}
