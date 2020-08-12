package com.examenfinal.idat.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/")
@RestController
public class mainController {
    @GetMapping
    public String Message() {
        return "Hello todo esta funcionando";
    }
}
