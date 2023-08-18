package com.example.demo.controllersex2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController1 {
          
          @Value("${val}")
          private String studentName;

          @GetMapping("/")
          public String getName()
          {
        	  return "Welcome "+studentName+" !";
          }
}
