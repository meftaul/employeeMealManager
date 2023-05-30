package com.meftaul.emm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @GetMapping(value = "/test")
    public String sayHello() {
        return "Hello world";
    }

}

///users/{id}/test/{asd} <- Path variable
// /users?id=123 <- RequestParam
