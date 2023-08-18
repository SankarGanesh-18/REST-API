package com.example.demo.controller1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
          
          @Value("${val}")
          private String name;

          @GetMapping("/")
          public String getName()
          {
        	  return name;
          }
}
