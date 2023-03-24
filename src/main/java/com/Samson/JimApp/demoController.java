package com.Samson.JimApp;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class demoController {
    @GetMapping("/api/v1/hello")
    public String sayHello(){
        return "hello bearer";
    }
}
