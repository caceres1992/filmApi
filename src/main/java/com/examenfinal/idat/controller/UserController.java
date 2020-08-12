package com.examenfinal.idat.controller;

import com.examenfinal.idat.entity.User;
import com.examenfinal.idat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*",methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users/validate")
    public ResponseEntity<?> validate(@RequestBody User user){
        Map<String, Object> res = new HashMap<>();
        try {
            User userValidated = userService.validate(user.getUsername(), user.getPassword());
            if (userValidated == null) {
                res.put("msg", "Credenciales no válidas.");
                res.put("isValid", false);
            } else {
                res.put("user", userValidated);
                res.put("msg", "Credenciales válidas.");
                res.put("isValid", true);
            }
        } catch (DataAccessException e){
            res.put("msg", "Error en la base de datos.");
            res.put("error", "Error: " + e.getMessage().concat(" / ")
                    .concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
